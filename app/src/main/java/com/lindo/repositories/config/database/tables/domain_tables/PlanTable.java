package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PlanTable extends Table {

    private final String tableName = "plan";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute deductibleID = new Attribute("deductibleID", "INTEGER");
    private final Attribute benefitSetID = new Attribute("benefitSetID", "INTEGER");
    private final Attribute payerID = new Attribute("payerID", "INTEGER");

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

    public Attribute getDeductibleID() {
        return deductibleID;
    }

    public Attribute getBenefitSetID() {
        return benefitSetID;
    }

    public Attribute getPayerID() {
        return payerID;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(deductibleID);
        attributes.add(benefitSetID);
        attributes.add(payerID);

        return  attributes;
    }
}
