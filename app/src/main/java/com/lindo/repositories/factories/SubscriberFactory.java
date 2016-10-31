package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.domain.Subscriber;

/**
 * Created by bishop v on 2016-10-31.
 */
public class SubscriberFactory {
    public static Subscriber getSubsciber(long id, Dependent dependent){
        return new Subscriber.Builder()
                .id(id)
                .dependent(dependent)
                .build();
    }
}
