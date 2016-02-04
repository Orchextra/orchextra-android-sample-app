package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.initalization.OrchextraCompletionCallback;

public class App extends Application implements OrchextraCompletionCallback {

    @Override
    public void onCreate() {
        super.onCreate();

        Orchextra.sdkInitialize(this , "e4b4cb3331f8c1432ab841e49b7c0609ed94c483",
            "7de522cef430f53c46dc508cc16c69657dc32f6f", this);
    }

    @Override public void onSuccess() {

    }

    @Override public void onError(String s) {

    }
}
