package com.lindo.repositories.repositories;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.lindo.repositories.domain.Dependent;
import com.lindo.repositories.domain.Subscriber;
import com.lindo.repositories.factories.SubscriberFactory;

/**
 *
 */
public class SubscriberRepoTest extends AndroidTestCase {

    private SubscriberRepo subscriberRepo;
    private static Dependent dependent;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        subscriberRepo = new SubscriberRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        subscriberRepo.close();
        super.tearDown();
    }

    public void addSubscriberTest() {
        Subscriber subscriber = SubscriberFactory.getSubsciber((long) 16.0,dependent);
        assertEquals(true, subscriberRepo.addSubscriber(subscriber));
    }

    public void findSubscriberById() {
        Subscriber subscriber = subscriberRepo.findSubscriberById((long)16.0);
        assertEquals(dependent, subscriber.getDependent());
    }
}
