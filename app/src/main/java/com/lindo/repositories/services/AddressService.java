package com.lindo.repositories.services;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Address;
import com.lindo.repositories.repositories.AddressRepo;

import java.util.ArrayList;

public class AddressService extends Service{
    private AddressRepo addressRepo;

    private final  IBinder myLocalBinder = new MyLocalBinder();
    public AddressService() {
        addressRepo = new AddressRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public AddressService getService()
        {
            return AddressService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Address address) {

        return addressRepo.addAddress(address);
    }

    public Address findById(long id) {
        return addressRepo.findAddressById(id);
    }

    public boolean update(Address updateAddress, long id) {
        return addressRepo.updateAddress(updateAddress, id);
    }

    public boolean deleteById(long id) {
        return addressRepo.deleteById(id);
    }

    public ArrayList<Address> findAll() {
        return addressRepo.getAllAddresses();
    }
}
