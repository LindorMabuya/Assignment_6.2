package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by Lindo on 2016-10-31.
 */
public class AddressTable extends Table{

    private final String tableName = "address";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute streetName = new Attribute("streetName", "TEXT");
    private final Attribute city = new Attribute("city", "TEXT");
    private final Attribute zipCode = new Attribute("zipCode", "INTEGER");

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
    }

    public Attribute getAttributeId() {
        return id;
    }

    public Attribute getAttributeStreetName() {
        return streetName;
    }

    public Attribute getAttributeCity() {
        return city;
    }

    public Attribute getAttributeZipCode() {
        return zipCode;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(streetName);
        attributes.add(city);
        attributes.add(zipCode);

        return  attributes;
    }
}
