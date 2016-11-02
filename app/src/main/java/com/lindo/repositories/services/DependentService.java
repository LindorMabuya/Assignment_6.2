package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.repositories.DependentRepo;

import java.util.ArrayList;

public class DependentService  extends Service {
    private DependentRepo dependentRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public DependentService() {
        dependentRepo = new DependentRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public DependentService getService()
        {
            return DependentService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Dependent dependent) {

        return dependentRepo.addDependent(dependent);
    }

    public Dependent findById(long id) {
        return dependentRepo.findDependentById(id);
    }

    public boolean update(Dependent updateDependent, long id) {
        return dependentRepo.updateDependents(updateDependent,id);
    }

    public boolean deleteById(long id) {
        return dependentRepo.deleteById(id);
    }

    public ArrayList<Dependent> findAll() {
        return dependentRepo.getAllDependecies();
    }
}