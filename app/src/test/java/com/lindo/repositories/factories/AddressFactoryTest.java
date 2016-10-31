package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Address;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class AddressFactoryTest {
    private Address address;

    @Before
    public void setUp() throws Exception {
        address = AddressFactory.getAddress(1L,"3 kotze street","cape town",8001);

    }

    @Test
    public void testAddress() throws Exception {
        Assert.assertNotNull(address);
        Assert.assertEquals("cape town", address.getCity());
    }

    @Test
    public void testAddressUpdate() throws Exception {
        Address newAddress = new Address.Builder().copy(address).streetName("4 kloof street").build();
        Assert.assertEquals("4 kloof street", newAddress.getStreetName());
    }
}
