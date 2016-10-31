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
import com.lindo.repositories.config.database.tables.domain_tables.SubscriberTable;
import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.domain.Subscriber;
import com.lindo.repositories.factories.DependentFactory;
import com.lindo.repositories.factories.SubscriberFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class SubscriberRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static SubscriberTable subscriberTable ;
    private static DependentTable dependentTable;


    public SubscriberRepo(Context context) {
        super(context, Database.name, null, Database.version);
        subscriberTable = new SubscriberTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(subscriberTable.getTableName(),subscriberTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + subscriberTable.getTableName());
        onCreate(db);
    }

    public boolean addSubscriber(Subscriber subscriber ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        subscriberTable  = new SubscriberTable();
        contentValues = new ContentValues();

        contentValues.put(subscriberTable.getAttributeId().name, subscriber.getId());
        contentValues.put(subscriberTable.getDependentID().name, subscriber.getDependent().getId());

        try {
            returned = localDatabase.insert(subscriberTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Subscriber findSubscriberById(long id) {
        Subscriber subscriberFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(subscriberTable.getTableName(),
                subscriberTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                subscriberFound = SubscriberFactory.getSubsciber(data.getLong(0), findDependentById(data.getInt(1)));
            }
        }
        return subscriberFound;
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

    public ArrayList<Subscriber> getDescription() {
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        Subscriber subscriberFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(subscriberTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                subscriberFound = SubscriberFactory.getSubsciber(data.getLong(0), findDependentById(data.getInt(1)));
                subscribers.add(subscriberFound);
            }
        }

        return subscribers;
    }

    public boolean updateSuscriber(Subscriber updateSubscriber, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(subscriberTable.getAttributeId().name,updateSubscriber.getId());
        contentValues.put(subscriberTable.getDependentID().name,updateSubscriber.getDependent().getId());

        try {

            returned =  localDatabase.update(subscriberTable.getTableName(),
                    contentValues,subscriberTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(subscriberTable.getTableName(),
                    subscriberTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}

