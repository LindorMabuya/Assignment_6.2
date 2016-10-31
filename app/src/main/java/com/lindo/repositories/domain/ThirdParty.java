package com.lindo.repositories.domain;

/**
 * Created by Lindo on 2016-10-31.
 */
public class ThirdParty {
    private long id;
    private String name;
    private String relations;

    public ThirdParty(Builder builder){
        id = builder.id;
        name = builder.name;
        relations = builder.relations;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelations() {
        return relations;
    }
    public static class Builder {
        private long id;
        private String name;
        private String relations;

        public Builder id(long value) {
            this.id = value;
            return this;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder relations(String value) {
            this.relations = value;
            return this;
        }
        public Builder copy(ThirdParty value)
        {
            this.id = value.getId();
            this.name = value.getName();
            this.relations = value.getRelations();
            return this;
        }
        public ThirdParty build(){return new ThirdParty(this);}
    }
}
