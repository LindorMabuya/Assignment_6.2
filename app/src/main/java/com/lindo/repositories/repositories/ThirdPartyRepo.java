package com.lindo.repositories.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.Database;
import com.lindo.repositories.config.database.tables.domain_tables.ThirdPartyTable;
import com.lindo.repositories.domain.ThirdParty;
import com.lindo.repositories.factories.ThirdPartyFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class ThirdPartyRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static ThirdPartyTable thirdPartyTable ;


    public ThirdPartyRepo(Context context) {
        super(context, Database.name, null, Database.version);
        thirdPartyTable = new ThirdPartyTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(thirdPartyTable.getTableName(),thirdPartyTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + thirdPartyTable.getTableName());
        onCreate(db);
    }

    public boolean addParty(ThirdParty thirdParty ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        thirdPartyTable  = new ThirdPartyTable();
        contentValues = new ContentValues();

        contentValues.put(thirdPartyTable.getAttributeId().name, thirdParty.getId());
        contentValues.put(thirdPartyTable.getAttributeName().name, thirdParty.getName());
        contentValues.put(thirdPartyTable.getAttributeRelations().name, thirdParty.getRelations());

        try {
            returned = localDatabase.insert(thirdPartyTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public ThirdParty findPartyById(long id) {
        ThirdParty partyFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(thirdPartyTable.getTableName(),
                thirdPartyTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                partyFound = ThirdPartyFactory.getThirdParty(data.getLong(0), data.getString(1),
                        data.getString(2));
            }
        }
        return partyFound;
    }

    public ArrayList<ThirdParty> getAllParties() {
        ArrayList<ThirdParty> parties = new ArrayList<>();
        ThirdParty partyFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(thirdPartyTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                partyFound = ThirdPartyFactory.getThirdParty(data.getLong(0), data.getString(1),
                        data.getString(2));
                parties.add(partyFound);
            }
        }

        return parties;
    }

    public boolean updateParty(ThirdParty updatedParty, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(thirdPartyTable.getAttributeName().name, updatedParty.getName());
        contentValues.put(thirdPartyTable.getAttributeName().name, updatedParty.getName());
        contentValues.put(thirdPartyTable.getAttributeRelations().name,updatedParty.getRelations());

        try {

            returned =  localDatabase.update(thirdPartyTable.getTableName(),
                    contentValues,thirdPartyTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(thirdPartyTable.getTableName(),
                    thirdPartyTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}

