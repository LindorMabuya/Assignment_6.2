package com.lindo.repositories.domain;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Dependent{
    private long id;
    private String relationToSubscriber;

    public Dependent(Builder builder) {
        id = builder.id;
        relationToSubscriber = builder.relationToSubscriber;
    }

    public long getId() {
        return id;
    }

    public String getRelationToSubscriber() {
        return relationToSubscriber;
    }
    public static class Builder {
        private long id;
        private String relationToSubscriber;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder relationToSubscriber(String value)
        {
            this.relationToSubscriber = value;
            return this;
        }

        public Builder copy(Dependent value)
        {
            this.id = value.getId();
            this.relationToSubscriber = value.getRelationToSubscriber();
            return this;
        }
        public Dependent build(){return new Dependent(this);}
    }
}