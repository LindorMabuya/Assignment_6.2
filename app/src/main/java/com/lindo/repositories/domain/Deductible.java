package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class Deductible implements Serializable {
    private long id;

    public Deductible(Builder builder) {
        id = builder.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeductible(){
        System.out.print("Deductible: Validating health insurance claim.....\n");
        return true;
    }

    public static class Builder{
        private long id;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder copy(Deductible value) {
            this.id = value.getId();
            return this;
        }

        public Deductible build(){return  new Deductible(this);}
    }
}
