package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Deductible;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DeductibleFactoryTest {
    private Deductible deductible;

    @Before
    public void setUp() throws Exception {
        deductible = DeductibleFactory.getDeductible(1L, 120);
    }

    @Test
    public void testDeductible() throws Exception {
        deductible.isDeductible();
        Assert.assertNotNull(deductible);
        Assert.assertEquals(1L, deductible.getId());
    }

    @Test
    public void testDeductibleUpdate() throws Exception {
        Deductible newDeductible = new Deductible.Builder().copy(deductible).id(2L).build();
        Assert.assertEquals(2L, newDeductible.getId());
    }
}
