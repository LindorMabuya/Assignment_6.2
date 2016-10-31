package com.lindo.repositories.factories;

import com.lindo.repositories.domain.ThirdParty;

/**
 * Created by bishop v on 2016-10-31.
 */
public class ThirdPartyFactory {
    public static ThirdParty getThirdParty(long id, String name, String relations){
        return new ThirdParty.Builder()
                .id(id)
                .name(name)
                .relations(relations)
                .build();
    }
}
