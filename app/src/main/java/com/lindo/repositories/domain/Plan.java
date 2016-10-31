package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Plan implements Serializable {

    private long id;
    private Deductible deductible;
    private BenefitSet benefitSets;
    private Payer payer;

    public Plan(Builder builder) {
        id = builder.id;
        deductible = builder.deductible;
        benefitSets = builder.benefitSets;
        payer = builder.payer;
    }

    public Long getId() {
        return id;
    }

    public Deductible getDeductible() {
        return deductible;
    }

    public BenefitSet getBenefitSets() {
        return benefitSets;
    }

    public Payer getPayer() {
        return payer;
    }

    public void checkDeduction(Deductible deductible){
        if(deductible.isDeductible()){
            System.out.print("Plan: Valid claim. Currently processing claim for approval...");
        }
    }
    public static class Builder{
        private long id;
        private Deductible deductible;
        private BenefitSet benefitSets;
        private Payer payer;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder deductible(Deductible value){
            this.deductible = value;
            return this;
        }
        public Builder benefitSets(BenefitSet value){
            this.benefitSets = value;
            return this;
        }
        public Builder payer(Payer value){
            this.payer = value;
            return this;
        }
        public Builder copy(Plan value)
        {
            this.id = value.getId();
            this.deductible = value.getDeductible();
            this.benefitSets = value.getBenefitSets();
            this.payer = value.getPayer();
            return this;
        }

        public Plan build(){return new Plan(this);}
    }


}
