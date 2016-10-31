package com.lindo.repositories.factories;

import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.domain.Subscriber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bishop v on 2016-10-31.
 */
public class SubscriberFactoryTest {
    private Subscriber subscriber;
    private Dependent dependent;

    @Before
    public void setUp() throws Exception {
        subscriber = SubscriberFactory.getSubsciber(1L, dependent);
    }

    @Test
    public void testSubscriber() throws Exception {
        Assert.assertNotNull(subscriber);
        Assert.assertEquals(dependent, subscriber.getDependent());
    }

    @Test
    public void testSubscriberUpdate() throws Exception {
        Subscriber newSubscriber = new Subscriber.Builder().copy(subscriber).id(2L).build();
        Assert.assertEquals(2L, newSubscriber.getId());
    }
}
