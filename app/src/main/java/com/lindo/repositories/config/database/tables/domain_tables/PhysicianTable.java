package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PhysicianTable extends Table {

    private final String tableName = "physician";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute name = new Attribute("name", "TEXT");
    private final Attribute office = new Attribute("office", "TEXT");

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

    public Attribute getAttributeName() {
        return name;
    }

    public Attribute getAttributeOffice() {
        return office;
    }



    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(office);

        return  attributes;
    }

}
