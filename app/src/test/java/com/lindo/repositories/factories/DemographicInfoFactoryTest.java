package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Address;
import com.lindo.repositories.domain.DemographicInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DemographicInfoFactoryTest {
    private DemographicInfo demographicInfo;
    private Address address;

    @Before
    public void setUp() throws Exception {
        demographicInfo = DemographicInfoFactory.getDemographicInfo(1L,22,"female","single","doctor",12000,address);
    }

    @Test
    public void testDemographicInfo() throws Exception {
        Assert.assertNotNull(demographicInfo);
        Assert.assertEquals("female", demographicInfo.getSex());
    }

    @Test
    public void testDemographicInfoUpdate() throws Exception {
        DemographicInfo newDemographicInfo = new DemographicInfo.Builder().copy(demographicInfo).maritalStatus("married").build();
        Assert.assertEquals("married", newDemographicInfo.getMaritalStatus());
    }
}
