package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Payer;
import com.lindo.repositories.domain.Plan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PayerFactoryTest {
    private Payer payer;
    private Plan plan;

    @Before
    public void setUp() throws Exception {
        payer = PayerFactory.getPayer(1L,plan);
    }

    @Test
    public void testPayer() throws Exception {
        Assert.assertNotNull(payer);
        Assert.assertEquals(1L, payer.getId());
    }

    @Test
    public void testPayerUpdate() throws Exception {
        Payer newPayer = new Payer.Builder().copy(payer).id(2L).build();
        Assert.assertEquals(2L, newPayer.getId());
    }
}
