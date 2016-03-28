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

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gigigo.ggglogger.GGGLogImpl;
import com.gigigo.orchextra.CustomSchemeReceiver;
import com.gigigo.orchextra.ORCUser;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.device.notifications.AndroidNotificationBuilder;
import com.gigigo.orchextra.domain.model.actions.strategy.OrchextraNotification;
import com.gigigo.orchextra.sample.sharedPreferences.SharedPref;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.toolbar)
  Toolbar toolbar;

  @Bind(R.id.layoutContainer) View layoutContainer;

  @Bind(R.id.crmIdTextView)
  TextView crmIdTextView;

  @Bind(R.id.radioMale) RadioButton radioMale;

  @Bind(R.id.radioFemale) RadioButton radioFemale;

  @Bind(R.id.saveFab)
  FloatingActionButton saveFab;

  @Bind(R.id.dateButton)
  Button dateButton;

  @Bind(R.id.tagTextView)
  EditText tagTextView;

  @Bind(R.id.listTags) TextView listTags;

  @Bind(R.id.addTagButton) Button addTagButton;

  @Bind(R.id.clearTagsButton) Button clearTagsButton;

  @Bind(R.id.openLogViewButton) Button openLogViewButton;

  @Bind(R.id.schemeEditText) EditText schemeEditText;

  @Bind(R.id.clearScheme) Button clearScheme;

  String crmId;
  boolean isMale;
  int day;
  int month;
  int year;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Drawable drawable = getResources().getDrawable(com.gigigo.orchextra.R.mipmap.ic_launcher);

    ButterKnife.bind(this);

    setSupportActionBar(toolbar);

    crmId = SharedPref.getCrmId(this);
    isMale = SharedPref.getGender(this);

    day = SharedPref.getDay(this);
    month = SharedPref.getMonth(this);
    year = SharedPref.getYear(this);

    String savedTags = SharedPref.getTags(this);


    if (crmId != null) {
      crmIdTextView.setText(crmId);
    }

    if (isMale) {
      radioMale.setChecked(true);
    } else {
      radioFemale.setChecked(true);
    }

    if (day != 0) {
      changeTextDateButton();
    }

    listTags.setText(savedTags);

    dateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showDateDialog();
      }
    });

    addTagButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Editable text = tagTextView.getText();
        if (text != null) {
          String s = text.toString();
          if (!s.isEmpty()) {
            listTags.setText(listTags.getText() + s + ", ");
          }
        }
        tagTextView.setText("");
      }
    });

    clearTagsButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        listTags.setText("");
      }
    });

    saveFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        saveCrm();

        sendOrchextraCrm();

        Snackbar.make(layoutContainer, "Se ha guardado y enviando configuración", Snackbar.LENGTH_SHORT).show();
      }
    });

    openLogViewButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, LogActivity.class);
        startActivity(intent);
      }
    });

    Orchextra.setCustomSchemeReceiver(new CustomSchemeReceiver() {
      @Override
      public void onReceive(String scheme) {
        GGGLogImpl.log("scheme:" + scheme);
        schemeEditText.setText(schemeEditText.getText() + "\n" + scheme);

        AndroidNotificationBuilder notificationBuilder = new AndroidNotificationBuilder(MainActivity.this);

        OrchextraNotification orchextraNotification = new OrchextraNotification();
        orchextraNotification.setTitle("Orchextra");
        orchextraNotification.setBody(scheme);

        notificationBuilder.createNotification(orchextraNotification, null);
      }
    });

    clearScheme.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        schemeEditText.setText("");
      }
    });

    schemeEditText.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        layoutContainer.setVisibility(layoutContainer.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
      }
    });
  }

  private void sendOrchextraCrm() {
    List<String> tags = new ArrayList<>();
    if (listTags.getText() != null && listTags.getText().length() > 0) {
      String[] split = listTags.getText().toString().split(",");
      for (String s : split) {
        if (s != null && !s.trim().isEmpty()) {
          tags.add(s.trim());
        }
      }
    }

      ORCUser user = new ORCUser(crmId,
            new GregorianCalendar(year, month - 1, day),
            (isMale?ORCUser.Gender.ORCGenderMale:ORCUser.Gender.ORCGenderFemale),
            tags
    );

    Orchextra.setUser(user);
  }

  protected void showDateDialog() {
    Calendar calendar = Calendar.getInstance();
    new DatePickerDialog(this,
            myDateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)).show();
  }

  private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      MainActivity.this.year = year;
      MainActivity.this.month = monthOfYear + 1;
      MainActivity.this.day = dayOfMonth;

      changeTextDateButton();
    }
  };

  public void changeTextDateButton() {
    dateButton.setText(day + " / " + month + " / " + year);
  }

  private void saveCrm() {
    CharSequence text = crmIdTextView.getText();
    if (text != null) {
      this.crmId = text.toString();
      SharedPref.setCrmId(this, crmId);
    }

    SharedPref.setGender(this, isMale);

    SharedPref.setBirthDate(this, day, month, year);

    SharedPref.setTags(this, listTags.getText().toString());
  }

  public void onRadioButtonClicked(View view) {
    boolean checked = ((RadioButton) view).isChecked();
    switch(view.getId()) {
      case R.id.radioMale:
        if (checked)
          isMale = true;
          break;
      case R.id.radioFemale:
        if (checked)
          isMale = false;
          break;
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main_activity, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.scanner:
        Orchextra.startScannerActivity();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }


}
