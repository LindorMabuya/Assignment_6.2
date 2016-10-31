package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by Lindo on 2016-10-31.
 */
public class CoverageTable extends Table {

    private final String tableName = "coverage";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute coverAmount = new Attribute("coverAmount", "DOUBLE");

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

    public Attribute getAttributeCoverAmount() {
        return coverAmount;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(coverAmount);

        return  attributes;
    }
}
