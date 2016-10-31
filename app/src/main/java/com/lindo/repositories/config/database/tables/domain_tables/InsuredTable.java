package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class InsuredTable extends Table {

    private final String tableName = "insured";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute planID = new Attribute("planID", "INTEGER");
    private final Attribute demographicInfoID = new Attribute("demographicInfoID", "INTEGER");
    private final Attribute physicianID = new Attribute("physician", "INTEGER");

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

    public Attribute getDemographicInfoID() {
        return demographicInfoID;
    }

    public Attribute getPhysicianID() {
        return physicianID;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(planID);
        attributes.add(demographicInfoID);
        attributes.add(physicianID);

        return  attributes;
    }
}
