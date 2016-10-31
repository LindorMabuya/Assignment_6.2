package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-29.
 */
public class Service implements Serializable{
    private long id;
    private Coverage coverage;
    private String serviceType;

    public Service(Builder builder) {
        id = builder.id;
        coverage = builder.coverage;
        serviceType = builder.serviceType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void processCover(Coverage coverage){
        if(coverage.isCovered()){
            System.out.print("Service: Valid claim. Currently processing claim for approval...");
        }
    }
   public class Builder{
        private long id;
        private Coverage coverage;
        private String serviceType;

       public Builder id(long value)
       {
           this.id = value;
           return this;
       }
        public Builder coverage(Coverage value)
        {
            this.coverage = value;
            return this;
        }
        public Builder serviceType(String value){

            this.serviceType = value;
            return this;
        }
       public Builder copy(Service value) {
           this.id = value.getId();
           this.coverage = value.getCoverage();
           this.serviceType = value.getServiceType();
           return  this;
       }
        public Service build(){return new Service(this);}
    }
}