package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.AddressTable;
import com.lindo.repositories.config.database.tables.domain_tables.DemographicInfoTable;
import com.lindo.repositories.domain.Address;
import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.factories.AddressFactory;
import com.lindo.repositories.factories.DemographicInfoFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DemographicInfoRepo extends SQLiteOpenHelper{
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static DemographicInfoTable demographicInfoTable ;
    private static AddressTable addressTable;

    public DemographicInfoRepo(Context context) {
        super(context, Database.name, null, Database.version);
        demographicInfoTable = new DemographicInfoTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(demographicInfoTable.getTableName(),demographicInfoTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + demographicInfoTable.getTableName());
        onCreate(db);
    }

    public boolean addDemographics(DemographicInfo demographicInfo ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        demographicInfoTable  = new DemographicInfoTable();
        contentValues = new ContentValues();

        contentValues.put(demographicInfoTable.getAttributeId().name, demographicInfo.getId());
        contentValues.put(demographicInfoTable.getAttributeAge().name, demographicInfo.getAge());
        contentValues.put(demographicInfoTable.getAttributeSex().name, demographicInfo.getSex());
        contentValues.put(demographicInfoTable.getAttributeMaritalStatus().name, demographicInfo.getMaritalStatus());
        contentValues.put(demographicInfoTable.getAttributeOccupation().name, demographicInfo.getOccupation());
        contentValues.put(demographicInfoTable.getAttributeSalary().name, demographicInfo.getSalary());
        contentValues.put(demographicInfoTable.getAddressID().name, demographicInfo.getAddress().getId());

        try {
            returned = localDatabase.insert(demographicInfoTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public DemographicInfo findDemographicsById(long id) {
        DemographicInfo demographicsFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(demographicInfoTable.getTableName(),
                demographicInfoTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                demographicsFound = DemographicInfoFactory.getDemographicInfo(data.getLong(0), data.getInt(1),
                        data.getString(2), data.getString(3), data.getString(4), data.getDouble(5), findAddressById(data.getInt(6)));
            }
        }
        return demographicsFound;
    }

    public Address findAddressById(long id) {
        Address addressFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(addressTable.getTableName(),
                addressTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                addressFound = AddressFactory.getAddress(data.getLong(0), data.getString(1),
                        data.getString(2), data.getInt(3));
            }
        }
        return addressFound;
    }

    public ArrayList<DemographicInfo> getAllDemographics() {
        ArrayList<DemographicInfo> demographicInfos = new ArrayList<>();
        DemographicInfo demographicsFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(demographicInfoTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                demographicsFound = DemographicInfoFactory.getDemographicInfo(data.getLong(0), data.getInt(1),
                        data.getString(2), data.getString(3), data.getString(4), data.getDouble(5), findAddressById(data.getInt(6)));
                demographicInfos.add(demographicsFound);
            }
        }

        return demographicInfos;
    }

    public boolean updateDemographics(DemographicInfo updatedDemographics, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(demographicInfoTable.getAttributeAge().name, updatedDemographics.getAge());
        contentValues.put(demographicInfoTable.getAttributeSex().name, updatedDemographics.getSex());
        contentValues.put(demographicInfoTable.getAttributeMaritalStatus().name, updatedDemographics.getMaritalStatus());
        contentValues.put(demographicInfoTable.getAttributeOccupation().name, updatedDemographics.getOccupation());
        contentValues.put(demographicInfoTable.getAttributeSalary().name, updatedDemographics.getSalary());
        contentValues.put(demographicInfoTable.getAddressID().name, updatedDemographics.getAddress().getId());

        try {

            returned =  localDatabase.update(demographicInfoTable.getTableName(),
                    contentValues,demographicInfoTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;
    }

    public boolean deleteById(long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();

        try {

            returned =  localDatabase.delete(demographicInfoTable.getTableName(),
                    demographicInfoTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
