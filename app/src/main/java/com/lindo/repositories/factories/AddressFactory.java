package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Address;

/**
 * Created by Lindo on 2016-10-31.
 */
public class AddressFactory {
    public static Address getAddress(long id, String streetName, String city, int zipCode){
        return new Address.Builder()
                .id(id)
                .streetName(streetName)
                .city(city)
                .zipCode(zipCode)
                .build();
    }
}
