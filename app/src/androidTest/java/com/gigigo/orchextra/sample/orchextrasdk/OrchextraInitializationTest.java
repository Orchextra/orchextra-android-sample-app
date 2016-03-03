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

package com.gigigo.orchextra.sample.orchextrasdk;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.test.mock.MockApplication;

import com.gigigo.orchextra.sdk.OrchextraManager;
import com.gigigo.orchextra.sample.MainActivity;
import com.gigigo.orchextra.sample.MyRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.*;


@RunWith(MyRunner.class)
public class OrchextraInitializationTest {

  Context ctx;
  private MockApplication application;

  public OrchextraInitializationTest() {
  }

  @Rule
  public ActivityTestRule rule = new ActivityTestRule(MainActivity.class);

  @Before
  public void before() {
    Instrumentation instrumentation
        = InstrumentationRegistry.getInstrumentation();
    ctx = instrumentation.getTargetContext();
    application = new MockApplication();
  }

  @Test
  public void initializationTest() throws InterruptedException {
    OrchextraManager.sdkInitialize(application, "Hello", "World", null);
    assertNotNull(OrchextraManager.getInjector());
  }

}
