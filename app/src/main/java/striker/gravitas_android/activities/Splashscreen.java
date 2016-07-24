package striker.gravitas_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import striker.gravitas_android.R;
import striker.gravitas_android.api.ApiRequests;

public class Splashscreen extends AppCompatActivity {


    //timeout in ms
    private int timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //Splashcreen will be launched every time user opens the app and data will be updated.

        //TO DO - Check network connectivity, and if data is null, then do not launch Home.
        //TO DO - Splashscreen Layout

        //Network request takes longer than timeout set.

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ApiRequests apiRequests = new ApiRequests();
                apiRequests.getEvents();


                //Change the intent to whatever the activity name is.
                Intent intent = new Intent(Splashscreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, timeout);
    }

}
