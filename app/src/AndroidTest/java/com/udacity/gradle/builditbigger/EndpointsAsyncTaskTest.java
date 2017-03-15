package com.udacity.gradle.builditbigger;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    String mResult;
    @Test
    public void jokeTest() {
        CountDownLatch signal = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getTargetContext();
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(context){
            @Override
            protected void onPostExecute(String result) {
                mResult = result;
            }
        };
        endpointsAsyncTask.execute();
        try {
            signal.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(mResult);
    }
}