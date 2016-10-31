package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Deductible;

/**
 * Created by bishop v on 2016-10-31.
 */
public class DeductibleFactory {
    public static Deductible getDeductible(long id, double deductionAmount){
        return  new Deductible.Builder()
                .id(id)
                .deductionAmount(deductionAmount)
                .build();
    }
}
