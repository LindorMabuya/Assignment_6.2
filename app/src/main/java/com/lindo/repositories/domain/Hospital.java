package com.lindo.repositories.domain;

/**
 * Created by Lindo on 2016-10-31.
 */
public class Hospital{
    private long id;
    private String hospitalName;

    public Hospital(Builder builder) {
        id = builder.id;
        hospitalName = builder.hospitalName;
    }

    public long getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public static class Builder {
        private long id;
        private String hospitalName;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder hospitalName(String value)
        {
            this.hospitalName = value;
            return this;
        }
        public Builder copy(Hospital value)
        {
            this.id = value.getId();
            this.hospitalName = value.getHospitalName();
            return this;
        }
        public Hospital build(){return new Hospital(this);}
    }
}
