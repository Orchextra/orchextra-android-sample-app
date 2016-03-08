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

package com.gigigo.orchextra.sample.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gigigo.orchextra.sample.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogTextView extends LinearLayout{

    private final Context context;

    @Bind(R.id.customLogText)
    AutoCompleteTextView customLogText;

    @Bind(R.id.logTextView)
    TextView logTextView;

    @Bind(R.id.refreshButton)
    Button refreshButton;

    public LogTextView(Context context) {
        super(context);
        this.context = context;

        init();
    }

    public LogTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        init();
    }

    public LogTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LogTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;

        init();
    }

    private void init() {
        initViews();
        setAutoCompleteEditText();
        setListeners();
        printAsyncLog();
    }

    private void initViews() {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.log_textview_layout, this, true);
        ButterKnife.bind(this, view);
    }

    private void setAutoCompleteEditText() {
        String[] arr = { "OkHttp", "GGGLogImp","CycledLeScanner"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.select_dialog_item, arr);

        customLogText.setThreshold(0);
        customLogText.setAdapter(adapter);
    }

    private void setListeners() {
        customLogText.addTextChangedListener(textChangedListener);
        refreshButton.setOnClickListener(refreshLogListener);
    }

    private void printAsyncLog() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                printLog();
            }
        });
    }

    private void printLog() {
        try {
            String filterText = customLogText.getText().toString();

            Process process = Runtime.getRuntime().exec("logcat -d *:V");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (TextUtils.isEmpty(filterText) || line.contains(filterText)) {
                    log.append(line + "\n\n");
                }
            }
            logTextView.setText(log.toString());
        } catch (IOException e) {
        }
    }

    private TextWatcher textChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            printLog();
        }
    };

    private OnClickListener refreshLogListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            printAsyncLog();
        }
    };
}
