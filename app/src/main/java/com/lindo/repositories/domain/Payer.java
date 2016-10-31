package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Payer implements Serializable {
    private long id;
    private Plan plan;

    public Payer(Builder builder) {
        id = builder.id;
        plan = builder.plan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    public static class Builder {
        private long id;
        private Plan plan;

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
        public Builder copy(Payer value) {
            this.id = value.getId();
            this.plan = value.getPlan();
            return  this;
        }
        public Payer build(){return new Payer(this);}
    }
}
