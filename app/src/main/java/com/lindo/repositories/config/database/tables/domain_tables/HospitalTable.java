package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class HospitalTable extends Table {

    private final String tableName = "hospital";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute hospitalName = new Attribute("hospitalName", "TEXT");

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

    public Attribute getAttributeHospitalName() {
        return hospitalName;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(hospitalName);

        return  attributes;
    }

}
