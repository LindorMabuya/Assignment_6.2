package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Deductible;
import com.lindo.repositories.repositories.DeductibleRepo;

import java.util.ArrayList;

/**
 */
public class DeductibleService  extends Service {
    private DeductibleRepo deductibleRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public DeductibleService() {
        deductibleRepo = new DeductibleRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public DeductibleService getService()
        {
            return DeductibleService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Deductible deductible) {

        return deductibleRepo.addDeductible(deductible);
    }

    public Deductible findById(long id) {
        return deductibleRepo.findDeductibleById(id);
    }

    public boolean update(Deductible updateDeductions, long id) {
        return deductibleRepo.updateDeductions(updateDeductions,id);
    }

    public boolean deleteById(long id) {
        return deductibleRepo.deleteById(id);
    }

    public ArrayList<Deductible> findAll() {
        return deductibleRepo.getAllDeductions();
    }
}
