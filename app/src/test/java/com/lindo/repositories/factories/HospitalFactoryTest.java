package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Hospital;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class HospitalFactoryTest {
    private Hospital hospital;

    @Before
    public void setUp() throws Exception {
        hospital = HospitalFactory.getHospital(1L,"mediclinic");
    }

    @Test
    public void testHospital() throws Exception {
        Assert.assertNotNull(hospital);
        Assert.assertEquals("mediclinic", hospital.getHospitalName());
    }

    @Test
    public void testHospitalUpdate() throws Exception {
        Hospital newHospital = new Hospital.Builder().copy(hospital).hospitalName("clinic").build();
        Assert.assertEquals("clinic", newHospital.getHospitalName());
    }
}
