package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.factories.PhysicianFactory;

/**
 * lindor
 */
public class PhysicianRepoTest extends AndroidTestCase {

    private PhysicianRepo physicianRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        physicianRepo = new PhysicianRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        physicianRepo.close();
        super.tearDown();
    }

    public void addPhysicianTest() {
        Physician physician = PhysicianFactory.getPhysician((long) 16.0,"Dr lee", "surgery");
        assertEquals(true, physicianRepo.addPhysician(physician));
    }

    public void findPhysicianById() {
        Physician physician = physicianRepo.findPhysicianById((long)16.0);
        assertEquals("Dr lee", physician.getName());
    }
}
