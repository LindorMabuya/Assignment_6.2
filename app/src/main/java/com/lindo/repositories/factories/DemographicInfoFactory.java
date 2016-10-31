package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Address;
import com.lindo.repositories.domain.DemographicInfo;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DemographicInfoFactory {
    public static DemographicInfo getDemographicInfo(long id, int age, String sex, String maritalStatus, String occupation,  double salary, Address address){
        return new DemographicInfo.Builder()
                .id(id)
                .age(age)
                .sex(sex)
                .maritalStatus(maritalStatus)
                .occupation(occupation)
                .salary(salary)
                .address(address)
                .build();
    }
}
