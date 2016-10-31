package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.CoverageTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class CoverageTest {
    @Test
    public void testCountryTable() throws Exception {
        CoverageTable coverageTable = new CoverageTable();
        String query = Converter.toCreateTableQuery(coverageTable.getTableName(),coverageTable.getAllAttributes());
        System.out.println(query);

    }
}
