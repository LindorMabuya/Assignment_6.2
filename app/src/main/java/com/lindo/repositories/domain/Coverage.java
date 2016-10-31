package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class Coverage implements Serializable {
    private long id;
    private double coverAmount;

    public Coverage(Builder builder) {
        id = builder.id;
        coverAmount = builder.coverAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(double coverAmount) {
        this.coverAmount = coverAmount;
    }

    public boolean isCovered(){
        System.out.print("Coverage: Validating health insurance claim.....\n");
        return true;

    }
    public static class Builder{
        private long id;
        private double coverAmount;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder coverAmount(double value)
        {
            this.coverAmount = value;
            return this;
        }

        public Builder copy(Coverage value) {
            this.id = value.getId();
            this.coverAmount = value.getCoverAmount();
            return this;
        }

        public Coverage build(){return  new Coverage(this);}
    }
}
