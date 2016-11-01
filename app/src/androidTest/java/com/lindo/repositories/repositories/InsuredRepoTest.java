package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.domain.Insured;
import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.factories.InsuredFactory;

/**
 * lindor
 */
public class InsuredRepoTest extends AndroidTestCase {
    private InsuredRepo insuredRepo;
    private  static DemographicInfo demographicInfo;
    private static Physician physician;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        insuredRepo = new InsuredRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        insuredRepo.close();
        super.tearDown();
    }

    public void addInsuranceTest() {
        Insured insured = InsuredFactory.getInsured((long) 16.0,demographicInfo, physician);
        assertEquals(true, insuredRepo.addInsurance(insured));
    }

    public void findInsuranceById() {
        Insured insured = insuredRepo.findInsuranceById((long)16.0);
        assertEquals(demographicInfo, insured.getDemographicInfo());
    }
}
