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
import com.lindo.repositories.config.database.tables.domain_tables.InsuredTable;
import com.lindo.repositories.config.database.tables.domain_tables.PhysicianTable;
import com.lindo.repositories.domain.Address;
import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.domain.Insured;
import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.factories.AddressFactory;
import com.lindo.repositories.factories.DemographicInfoFactory;
import com.lindo.repositories.factories.InsuredFactory;
import com.lindo.repositories.factories.PhysicianFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-11-01.
 */
public class InsuredRepo  extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static InsuredTable insuredTable ;
    private static DemographicInfoTable demographicInfoTable;
    private static PhysicianTable physicianTable;
    private static AddressTable addressTable;


    public InsuredRepo(Context context) {
        super(context, Database.name, null, Database.version);
        insuredTable = new InsuredTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(insuredTable.getTableName(),insuredTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + insuredTable.getTableName());
        onCreate(db);
    }

    public boolean addInsurance(Insured insured ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        insuredTable  = new InsuredTable();
        contentValues = new ContentValues();

        contentValues.put(insuredTable.getAttributeId().name, insured.getId());
        contentValues.put(insuredTable.getDemographicInfoID().name, insured.getDemographicInfo().getId());
        contentValues.put(insuredTable.getPhysicianID().name, insured.getPhysician().getId());

        try {
            returned = localDatabase.insert(insuredTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Insured findInsuranceById(long id) {
        Insured insuredFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(insuredTable.getTableName(),
                insuredTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                insuredFound = InsuredFactory.getInsured(data.getLong(0), findDemographicsById(data.getLong(1)), findPhysicianById(data.getLong(2)));
            }
        }
        return insuredFound;
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
    public Physician findPhysicianById(long id) {
        Physician physicianFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(physicianTable.getTableName(),
                physicianTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                physicianFound = PhysicianFactory.getPhysician(data.getLong(0), data.getString(1),
                        data.getString(2));
            }
        }
        return physicianFound;
    }

    public ArrayList<Insured> getAllInsurances() {
        ArrayList<Insured> insuredArrayList = new ArrayList<>();
        Insured insuredFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(insuredTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                insuredFound = InsuredFactory.getInsured(data.getLong(0), findDemographicsById(data.getLong(1)), findPhysicianById(data.getLong(2)));
                insuredArrayList.add(insuredFound);
            }
        }

        return insuredArrayList;
    }

    public boolean updateInsurance(Insured insuredUpdate, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(insuredTable.getDemographicInfoID().name,insuredUpdate.getDemographicInfo().getId());
        contentValues.put(insuredTable.getPhysicianID().name,insuredUpdate.getPhysician().getId());

        try {

            returned =  localDatabase.update(insuredTable.getTableName(),
                    contentValues,insuredTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(insuredTable.getTableName(),
                    insuredTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}

