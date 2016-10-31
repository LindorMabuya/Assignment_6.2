package com.lindo.repositories.domain;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Physician{
    private long id;
    private String name;
    private String office;

    public Physician(Builder builder) {
        id = builder.id;
        name = builder.name;
        office = builder.office;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOffice() {
        return office;
    }
    public static class Builder {
        private long id;
        private String name;
        private String office;

        public Builder id(long value) {
            this.id = value;
            return this;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder offie(String value) {
            this.office = value;
            return this;
        }

        public Builder copy(Physician value)
        {
            this.id = value.getId();
            this.name = value.getOffice();
            this.office = value.getOffice();
            return this;
        }
        public Physician build(){return new Physician(this);}

    }
}
