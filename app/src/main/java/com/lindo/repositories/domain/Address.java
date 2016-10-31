package com.lindo.repositories.domain;

import java.io.Serializable;

/**
 * Created by Lindo on 2016-10-28.
 */
public class Address implements Serializable {
    private long id;
    private String streetName;
    private String city;
    private int zipCode;

    public Address(Builder builder){
        id = builder.id;
        streetName = builder.streetName;
        city = builder.city;
        zipCode = builder.zipCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public static class Builder
    {
        private long id;
        private String streetName;
        private String city;
        private int zipCode;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder streetName(String value)
        {
            this.streetName = value;
            return this;
        }

        public Builder city(String value)
        {
            this.city = value;
            return this;
        }
        public Builder zipCode(int value)
        {
            this.zipCode = value;
            return this;
        }
        public Builder copy(Address value)
        {
            this.id = value.getId();
            this.streetName = value.getStreetName();
            this.city = value.getCity();
            this.zipCode = value.getZipCode();
            return this;
        }
        public Address build(){return new Address(this);}

    }

}
