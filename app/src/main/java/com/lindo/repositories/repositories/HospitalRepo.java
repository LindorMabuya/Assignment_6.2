package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.HospitalTable;
import com.lindo.repositories.domain.Hospital;
import com.lindo.repositories.factories.HospitalFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class HospitalRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static HospitalTable hospitalTable ;


    public HospitalRepo(Context context) {
        super(context, Database.name, null, Database.version);
        hospitalTable = new HospitalTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(hospitalTable.getTableName(),hospitalTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + hospitalTable.getTableName());
        onCreate(db);
    }

    public boolean addHospital(Hospital hospital ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        hospitalTable  = new HospitalTable();
        contentValues = new ContentValues();

        contentValues.put(hospitalTable.getAttributeId().name, hospital.getId());
        contentValues.put(hospitalTable.getAttributeHospitalName().name, hospital.getHospitalName());

        try {
            returned = localDatabase.insert(hospitalTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Hospital findHospitalById(long id) {
        Hospital hospitalFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(hospitalTable.getTableName(),
                hospitalTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                hospitalFound = HospitalFactory.getHospital(data.getLong(0), data.getString(1));
            }
        }
        return hospitalFound;
    }

    public ArrayList<Hospital> getAllHospitals() {
        ArrayList<Hospital> hospitals = new ArrayList<>();
        Hospital hospitalFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(hospitalTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                hospitalFound = HospitalFactory.getHospital(data.getLong(0), data.getString(1));
                hospitals.add(hospitalFound);
            }
        }

        return hospitals;
    }

    public boolean updateHospital(Hospital updatedHospital, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(hospitalTable.getAttributeHospitalName().name,updatedHospital.getHospitalName());


        try {

            returned =  localDatabase.update(hospitalTable.getTableName(),
                    contentValues,hospitalTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(hospitalTable.getTableName(),
                    hospitalTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}

