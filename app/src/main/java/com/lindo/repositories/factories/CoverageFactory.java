package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Coverage;

/**
 * Created by Lindo on 2016-10-31.
 */
public class CoverageFactory {
    public static Coverage getCoverage(long id, double coverAmount){
        return  new Coverage.Builder()
                .id(id)
                .coverAmount(coverAmount)
                .build();
    }
}
