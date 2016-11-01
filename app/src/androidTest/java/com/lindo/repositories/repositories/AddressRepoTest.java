package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Address;
import com.lindo.repositories.factories.AddressFactory;


/**
 * lindor
 */
public class AddressRepoTest extends AndroidTestCase{
    private AddressRepo addressRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        addressRepo = new AddressRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        addressRepo.close();
        super.tearDown();
    }

    public void addAddressTest() {
        Address address = AddressFactory.getAddress((long) 16.0,"Cape Town","Gardens",8001);
        assertEquals(true, addressRepo.addAddress(address));
    }

    public void findAddressById() {
        Address address = addressRepo.findAddressById((long)16.0);
        assertEquals("Cape Town", address.getCity());
    }
}
