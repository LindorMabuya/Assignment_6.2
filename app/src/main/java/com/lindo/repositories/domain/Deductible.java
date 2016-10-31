package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class Deductible implements Serializable {
    private long id;
    private double deductionAmount;

    public Deductible(Builder builder) {
        id = builder.id;
        deductionAmount = builder.deductionAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public boolean isDeductible(){
        System.out.print("Deductible: Validating health insurance claim.....\n");
        return true;
    }

    public static class Builder{
        private long id;
        private double deductionAmount;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder deductionAmount(double value)
        {
            this.deductionAmount = value;
            return this;
        }
        public Builder copy(Deductible value) {
            this.id = value.getId();
            this.deductionAmount = value.getDeductionAmount();
            return this;
        }

        public Deductible build(){return  new Deductible(this);}
    }
}
