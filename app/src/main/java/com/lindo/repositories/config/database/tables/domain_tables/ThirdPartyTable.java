package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class ThirdPartyTable extends Table {

    private final String tableName = "thirdParty";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute name = new Attribute("name", "TEXT");
    private final Attribute relations = new Attribute("relations", "TEXT");

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

    public Attribute getAttributeRelations() {
        return relations;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(relations);

        return  attributes;
    }

}
