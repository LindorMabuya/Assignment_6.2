package com.lindo.repositories.factories;


import com.lindo.repositories.domain.Dependent;

/**
 * Created by Lindo on 2016-10-31.
 */
public class DependentFactory {
    public  static Dependent getDependent(long id, String relationToSubscriber){
        return new Dependent.Builder()
                .id(id)
                .relationToSubscriber(relationToSubscriber)
                .build();
    }

}
