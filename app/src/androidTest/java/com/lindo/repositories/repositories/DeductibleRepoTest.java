package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Deductible;
import com.lindo.repositories.factories.DeductibleFactory;

/**
 *
 */
public class DeductibleRepoTest extends AndroidTestCase {
    private DeductibleRepo deductibleRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        deductibleRepo = new DeductibleRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        deductibleRepo.close();
        super.tearDown();
    }

    public void addDeductionTest() {
        Deductible deductible = DeductibleFactory.getDeductible((long) 16.0, 2500);
        assertEquals(true, deductibleRepo.addDeductible(deductible));
    }

    public void findDeductionsById() {
        Deductible deductible = deductibleRepo.findDeductibleById((long)16.0);
        assertEquals(2500, deductible.getDeductionAmount());
    }
}
