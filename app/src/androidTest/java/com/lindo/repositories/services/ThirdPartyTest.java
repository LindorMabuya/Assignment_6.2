package com.lindo.repositories.services;


import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.ThirdParty;
import com.lindo.repositories.factories.ThirdPartyFactory;
import com.lindo.repositories.repositories.ThirdPartyRepo;

public class ThirdPartyTest  extends AndroidTestCase {
    private ThirdPartyRepo thirdPartyRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        thirdPartyRepo = new ThirdPartyRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        thirdPartyRepo.close();
        super.tearDown();
    }

    public void addThirdPartyTest() {
        ThirdParty thirdParty = ThirdPartyFactory.getThirdParty((long) 16.0, "old mutual", "insurance");
        assertEquals(true, thirdPartyRepo.addParty(thirdParty));
    }

    public void findThirdPartyById() {
        ThirdParty thirdParty = thirdPartyRepo.findPartyById((long)16.0);
        assertEquals("old mutual", thirdParty.getName());
    }
}

