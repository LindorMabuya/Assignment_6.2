package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.PlanTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PlanTest {
    @Test
    public void testCountryTable() throws Exception {
        PlanTable planTable = new PlanTable();
        String query = Converter.toCreateTableQuery(planTable.getTableName(),planTable.getAllAttributes());
        System.out.println(query);

    }
}
