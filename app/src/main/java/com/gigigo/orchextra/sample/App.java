package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.domain.abstractions.actions.CustomSchemeReceiver;
import com.gigigo.orchextra.domain.abstractions.initialization.OrchextraCompletionCallback;


public class App extends Application implements OrchextraCompletionCallback {

    @Override
    public void onCreate() {
        super.onCreate();
        Orchextra.sdkInitialize(this, "f7ae1c1bb7a556fdc9b517706d6f7a0c041334d9", "1a9e4aeadc38b3234b0cd119279ddfb1d9bf7f28", this);
        Orchextra.setCustomSchemeReceiver(new CustomSchemeReceiver() {
            @Override
            public void onReceive(String scheme) {
                GGGLogImpl.log("SCHEME: " + scheme);
            }
        });
    }

    @Override public void onSuccess() {

    }

    @Override public void onError(String s) {

    }
}
