package com.gigigo.orchextra.orchextrasampleappandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{

  private Button qrScanButton;

  //TODO Scan feature not implemented in this sdk version yet
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    qrScanButton = (Button) findViewById(R.id.orchextra_qr_scan);

//    setButtonActions();
  }

//  private void setButtonActions() {
//    qrScanButton.setOnClickListener(this);
//  }

//  @Override public void onClick(View v) {
//    switch (v.getId()){
//      case R.id.orchextra_qr_scan:
//        Orchextra.startScannerActivity();
//        break;
//      default:
//        break;
//    }
//  }
}
