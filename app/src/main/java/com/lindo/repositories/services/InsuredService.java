package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Insured;
import com.lindo.repositories.repositories.InsuredRepo;

import java.util.ArrayList;


public class InsuredService extends Service {
    private InsuredRepo insuredRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public InsuredService() {
        insuredRepo = new InsuredRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public InsuredService getService()
        {
            return InsuredService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Insured insured) {

        return insuredRepo.addInsurance(insured);
    }

    public Insured findById(long id) {
        return insuredRepo.findInsuranceById(id);
    }

    public boolean update(Insured updateInsurance, long id) {
        return insuredRepo.updateInsurance(updateInsurance,id);
    }

    public boolean deleteById(long id) {
        return insuredRepo.deleteById(id);
    }

    public ArrayList<Insured> findAll() {
        return insuredRepo.getAllInsurances();
    }
}
