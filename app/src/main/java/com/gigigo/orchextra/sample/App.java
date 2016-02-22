package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.domain.abstractions.initialization.OrchextraCompletionCallback;


public class App extends Application implements OrchextraCompletionCallback {

    @Override
    public void onCreate() {
        super.onCreate();
        Orchextra.sdkInitialize(this , "51318cdb73dc01a329ef9a04f155d744ffacedfe", "c29fd5e7d09c24474b74b297a3e7eef57cd1d2bc", this);
    }

    @Override public void onSuccess() {

    }

    @Override public void onError(String s) {

    }
}
