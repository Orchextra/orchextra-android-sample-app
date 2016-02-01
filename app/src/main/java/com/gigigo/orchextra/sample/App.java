package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Orchextra.sdkInitialize(getApplicationContext(), "e4b4cb3331f8c1432ab841e49b7c0609ed94c483", "7de522cef430f53c46dc508cc16c69657dc32f6f");
    }
}
