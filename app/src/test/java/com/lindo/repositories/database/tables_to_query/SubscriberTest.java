package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.SubscriberTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class SubscriberTest {
    @Test
    public void testCountryTable() throws Exception {
        SubscriberTable subscriberTable = new SubscriberTable();
        String query = Converter.toCreateTableQuery(subscriberTable.getTableName(),subscriberTable.getAllAttributes());
        System.out.println(query);

    }
}
