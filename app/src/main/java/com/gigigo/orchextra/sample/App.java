package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Orchextra.sdkInitialize(getApplicationContext(), "key", "secret");
    }
}
