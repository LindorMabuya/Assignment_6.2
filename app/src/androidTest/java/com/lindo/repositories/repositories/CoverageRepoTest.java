package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Coverage;
import com.lindo.repositories.factories.CoverageFactory;


/**
 * lindor
 */
public class CoverageRepoTest extends AndroidTestCase {
    private CoverageRepo coverageRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        coverageRepo = new CoverageRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        coverageRepo.close();
        super.tearDown();
    }

    public void addCoverageTest() {
        Coverage coverage = CoverageFactory.getCoverage((long) 16.0, 3400);
        assertEquals(true, coverageRepo.addCoverage(coverage));
    }

    public void findCoverageById() {
        Coverage coverage = coverageRepo.findCoverageById((long)16.0);
        assertEquals(3400, coverage.getCoverAmount());
    }
}
