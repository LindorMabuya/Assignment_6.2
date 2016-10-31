package com.lindo.repositories.config.database.tables.domain_tables;

import com.lindo.repositories.config.database.tables.Attribute;
import com.lindo.repositories.config.database.tables.Table;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DemographicInfoTable extends Table {

    private final String tableName = "demographicInfo";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute age = new Attribute("age", "INTEGER");
    private final Attribute sex = new Attribute("sex", "TEXT");
    private final Attribute maritalStatus = new Attribute("maritalStatus", "TEXT");
    private final Attribute occupation = new Attribute("occupation", "TEXT");
    private final Attribute salary = new Attribute("salary", "double");
    private final Attribute addressID = new Attribute("addressID", "INTEGER");

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

    public Attribute getAttributeAge() {
        return age;
    }

    public Attribute getAttributeSex() {
        return sex;
    }

    public Attribute getAttributeMaritalStatus() {
        return maritalStatus;
    }

    public Attribute getAttributeOccupation() {
        return occupation;
    }

    public Attribute getAttributeSalary() {
        return salary;
    }

    public Attribute getAddressID() {
        return addressID;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(age);
        attributes.add(sex);
        attributes.add(maritalStatus);
        attributes.add(occupation);
        attributes.add(salary);
        attributes.add(addressID);

        return  attributes;
    }

}
