package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.InsuredTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class InsuredTest {
    @Test
    public void testCountryTable() throws Exception {
        InsuredTable insuredTable = new InsuredTable();
        String query = Converter.toCreateTableQuery(insuredTable.getTableName(),insuredTable.getAllAttributes());
        System.out.println(query);

    }
}
