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

package com.gigigo.orchextra.sample.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    public static final String CRMID = "CRMID";
    public static final String GENDER = "GENDER";
    public static final String DAY = "DAY";
    public static final String MONTH = "MONTH";
    public static final String YEAR = "YEAR";
    public static final String TAGS = "TAGS";

    public static String getCrmId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString(CRMID, null);
    }

    public static boolean getGender(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getBoolean(GENDER, true);
    }

    public static int getDay(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getInt(DAY, 0);
    }

    public static int getMonth(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getInt(MONTH, 0);
    }

    public static int getYear(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getInt(YEAR, 0);
    }

    public static String getTags(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString(TAGS, "");
    }

    public static void setCrmId(Context context, String crmId) {
        SharedPreferences prefs =
                context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(CRMID, crmId);
        editor.commit();
    }

    public static void setGender(Context context, boolean isMale) {
        SharedPreferences prefs =
                context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(GENDER, isMale);
        editor.commit();
    }

    public static void setBirthDate(Context context, int day, int month, int year) {
        SharedPreferences prefs =
                context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(DAY, day);
        editor.putInt(MONTH, month);
        editor.putInt(YEAR, year);
        editor.commit();
    }

    public static void setTags(Context context, String tags) {
        SharedPreferences prefs =
                context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TAGS, tags);
        editor.commit();
    }
}
