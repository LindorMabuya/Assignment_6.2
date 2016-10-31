package com.lindo.repositories;

import com.lindo.repositories.factories.AddressFactoryTest;
import com.lindo.repositories.factories.CoverageFactoryTest;
import com.lindo.repositories.factories.DeductibleFactoryTest;
import com.lindo.repositories.factories.DemographicInfoFactoryTest;
import com.lindo.repositories.factories.DependentFactoryTest;
import com.lindo.repositories.factories.HospitalFactoryTest;
import com.lindo.repositories.factories.InsuredFactoryTest;
import com.lindo.repositories.factories.PayerFactoryTest;
import com.lindo.repositories.factories.PhysicianFactoryTest;
import com.lindo.repositories.factories.PlanFactoryTest;
import com.lindo.repositories.factories.SubscriberFactoryTest;
import com.lindo.repositories.factories.ThirdPartyFactoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Created by bishop v on 2016-10-31.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressFactoryTest.class,
        CoverageFactoryTest.class,
        DeductibleFactoryTest.class,
        DemographicInfoFactoryTest.class,
        DependentFactoryTest.class,
        HospitalFactoryTest.class,
        InsuredFactoryTest.class,
        PayerFactoryTest.class,
        PhysicianFactoryTest.class,
        PlanFactoryTest.class,
        SubscriberFactoryTest.class,
        ThirdPartyFactoryTest.class
})

public class AppTestSuite {
}
