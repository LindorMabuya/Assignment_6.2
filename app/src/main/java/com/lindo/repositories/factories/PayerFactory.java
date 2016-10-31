package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Payer;
import com.lindo.repositories.domain.Plan;

/**
 * Created by bishop v on 2016-10-31.
 */
public class PayerFactory {
    public static Payer getPayer(long id, Plan plan){
        return new Payer.Builder()
                .id(id)
                .plan(plan)
                .build();
    }
}
