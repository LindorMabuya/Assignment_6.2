package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.AddressTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class AddressTest {
    @Test
    public void testAddressTable() throws Exception {
        AddressTable addressTable = new AddressTable();
        String query = Converter.toCreateTableQuery(addressTable.getTableName(),addressTable.getAllAttributes());
        System.out.println(query);

    }
}
