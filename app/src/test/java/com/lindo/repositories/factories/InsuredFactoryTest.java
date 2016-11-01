package com.lindo.repositories.factories;

import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.domain.Insured;
import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.domain.Plan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class InsuredFactoryTest {
    private Insured insured;
    private DemographicInfo demographicInfo;
    private Physician physician;

    @Before
    public void setUp() throws Exception {
        insured = InsuredFactory.getInsured(1L,demographicInfo,physician);
    }

    @Test
    public void testInsured() throws Exception {
        Assert.assertNotNull(insured);
        Assert.assertEquals(1L, insured.getId());
    }

    @Test
    public void testInsuredUpdate() throws Exception {
        Insured newInsured = new Insured.Builder().copy(insured).id(2L).build();
        Assert.assertEquals(2L, newInsured.getId());
    }
}
