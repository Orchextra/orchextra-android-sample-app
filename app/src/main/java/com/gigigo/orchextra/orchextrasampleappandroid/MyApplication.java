package com.gigigo.orchextra.orchextrasampleappandroid;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.Toast;

import com.gigigo.orchextra.OrchextraStartCompletionCallback;
import com.gigigo.orchextra.authentication.Orchextra;
import com.gigigo.orchextra.model.CustomSchemeReceiver;
import com.gigigo.orchextra.model.ORCUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
public class MyApplication extends Application {

    //Orchextra constants region
    //constants can be defined at build config as well, this is for the sake of the example

    private final String API_KEY = "YOUR_API_KEY";
    private final String API_SECRET = "YOUR_API_SECRET";
    private final String GOOGLE_PLAY_SERVICES_SENDER_ID = "GOOGLE_PLAY_SERVICES_SENDER_ID";//this id must be created in your developer Google Console

    //the crmId is for identificate this app client, this can be your user ID after log in
    private final String ORCHEXTRA_CRM_USER_ID = "YOUR_CRM_ID";
    //info related about user useful for orchextra
    private final String[] ORCHEXTRA_USER_TAGS = {"keyword1", "keyword2"};
    private final GregorianCalendar ORCHEXTRA_USER_BORN_DATE = new GregorianCalendar(1990, 10, 13);
    //endregion

    @Override
    public void onCreate() {
        super.onCreate();
        initOrchextra();
    }

    private void initOrchextra() {

        //default is false, check the log for info about Orchextra
        Orchextra.setDebug(true);
        //setting Receiver for custom scheme
        Orchextra.setCustomSchemeReceiver(customSchemeReceiver);
        //set Orchextra User
        Orchextra.setUser(orchextraUser);
        //start Orchextra
        Orchextra.start(this, API_KEY, API_SECRET, GOOGLE_PLAY_SERVICES_SENDER_ID, orchextraCallback);
    }

    //region Orchextra User
    private ORCUser orchextraUser = new ORCUser(ORCHEXTRA_CRM_USER_ID, ORCHEXTRA_USER_BORN_DATE,
            ORCUser.Gender.ORCGenderMale, new ArrayList<>(Arrays.asList(ORCHEXTRA_USER_TAGS)));
   //endregion

    //region Callback Orchextra Start
    private OrchextraStartCompletionCallback orchextraCallback = new OrchextraStartCompletionCallback() {
        @Override
        public void onSuccess() {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.orchextra_ok_message, Toast.LENGTH_LONG);
            toast.show();
        }

        @Override
        public void onError(String errorMsg) {
            if (errorMsg != null) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.orchextra_ok_message + errorMsg, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };
    //endregion

    //region Custom Scheme receiver, for add you own bussiness logic
    private CustomSchemeReceiver customSchemeReceiver = new CustomSchemeReceiver() {
        @Override
        public void onReceive(String scheme) {
            Log.i("", "CUSTOM SCHEME-->" + scheme);

            if (scheme != null) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.orchextra_received_custom_scheme + scheme, Toast.LENGTH_LONG);
                toast.show();

                //open browser if received matches with url format
                if (URLUtil.isValidUrl(scheme)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
                    startActivity(browserIntent);
                }

            }
        }
    };
//endregion
}
