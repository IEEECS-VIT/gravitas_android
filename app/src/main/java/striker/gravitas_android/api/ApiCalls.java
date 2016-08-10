package striker.gravitas_android.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 24/7/16.
 */
public interface ApiCalls {

    @GET("api/events/name?q=")
    Call<JsonObject> dbCallback();
}
