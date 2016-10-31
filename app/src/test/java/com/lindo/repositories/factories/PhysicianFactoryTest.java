package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Physician;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PhysicianFactoryTest {
    private Physician physician;

    @Before
    public void setUp() throws Exception {
        physician = PhysicianFactory.getPhysician(1L,"Dr Lee","surgery");
    }

    @Test
    public void testPhysician() throws Exception {
        Assert.assertNotNull(physician);
        Assert.assertEquals("Dr Lee", physician.getName());
    }

    @Test
    public void testPhysicianUpdate() throws Exception {
        Physician newPhysician = new Physician.Builder().copy(physician).name("Dr Smith").build();
        Assert.assertEquals("Dr Smith", newPhysician.getName());
    }
}
