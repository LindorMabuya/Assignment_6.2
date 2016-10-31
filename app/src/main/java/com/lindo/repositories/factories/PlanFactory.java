package com.lindo.repositories.factories;

import com.lindo.repositories.domain.BenefitSet;
import com.lindo.repositories.domain.Deductible;
import com.lindo.repositories.domain.Payer;
import com.lindo.repositories.domain.Plan;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PlanFactory {
    public static Plan getPlan(long id, Deductible deductible, BenefitSet benefitSet,Payer payer){
        return new Plan.Builder()
                .id(id)
                .deductible(deductible)
                .benefitSets(benefitSet)
                .payer(payer)
                .build();
    }
}
