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

package com.gigigo.orchextra.sample.ggglogger;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.sample.MainActivity;
import com.gigigo.orchextra.sample.MyRunner;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 26/11/15.
 */
@RunWith(MyRunner.class)
public class GGGLoggerIntegrationTest {

  RefWatcher leakCannaryWatcher = null;

  public GGGLoggerIntegrationTest() {
  }

  @Rule
  public ActivityTestRule rule = new ActivityTestRule(MainActivity.class);

  @Before
  public void before() {
    Instrumentation instrumentation
        = InstrumentationRegistry.getInstrumentation();
    Context ctx = instrumentation.getTargetContext();
    leakCannaryWatcher = LeakCanary.install(rule.getActivity().getApplication());
  }

  @Test
  public void testLogger() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(4);

    for (int i = 0; i < 4; i++) {
      Runnable worker = new MyRunnable(i);
      leakCannaryWatcher.watch(worker);
      executor.execute(worker);
    }

    executor.shutdown();
  }

  public static class MyRunnable implements Runnable {
    private final int j;

    MyRunnable(int j) {
      this.j = j;
    }

    @Override
    public void run() {
      for(int i=0; i<100; i++){
        GGGLogImpl.log("THIS IS MY LOGER " + j + " Logging " + i, true);
      }
    }
  }

}
