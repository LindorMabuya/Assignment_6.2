package com.lindo.repositories.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.repositories.DemographicInfoRepo;

import java.util.ArrayList;


public class DemographicInfoService  extends Service {
    private DemographicInfoRepo demographicInfoRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public DemographicInfoService() {
        demographicInfoRepo = new DemographicInfoRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public DemographicInfoService getService()
        {
            return DemographicInfoService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(DemographicInfo demographicInfo) {

        return demographicInfoRepo.addDemographics(demographicInfo);
    }

    public DemographicInfo findById(long id) {
        return demographicInfoRepo.findDemographicsById(id);
    }

    public boolean update(DemographicInfo updateInfo, long id) {
        return demographicInfoRepo.updateDemographics(updateInfo,id);
    }

    public boolean deleteById(long id) {
        return demographicInfoRepo.deleteById(id);
    }

    public ArrayList<DemographicInfo> findAll() {
        return demographicInfoRepo.getAllDemographics();
    }
}
