package striker.gravitas_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jrummyapps.android.widget.AnimatedSvgView;
import com.szugyi.circlemenu.view.CircleImageView;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import striker.gravitas_android.R;
import striker.gravitas_android.Utils.JsonMod;
import striker.gravitas_android.Utils.RealmExclusionStrategy;
import striker.gravitas_android.Utils.Values;
import striker.gravitas_android.api.ApiRequests;
import striker.gravitas_android.models.Db;

public class Splashscreen extends AppCompatActivity implements Values{

    Gson gson;
    JsonMod jsonMod;

    //timeout in ms
    private int timeout = 2000;

    private AnimatedSvgView animatedSvgView;
    private int index = -1;
    private CircleImageView circleImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        jsonMod = new JsonMod();
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setExclusionStrategies(new RealmExclusionStrategy()).create();
        String json = loadJSONFromAsset();
        Db db = gson.fromJson(jsonMod.modifyJson(gson.fromJson(json,JsonObject.class)), Db.class);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(db);
        realm.commitTransaction();
        realm.close();

        //Splashcreen will be launched every time user opens the app and data will be updated.

        //TODO - Check network connectivity, and if data is null, then do not launch Home.

        animatedSvgView = (AnimatedSvgView)findViewById(R.id.animated_svg_view);
        animatedSvgView.postDelayed(new Runnable() {
            @Override
            public void run() {
                animatedSvgView.start();
            }
        },300);
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

    

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("initial.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
