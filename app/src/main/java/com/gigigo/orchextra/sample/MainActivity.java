package com.gigigo.orchextra.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.Orchextra;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

  RefWatcher leakCannaryWatcher = null;

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

    Orchextra.sdkInitialize(getApplicationContext(), "Hello", "World");

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
