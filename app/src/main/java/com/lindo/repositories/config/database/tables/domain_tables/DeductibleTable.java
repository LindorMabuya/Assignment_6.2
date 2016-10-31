package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DeductibleTable extends Table {

    private final String tableName = "deductible";
    private final Attribute id = new Attribute("id", "INTEGER");

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

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);

        return  attributes;
    }
}
