package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.PhysicianTable;
import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.factories.PhysicianFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PhysicianRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static PhysicianTable physicianTable ;


    public PhysicianRepo(Context context) {
        super(context, Database.name, null, Database.version);
        physicianTable = new PhysicianTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(physicianTable.getTableName(),physicianTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + physicianTable.getTableName());
        onCreate(db);
    }

    public boolean addPhysician(Physician physician ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        physicianTable  = new PhysicianTable();
        contentValues = new ContentValues();

        contentValues.put(physicianTable.getAttributeId().name, physician.getId());
        contentValues.put(physicianTable.getAttributeName().name, physician.getName());
        contentValues.put(physicianTable.getAttributeOffice().name, physician.getOffice());

        try {
            returned = localDatabase.insert(physicianTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
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

    public ArrayList<Physician> getAllPhysicians() {
        ArrayList<Physician> physicianArrayList = new ArrayList<>();
        Physician physicianFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(physicianTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                physicianFound = PhysicianFactory.getPhysician(data.getLong(0), data.getString(1),
                        data.getString(2));
                physicianArrayList.add(physicianFound);
            }
        }

        return physicianArrayList;
    }

    public boolean updatePhysician(Physician updatedPhysician, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(physicianTable.getAttributeName().name, updatedPhysician.getName());
        contentValues.put(physicianTable.getAttributeOffice().name, updatedPhysician.getOffice());


        try {

            returned =  localDatabase.update(physicianTable.getTableName(),
                    contentValues,physicianTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(physicianTable.getTableName(),
                    physicianTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
