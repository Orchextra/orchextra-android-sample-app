/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gigigo.orchextra.sample;

import android.app.Application;

import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.CustomSchemeReceiver;
import com.gigigo.orchextra.ORCUser;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.OrchextraCompletionCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Orchextra.sdkInitialize(this, "240f87d92474068b4ff8c3913f828212b0e16108", "768d071ce2db5af45725ea791d0e092a6045b955", null);

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
