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

import com.applivery.applvsdklib.Applivery;
import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.CustomSchemeReceiver;
import com.gigigo.orchextra.Orchextra;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Applivery.init(this, "56d9601ccf4d6a8d78b5ada0", "6e34a7b04b39cd86ba3081f90fd092b45fc69464", false);

        Orchextra.sdkInitialize(this, "cf35964911b0dbc36990edc57250f5e6d9aed826", "a77a2214c54cbbabcb351dc44f3ee0b24efd198f", null);

//        Orchextra.setCustomSchemeReceiver(new CustomSchemeReceiver() {
//            @Override
//            public void onReceive(String scheme) {
//                GGGLogImpl.log("SCHEME: " + scheme);
//            }
//        });

//        Orchextra.setUser(new ORCUser("1234567890",
//                new GregorianCalendar(1990, 10, 13),
//                ORCUser.Gender.ORCGenderMale,
//                new ArrayList<>(Arrays.asList("keyword1", "keyword2"))));

    }
}
