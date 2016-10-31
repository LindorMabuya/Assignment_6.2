package com.lindo.repositories.domain;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Subscriber {
    private long id;
    private Dependent dependent;

    public Subscriber(Builder builder) {
        id = builder.id;
        dependent = builder.dependent;
    }

    public long getId() {
        return id;
    }

    public Dependent getDependent() {
        return dependent;
    }
    public static class Builder {
        private long id;
        private Dependent dependent;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder dependent(Dependent value)
        {
            this.dependent = value;
            return this;
        }
        public Builder copy(Subscriber value)
        {
            this.id = value.getId();
            this.dependent =value.getDependent();
            return this;
        }
        public Subscriber build(){return new Subscriber(this);}
    }
}

