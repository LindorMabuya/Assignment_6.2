package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.CoverageTable;
import com.lindo.repositories.domain.Coverage;
import com.lindo.repositories.factories.CoverageFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class CoverageRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static CoverageTable coverageTable ;

    public CoverageRepo(Context context) {
        super(context, Database.name, null, Database.version);
        coverageTable = new CoverageTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(coverageTable.getTableName(),coverageTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + coverageTable.getTableName());
        onCreate(db);
    }

    public boolean addCoverage(Coverage coverage ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        coverageTable  = new CoverageTable();
        contentValues = new ContentValues();

       // contentValues.put(coverage.getAttributeId().name, coverage.getId());

        try {
            returned = localDatabase.insert(coverageTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Coverage findCoverageById(long id) {
        Coverage coverageFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(coverageTable.getTableName(),
                coverageTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                coverageFound = CoverageFactory.getCoverage(data.getLong(0));
            }
        }
        return coverageFound;
    }

    public ArrayList<Coverage> getAllCoverage() {
        ArrayList<Coverage> coverages = new ArrayList<>();
        Coverage coverageFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(coverageTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                coverageFound = CoverageFactory.getCoverage(data.getLong(0));
                coverages.add(coverageFound);
            }
        }

        return coverages;
    }

    public boolean updateCoverage(Coverage updatedCoverage, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();

        try {

            returned =  localDatabase.update(coverageTable.getTableName(),
                    contentValues,coverageTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(coverageTable.getTableName(),
                    coverageTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
