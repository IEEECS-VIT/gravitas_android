package striker.gravitas_android.Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by root on 24/7/16.
 */
public class JsonMod {
    Gson gson;
    JsonObject jsonObject, jsonObject1;
    JsonArray jsonArray, jsonArray1;

    public JsonMod() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setExclusionStrategies(new RealmExclusionStrategy()).create();
        jsonArray1 = new JsonArray();
    }

    public String modifyJson(JsonObject data) {
        jsonArray = data.getAsJsonArray("events");
        for (JsonElement jsonElement : jsonArray) {
            jsonObject1 = jsonElement.getAsJsonObject();
            List<String> strings = gson.fromJson(jsonObject1.get("organization"), new TypeToken<List<String>>() {
            }.getType());
            Log.d("modify", strings.toString());
            for (int i = 0; i < strings.size(); i++) {
                JsonObject object = new JsonObject();
                object.addProperty("organization", strings.get(i));
                jsonArray1.add(object);
            }
            //jsonArray = gson.fromJson(array,JsonArray.class).getAsJsonArray();
            jsonObject1.remove("organization");
            jsonObject1.add("org", jsonArray1);
        }
        return data.toString();
    }

    public String modJson(JsonObject data) {
        return data.toString();
    }
}
