package com.lindo.repositories.factories;

import com.lindo.repositories.domain.DemographicInfo;
import com.lindo.repositories.domain.Insured;
import com.lindo.repositories.domain.Physician;
import com.lindo.repositories.domain.Plan;

/**
 * Created by bishop v on 2016-10-31.
 */
public class InsuredFactory {
    public static Insured getInsured(long id, DemographicInfo demographicInfo, Physician physician){
        return new Insured.Builder()
                .id(id)
                .demographicInfo(demographicInfo)
                .physician(physician)
                .build();
    }
}
