package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Hospital;
import com.lindo.repositories.factories.HospitalFactory;

/**
 *
 */
public class HospitalRepoTest extends AndroidTestCase {

    private HospitalRepo hospitalRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        hospitalRepo = new HospitalRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        hospitalRepo.close();
        super.tearDown();
    }

    public void addHospitalTest() {
        Hospital hospital = HospitalFactory.getHospital((long) 16.0,"mediclinic");
        assertEquals(true, hospitalRepo.addHospital(hospital));
    }

    public void findHospitalById() {
        Hospital hospital = hospitalRepo.findHospitalById((long)16.0);
        assertEquals("mediclinic", hospital.getHospitalName());
    }
}
