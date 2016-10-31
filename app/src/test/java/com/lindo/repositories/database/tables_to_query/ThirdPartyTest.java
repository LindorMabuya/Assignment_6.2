package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.ThirdPartyTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class ThirdPartyTest {
    @Test
    public void testCountryTable() throws Exception {
        ThirdPartyTable thirdPartyTable = new ThirdPartyTable();
        String query = Converter.toCreateTableQuery(thirdPartyTable.getTableName(),thirdPartyTable.getAllAttributes());
        System.out.println(query);

    }
}
