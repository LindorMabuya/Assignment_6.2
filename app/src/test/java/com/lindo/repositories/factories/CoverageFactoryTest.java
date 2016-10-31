package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Coverage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class CoverageFactoryTest {
    private Coverage coverage;

    @Before
    public void setUp() throws Exception {
        coverage = CoverageFactory.getCoverage(1L, 200);
    }

    @Test
    public void testCoverage() throws Exception {
        coverage.isCovered();
        Assert.assertNotNull(coverage);
        Assert.assertEquals(1L, coverage.getId());
    }

    @Test
    public void testCoverageUpdate() throws Exception{
        Coverage newCover = new Coverage.Builder().copy(coverage).id(2L).build();
        Assert.assertEquals(2L, newCover.getId());

    }
}
