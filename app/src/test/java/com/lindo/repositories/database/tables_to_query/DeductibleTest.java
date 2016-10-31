package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.DeductibleTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DeductibleTest {
    @Test
    public void testCountryTable() throws Exception {
        DeductibleTable deductibleTable = new DeductibleTable();
        String query = Converter.toCreateTableQuery(deductibleTable.getTableName(),deductibleTable.getAllAttributes());
        System.out.println(query);

    }
}
