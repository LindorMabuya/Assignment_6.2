package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.PhysicianTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PhysicianTest {
    @Test
    public void testCountryTable() throws Exception {
        PhysicianTable physicianTable = new PhysicianTable();
        String query = Converter.toCreateTableQuery(physicianTable.getTableName(),physicianTable.getAllAttributes());
        System.out.println(query);

    }
}
