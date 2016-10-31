package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Dependent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DependentFactoryTest {
    private Dependent dependent;

    @Before
    public void setUp() throws Exception {
        dependent = DependentFactory.getDependent(1L,"husband");
    }

    @Test
    public void testDependent() throws Exception {
        Assert.assertNotNull(dependent);
        Assert.assertEquals("husband", dependent.getRelationToSubscriber());
    }

    @Test
    public void testDependentUpdate() throws Exception {
        Dependent newDependent = new Dependent.Builder().copy(dependent).relationToSubscriber("son").build();
        Assert.assertEquals("son", newDependent.getRelationToSubscriber());
    }
}
