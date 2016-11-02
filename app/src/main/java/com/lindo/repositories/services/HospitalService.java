package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Hospital;
import com.lindo.repositories.repositories.HospitalRepo;

import java.util.ArrayList;


public class HospitalService  extends Service {
    private HospitalRepo hospitalRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public HospitalService() {
        hospitalRepo = new HospitalRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public HospitalService getService()
        {
            return HospitalService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Hospital hospital) {

        return hospitalRepo.addHospital(hospital);
    }

    public Hospital findById(long id) {
        return hospitalRepo.findHospitalById(id);
    }

    public boolean update(Hospital updateHospital, long id) {
        return hospitalRepo.updateHospital(updateHospital,id);
    }

    public boolean deleteById(long id) {
        return hospitalRepo.deleteById(id);
    }

    public ArrayList<Hospital> findAll() {
        return hospitalRepo.getAllHospitals();
    }
}