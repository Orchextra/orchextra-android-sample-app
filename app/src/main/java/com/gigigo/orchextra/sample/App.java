package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.domain.abstractions.initialization.OrchextraCompletionCallback;


public class App extends Application implements OrchextraCompletionCallback {

    @Override
    public void onCreate() {
        super.onCreate();
        Orchextra.sdkInitialize(this , "62082e690a55e072f4a8c86aadf514a88a3783f0", "b5816da6633994dbd498fbde3fe8675ebb20ab50", this);
    }

    @Override public void onSuccess() {

    }

    @Override public void onError(String s) {

    }
}
