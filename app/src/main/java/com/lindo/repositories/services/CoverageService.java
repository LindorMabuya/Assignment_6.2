package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Coverage;
import com.lindo.repositories.repositories.CoverageRepo;

import java.util.ArrayList;


public class CoverageService  extends Service {
    private CoverageRepo coverageRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public CoverageService() {
        coverageRepo = new CoverageRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public CoverageService getService()
        {
            return CoverageService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Coverage coverage) {

        return coverageRepo.addCoverage(coverage);
    }

    public Coverage findById(long id) {
        return coverageRepo.findCoverageById(id);
    }

    public boolean update(Coverage updateCover, long id) {
        return coverageRepo.updateCoverage(updateCover,id);
    }

    public boolean deleteById(long id) {
        return coverageRepo.deleteById(id);
    }

    public ArrayList<Coverage> findAll() {
        return coverageRepo.getAllCoverage();
    }
}
