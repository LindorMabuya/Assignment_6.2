package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Provider implements Serializable {
    private long id;
    private DemographicInfo demographicInfo;
    private Payer payer;

    public Provider(Builder builder) {
        id = builder.id;
        demographicInfo = builder.demographicInfo;
        payer = builder.payer;
    }

    public long getId() {
        return id;
    }

    public DemographicInfo getDemographicInfo() {
        return demographicInfo;
    }

    public Payer getPayer() {
        return payer;
    }

    public class Builder{
        private long id;
        private DemographicInfo demographicInfo;
        private Payer payer;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder demographicInfo(DemographicInfo value){
            this.demographicInfo = value;
            return this;
        }
        public Builder payer(Payer value){
            this.payer = value;
            return this;
        }
        public Builder copy(Provider value){
            this.id = value.getId();
            this.demographicInfo = value.getDemographicInfo();
            this.payer = value.getPayer();
            return this;
        }
        public Provider build(){return new Provider(this);}
    }

}
