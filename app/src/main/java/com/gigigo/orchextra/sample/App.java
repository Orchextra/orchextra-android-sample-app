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
        Orchextra.sdkInitialize(this, "240f87d92474068b4ff8c3913f828212b0e16108", "768d071ce2db5af45725ea791d0e092a6045b955", this);
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
