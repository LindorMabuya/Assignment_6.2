package com.lindo.repositories.database.tables_to_query;

import com.lindo.repositories.config.database.Converter;
import com.lindo.repositories.config.database.tables.domain_tables.DemographicInfoTable;

import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DemographicInfoTest {
    @Test
    public void testCountryTable() throws Exception {
        DemographicInfoTable demographicInfoTable = new DemographicInfoTable();
        String query = Converter.toCreateTableQuery(demographicInfoTable.getTableName(),demographicInfoTable.getAllAttributes());
        System.out.println(query);

    }
}
