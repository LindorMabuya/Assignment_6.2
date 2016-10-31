package com.lindo.repositories.factories;


import com.lindo.repositories.domain.Hospital;

/**
 * Created by bishop v on 2016-10-31.
 */
public class HospitalFactory {
    public static Hospital getHospital(long id, String hospitalName){
        return new Hospital.Builder()
                .id(id)
                .hospitalName(hospitalName)
                .build();
    }
}
