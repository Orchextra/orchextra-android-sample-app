/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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