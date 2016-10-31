package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Physician;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PhysicianFactory {
    public  static Physician getPhysician(long id, String name, String office){
        return new Physician.Builder()
                .id(id)
                .name(name)
                .offie(office)
                .build();
    }
}
