package com.lindo.repositories.services;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lindo.repositories.domain.Subscriber;
import com.lindo.repositories.repositories.SubscriberRepo;

import java.util.ArrayList;

public class SubscriberService extends Service {
    private SubscriberRepo subscriberRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public SubscriberService() {
        subscriberRepo = new SubscriberRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public SubscriberService getService()
        {
            return SubscriberService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Subscriber subscriber) {

        return subscriberRepo.addSubscriber(subscriber);
    }

    public Subscriber findById(long id) {
        return subscriberRepo.findSubscriberById(id);
    }

    public boolean update(Subscriber updateSubscriber, long id) {
        return subscriberRepo.updateSuscriber(updateSubscriber,id);
    }

    public boolean deleteById(long id) {
        return subscriberRepo.deleteById(id);
    }

    public ArrayList<Subscriber> findAll() {
        return subscriberRepo.getDescription();
    }
}
