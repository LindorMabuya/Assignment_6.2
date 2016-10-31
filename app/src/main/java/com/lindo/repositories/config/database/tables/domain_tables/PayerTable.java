package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PayerTable extends Table {

    private final String tableName = "payer";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute planID = new Attribute("planID", "INTEGER");

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

    public Attribute getPlanID() {
        return planID;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(planID);

        return  attributes;
    }


}
