package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.DependentTable;
import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.factories.DependentFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DependentRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static DependentTable dependentTable ;



    public DependentRepo(Context context) {
        super(context, Database.name, null, Database.version);
        dependentTable = new DependentTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(dependentTable.getTableName(),dependentTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + dependentTable.getTableName());
        onCreate(db);
    }

    public boolean addDependent(Dependent dependent ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        dependentTable  = new DependentTable();
        contentValues = new ContentValues();

        contentValues.put(dependentTable.getAttributeId().name, dependent.getId());
        contentValues.put(dependentTable.getAtttributeRelationToSubscriber().name, dependent.getRelationToSubscriber());

        try {
            returned = localDatabase.insert(dependentTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Dependent findDependentById(long id) {
        Dependent dependentFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(dependentTable.getTableName(),
                dependentTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                dependentFound = DependentFactory.getDependent(data.getLong(0), data.getString(1));
            }
        }
        return dependentFound;
    }

    public ArrayList<Dependent> getAllDependecies() {
        ArrayList<Dependent> dependents = new ArrayList<>();
        Dependent dependentFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(dependentTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                dependentFound = DependentFactory.getDependent(data.getLong(0), data.getString(1));
                dependents.add(dependentFound);
            }
        }

        return dependents;
    }

    public boolean updateDependents(Dependent updatedDependencies, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(dependentTable.getAtttributeRelationToSubscriber().name,updatedDependencies.getRelationToSubscriber());

        try {

            returned =  localDatabase.update(dependentTable.getTableName(),
                    contentValues,dependentTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(dependentTable.getTableName(),
                    dependentTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}

