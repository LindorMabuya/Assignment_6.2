package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.DeductibleTable;
import com.lindo.repositories.domain.Deductible;
import com.lindo.repositories.factories.DeductibleFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DeductibleRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static DeductibleTable deductibleTable ;

    public DeductibleRepo(Context context) {
        super(context, Database.name, null, Database.version);
        deductibleTable = new DeductibleTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(deductibleTable.getTableName(),deductibleTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + deductibleTable.getTableName());
        onCreate(db);
    }

    public boolean addDeductible(Deductible deductible ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        deductibleTable  = new DeductibleTable();
        contentValues = new ContentValues();

        // contentValues.put(deductible.getAttributeId().name, deductible.getId());

        try {
            returned = localDatabase.insert(deductibleTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Deductible findDeductibleById(long id) {
        Deductible deductibleFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(deductibleTable.getTableName(),
                deductibleTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                deductibleFound = DeductibleFactory.getDeductible(data.getLong(0));
            }
        }
        return deductibleFound;
    }

    public ArrayList<Deductible> getAllDeductions() {
        ArrayList<Deductible> deductibles = new ArrayList<>();
        Deductible deductibleFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(deductibleTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                deductibleFound = DeductibleFactory.getDeductible(data.getLong(0));
                deductibles.add(deductibleFound);
            }
        }

        return deductibles;
    }

    public boolean updateDeductions(Deductible updatedDeduction, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();

        try {

            returned =  localDatabase.update(deductibleTable.getTableName(),
                    contentValues,deductibleTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(deductibleTable.getTableName(),
                    deductibleTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
