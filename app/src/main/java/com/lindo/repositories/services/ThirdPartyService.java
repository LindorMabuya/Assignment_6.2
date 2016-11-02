package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.ThirdParty;
import com.lindo.repositories.repositories.ThirdPartyRepo;

import java.util.ArrayList;

public class ThirdPartyService extends Service {
    private ThirdPartyRepo thirdPartyRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public ThirdPartyService() {
        thirdPartyRepo = new ThirdPartyRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public ThirdPartyService getService()
        {
            return ThirdPartyService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(ThirdParty thirdParty) {

        return thirdPartyRepo.addParty(thirdParty);
    }

    public ThirdParty findById(long id) {
        return thirdPartyRepo.findPartyById(id);
    }

    public boolean update(ThirdParty updateParty, long id) {
        return thirdPartyRepo.updateParty(updateParty,id);
    }

    public boolean deleteById(long id) {
        return thirdPartyRepo.deleteById(id);
    }

    public ArrayList<ThirdParty> findAll() {
        return thirdPartyRepo.getAllParties();
    }
}
