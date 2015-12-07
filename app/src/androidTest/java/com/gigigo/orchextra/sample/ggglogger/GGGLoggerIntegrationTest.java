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
