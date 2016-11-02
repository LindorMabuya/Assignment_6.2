package com.lindo.repositories.services;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.repositories.PhysicianRepo;

import java.util.ArrayList;

public class PhysicianService extends Service {
    private PhysicianRepo physicianRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public PhysicianService() {
        physicianRepo = new PhysicianRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public PhysicianService getService()
        {
            return PhysicianService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Physician physician) {

        return physicianRepo.addPhysician(physician);
    }

    public Physician findById(long id) {
        return physicianRepo.findPhysicianById(id);
    }

    public boolean update(Physician updatePhysician, long id) {
        return physicianRepo.updatePhysician(updatePhysician,id);
    }

    public boolean deleteById(long id) {
        return physicianRepo.deleteById(id);
    }

    public ArrayList<Physician> findAll() {
        return physicianRepo.getAllPhysicians();
    }
}
