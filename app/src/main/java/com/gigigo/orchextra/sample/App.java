package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.domain.abstractions.actions.CustomSchemeReceiver;
import com.gigigo.orchextra.sdk.model.ORCUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Orchextra.sdkInitialize(this, "f7ae1c1bb7a556fdc9b517706d6f7a0c041334d9", "1a9e4aeadc38b3234b0cd119279ddfb1d9bf7f28", null);

        Orchextra.setCustomSchemeReceiver(new CustomSchemeReceiver() {
            @Override
            public void onReceive(String scheme) {
                GGGLogImpl.log("SCHEME: " + scheme);
            }
        });

        Orchextra.setUser(new ORCUser("1234567890",
                new GregorianCalendar(1990, 10, 13),
                ORCUser.Gender.ORCGenderMale,
                new ArrayList<>(Arrays.asList("keyword1", "keyword2"))));
    }
}
