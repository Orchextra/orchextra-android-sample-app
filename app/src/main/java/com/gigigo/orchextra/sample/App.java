package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.domain.abstractions.initialization.OrchextraCompletionCallback;

public class App extends Application implements OrchextraCompletionCallback {

    @Override
    public void onCreate() {
        super.onCreate();
        Orchextra.sdkInitialize(this , "key", "secret", this);
    }

    @Override public void onSuccess() {

    }

    @Override public void onError(String s) {

    }
}
