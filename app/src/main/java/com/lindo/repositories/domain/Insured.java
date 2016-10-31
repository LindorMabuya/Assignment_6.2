package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class Insured implements Serializable {
    private long id;
    private Plan plan;
    private DemographicInfo demographicInfo;
    private Physician physician;

    public Insured(Builder builder) {
        id = builder.id;
        demographicInfo = builder.demographicInfo;
        plan = builder.plan;
        physician = builder.physician;
    }

    public long getId() {
        return id;
    }

    public Plan getPlan() {
        return plan;
    }

    public Physician getPhysician() {
        return physician;
    }

    public DemographicInfo getDemographicInfo() {
        return demographicInfo;
    }


    public static class Builder{
        private long id;
        private Plan plan;
        private DemographicInfo demographicInfo;
        private Physician physician;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder plan(Plan value)
        {
            this.plan = value;
            return this;
        }
        public Builder demographicInfo(DemographicInfo value)
        {
            this.demographicInfo = value;
            return this;
        }
        public Builder physician(Physician value)
        {
            this.physician = value;
            return this;
        }
        public Builder copy(Insured value)
        {
            this.id = value.getId();
            this.plan = value.getPlan();
            this.demographicInfo = value.getDemographicInfo();
            this.physician = value.getPhysician();
            return this;
        }
        public Insured build(){return new Insured(this);}

    }

}
