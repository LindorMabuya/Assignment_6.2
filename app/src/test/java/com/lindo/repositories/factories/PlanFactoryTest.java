package com.lindo.repositories.factories;

import com.lindo.repositories.domain.BenefitSet;
import com.lindo.repositories.domain.Deductible;
import com.lindo.repositories.domain.Payer;
import com.lindo.repositories.domain.Plan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PlanFactoryTest {
    private Plan plan;
    private Deductible deductible;
    private BenefitSet benefitSet;
    private Payer payer;

    private BenefitSet newBenefit;

    @Before
    public void setUp() throws Exception {
        plan = PlanFactory.getPlan(1L, deductible, benefitSet, payer);
    }

    @Test
    public void testPlan() throws Exception {
        Assert.assertNotNull(plan);
        Assert.assertEquals(payer, plan.getPayer());
    }

    @Test
    public void testPlanUpdate() throws Exception {
        Plan newPlan = new Plan.Builder().copy(plan).benefitSets(newBenefit).build();
        Assert.assertEquals(newBenefit, newPlan.getBenefitSets());
    }
}