package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.HospitalTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class HospitalTest {
    @Test
    public void testCountryTable() throws Exception {
        HospitalTable hospitalTable = new HospitalTable();
        String query = Converter.toCreateTableQuery(hospitalTable.getTableName(),hospitalTable.getAllAttributes());
        System.out.println(query);

    }
}
