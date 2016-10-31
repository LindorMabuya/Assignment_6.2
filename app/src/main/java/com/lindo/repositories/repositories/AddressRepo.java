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
import com.lindo.repositories.domain.Address;
import com.lindo.repositories.factories.AddressFactory;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class AddressRepo extends SQLiteOpenHelper{

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static AddressTable addressTable;

    public AddressRepo(Context context) {
        super(context, Database.name, null, Database.version);
        addressTable = new AddressTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(addressTable.getTableName(),addressTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + addressTable.getTableName());
        onCreate(db);
    }

    public boolean addAddress(Address address ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        addressTable  = new AddressTable();
        contentValues = new ContentValues();

        contentValues.put(addressTable.getAttributeId().name, address.getId());
        contentValues.put(addressTable.getAttributeStreetName().name, address.getStreetName());
        contentValues.put(addressTable.getAttributeCity().name, address.getCity());
        contentValues.put(addressTable.getAttributeZipCode().name, address.getZipCode());

        try {
            returned = localDatabase.insert(addressTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
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

    public ArrayList<Address> getAllAddresses() {
        ArrayList<Address> addresses = new ArrayList<>();
        Address addressFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(addressTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                addressFound = AddressFactory.getAddress(data.getLong(0), data.getString(1),
                        data.getString(2), data.getInt(3));
                addresses.add(addressFound);
            }
        }

        return addresses;
    }

    public boolean updateAddress(Address updatedAddress, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(addressTable.getAttributeStreetName().name,updatedAddress.getStreetName());
        contentValues.put(addressTable.getAttributeCity().name,updatedAddress.getCity());
        contentValues.put(addressTable.getAttributeZipCode().name,updatedAddress.getZipCode());

        try {

            returned =  localDatabase.update(addressTable.getTableName(),
                    contentValues,addressTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(addressTable.getTableName(),
                    addressTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
