package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.DependentTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DependentTest {
    @Test
    public void testCountryTable() throws Exception {
        DependentTable dependentTable = new DependentTable();
        String query = Converter.toCreateTableQuery(dependentTable.getTableName(),dependentTable.getAllAttributes());
        System.out.println(query);

    }
}
