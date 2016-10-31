package com.lindo.repositories.factories;

import com.lindo.repositories.domain.ThirdParty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class ThirdPartyFactoryTest {
    private ThirdParty thirdParty;

    @Before
    public void setUp() throws Exception {
        thirdParty = ThirdPartyFactory.getThirdParty(1L,"old mutual","insurance");
    }

    @Test
    public void testThirdParty() throws Exception {
        Assert.assertNotNull(thirdParty);
        Assert.assertEquals("old mutual", thirdParty.getName());
    }

    @Test
    public void testThirdPartyUpdate() throws Exception {
        ThirdParty newThirdParty = new ThirdParty.Builder().copy(thirdParty).name("discovery").build();
        Assert.assertEquals("discovery", newThirdParty.getName());
    }
}
