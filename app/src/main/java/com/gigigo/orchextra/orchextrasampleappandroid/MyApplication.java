package com.gigigo.orchextra.orchextrasampleappandroid;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.Toast;

import com.gigigo.orchextra.CustomSchemeReceiver;
import com.gigigo.orchextra.ORCUser;
import com.gigigo.orchextra.Orchextra;
import com.gigigo.orchextra.OrchextraCompletionCallback;

import com.gigigo.vuforiaimplementation.ImageRecognitionVuforiaImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
public class MyApplication extends Application {

    //Orchextra constants region
    //constants can be defined at build config as well, this is for the sake of the example

    private final String API_KEY = "key";
    private final String API_SECRET = "secret";

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

        //TODO Set debug is not available in this version
        //default is false, check the log for info about Orchextra
//        Orchextra.setDebug(true);

        //You MUST call init inside app onCreate, otherwise this sdk won't work
        Orchextra.init(this, orchextraCallback);

        //setting Receiver for custom scheme
        Orchextra.setCustomSchemeReceiver(customSchemeReceiver);

        Orchextra.setImageRecognitionModule(new ImageRecognitionVuforiaImpl());

        //start Orchextra
        //You can start Orchextra anywhere in your app
        Orchextra.start(API_KEY, API_SECRET);

        //set Orchextra User
        //Recommended as best practice use this method in login feature for instance
        Orchextra.setUser(orchextraUser);
    }

    //region Orchextra User
    private ORCUser orchextraUser = new ORCUser(ORCHEXTRA_CRM_USER_ID, ORCHEXTRA_USER_BORN_DATE,
            ORCUser.Gender.ORCGenderMale, new ArrayList<>(Arrays.asList(ORCHEXTRA_USER_TAGS)));
   //endregion

    //region Callback Orchextra Start
    private OrchextraCompletionCallback orchextraCallback = new OrchextraCompletionCallback() {
        @Override
        public void onSuccess() {
            Toast.makeText(getApplicationContext(), R.string.orchextra_ok_message, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(String errorMsg) {
            if (errorMsg != null) {
                Toast.makeText(getApplicationContext(), R.string.orchextra_ko_message + " " + errorMsg, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onInit(String message) {
            if (message != null) {
                Toast.makeText(getApplicationContext(), R.string.orchextra_init_message + " " + message, Toast.LENGTH_LONG).show();
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
