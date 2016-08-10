package striker.gravitas_android.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import striker.gravitas_android.Utils.JsonMod;
import striker.gravitas_android.Utils.RealmExclusionStrategy;
import striker.gravitas_android.Utils.Values;
import striker.gravitas_android.models.Db;

/**
 * Created by root on 24/7/16.
 */
public class ApiRequests implements Values {

    Gson gson;
    Retrofit retrofit;

    public void setUpRetrofit() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setExclusionStrategies(new RealmExclusionStrategy()).create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS).addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void getEvents() {
        setUpRetrofit();
        final JsonMod jsonMod = new JsonMod();
        ApiCalls apiCalls = retrofit.create(ApiCalls.class);
        Call<JsonObject> call = apiCalls.dbCallback();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String json = jsonMod.modifyJson(response.body());
                Db db = gson.fromJson(json, Db.class);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(db);
                realm.commitTransaction();
                realm.close();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Req", "Error in api");
                Log.d("Req", t.getMessage());
                Log.d("Req", call.toString());


            }
        });
    }
}
