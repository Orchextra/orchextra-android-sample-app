package com.gigigo.orchextra.sample.orchextrasdk;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.sample.MainActivity;
import com.gigigo.orchextra.sample.MyRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.*;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 26/11/15.
 */
@RunWith(MyRunner.class)
public class OrchextraInitializationTest {

  Context ctx;
  Application app;

  public OrchextraInitializationTest() {
  }

  @Rule
  public ActivityTestRule rule = new ActivityTestRule(MainActivity.class);

  @Before
  public void before() {
    Instrumentation instrumentation
        = InstrumentationRegistry.getInstrumentation();
    ctx = instrumentation.getTargetContext();
  }

  @Test
  public void initializationTest() throws InterruptedException {
    Orchextra.sdkInitialize(app, "Hello", "World", null);
    assertNotNull(Orchextra.getInjector());
  }

}
