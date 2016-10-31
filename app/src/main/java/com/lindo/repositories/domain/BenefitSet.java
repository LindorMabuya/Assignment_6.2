package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class BenefitSet implements Serializable {
    private long id;
    private String service;

    public BenefitSet(Builder builder) {
        id = builder.id;
        service = builder.service;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public class Builder{
        private long id;
        private String service;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder service(String value){
            this.service = value;
            return this;
        }
        public Builder copy(BenefitSet value){
            this.id = value.getId();
            this.service = value.getService();
            return this;
        }
        public BenefitSet build(){
            return new BenefitSet(this);
        }
    }

}
