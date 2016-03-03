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

package com.gigigo.orchextra.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {

  //RefWatcher leakCannaryWatcher = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //leakCannaryWatcher = LeakCanary.install(getApplication());

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });



    //ExecutorService executor = Executors.newFixedThreadPool(4);
    //
    //for (int i = 0; i < 4; i++) {
    //
    //  Runnable worker = new MyRunnable(i);
    //  leakCannaryWatcher.watch(worker);
    //  executor.execute(worker);
    //
    //}
    //executor.shutdown();

  }

  //public static class MyRunnable implements Runnable {
  //  private  int j;
  //
  //  MyRunnable(int j) {
  //    this.j = j;
  //  }
  //
  //  @Override
  //  public void run() {
  //    for(int i=0; i<1000; i++){
  //      GGGLogImpl.log("THIS IS MY LOGER "+ j +" Logging " + i , true);
  //    }
  //  }
//}

}
