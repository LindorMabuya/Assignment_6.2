package com.lindo.repositories.database;

import com.lindo.repositories.database.tables_to_query.AddressTest;
import com.lindo.repositories.database.tables_to_query.CoverageTest;
import com.lindo.repositories.database.tables_to_query.DeductibleTest;
import com.lindo.repositories.database.tables_to_query.DemographicInfoTest;
import com.lindo.repositories.database.tables_to_query.DependentTest;
import com.lindo.repositories.database.tables_to_query.HospitalTest;
import com.lindo.repositories.database.tables_to_query.InsuredTest;
import com.lindo.repositories.database.tables_to_query.PayerTest;
import com.lindo.repositories.database.tables_to_query.PhysicianTest;
import com.lindo.repositories.database.tables_to_query.PlanTest;
import com.lindo.repositories.database.tables_to_query.SubscriberTest;
import com.lindo.repositories.database.tables_to_query.ThirdPartyTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by bishop v on 2016-10-31.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        CoverageTest.class,
        DeductibleTest.class,
        DemographicInfoTest.class,
        DependentTest.class,
        HospitalTest.class,
        InsuredTest.class,
        PayerTest.class,
        PhysicianTest.class,
        PlanTest.class,
        SubscriberTest.class,
        ThirdPartyTest.class
})
public class AppTestSuite {
}
