package com.lindo.repositories.services;


import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.factories.DependentFactory;
import com.lindo.repositories.repositories.DependentRepo;

public class DependentTest extends AndroidTestCase {
    private DependentRepo dependentRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        dependentRepo = new DependentRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        dependentRepo.close();
        super.tearDown();
    }

    public void addDependentTest() {
        Dependent dependent = DependentFactory.getDependent((long) 16.0,"husband");
        assertEquals(true, dependentRepo.addDependent(dependent));
    }

    public void findDependentById() {
        Dependent dependent = dependentRepo.findDependentById((long)16.0);
        assertEquals("husband", dependent.getRelationToSubscriber());
    }
}

