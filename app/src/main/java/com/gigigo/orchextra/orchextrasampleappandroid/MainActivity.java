package com.gigigo.orchextra.orchextrasampleappandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.gigigo.orchextra.authentication.Orchextra;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private Button qrScanButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    qrScanButton = (Button) findViewById(R.id.orchextra_qr_scan);

    setButtonActions();
  }

  private void setButtonActions() {
    qrScanButton.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()){
      case R.id.orchextra_qr_scan:
        Orchextra.startScannerActivity();
        break;
      default:
        break;
    }
  }
}
