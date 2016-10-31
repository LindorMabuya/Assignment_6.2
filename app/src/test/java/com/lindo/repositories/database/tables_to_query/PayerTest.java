package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.PayerTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PayerTest {
    @Test
    public void testCountryTable() throws Exception {
        PayerTable payerTable = new PayerTable();
        String query = Converter.toCreateTableQuery(payerTable.getTableName(),payerTable.getAllAttributes());
        System.out.println(query);

    }
}
