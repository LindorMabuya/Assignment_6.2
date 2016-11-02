package com.lindo.repositories.services;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Address;
import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.factories.DemographicInfoFactory;
import com.lindo.repositories.repositories.DemographicInfoRepo;

public class DemographicInfoTest extends AndroidTestCase {
    private DemographicInfoRepo demographicInfoRepo;
    private static Address address;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        demographicInfoRepo = new DemographicInfoRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        demographicInfoRepo.close();
        super.tearDown();
    }

    public void addDemographicsTest() {
        DemographicInfo demographicInfo = DemographicInfoFactory.getDemographicInfo((long) 16.0, 23, "female", "single", "doctor", 22000, address);
        assertEquals(true, demographicInfoRepo.addDemographics(demographicInfo));
    }

    public void findDemographicsById() {
        DemographicInfo demographicInfo = demographicInfoRepo.findDemographicsById((long)16.0);
        assertEquals("single", demographicInfo.getMaritalStatus());
    }
}

