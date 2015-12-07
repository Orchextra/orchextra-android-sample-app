package com.gigigo.orchextra.sample.application;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import com.gigigo.ggglogger.GGGLogImpl;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

  //RefWatcher leakCannaryWatcher = null;

  public ApplicationTest() {
    super(Application.class);
  }

  //@Test
  //public void testLogger() throws InterruptedException {
  //  ExecutorService executor = Executors.newFixedThreadPool(4);
  //
  //  leakCannaryWatcher = LeakCanary.install(getApplication());
  //
  //  for (int i = 0; i < 4; i++) {
  //
  //    Runnable worker = new MyRunnable(i);
  //    leakCannaryWatcher.watch(worker);
  //    executor.execute(worker);
  //  }
  //
  //  Thread.sleep(2000);
  //  executor.shutdown();
  //}
  //
  //public static class MyRunnable implements Runnable {
  //  private final int j;
  //
  //  MyRunnable(int j) {
  //    this.j = j;
  //  }
  //
  //  @Override
  //  public void run() {
  //    for(int i=0; i<1000; i++){
  //      GGGLogImpl.log("THIS IS MY LOGER " + j + " Logging " + i, true);
  //    }
  //  }
  //}
}