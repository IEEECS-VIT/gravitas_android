package striker.gravitas_android.Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by root on 24/7/16.
 */
public class JsonMod {

    JsonObject jsonObject, jsonObject1;
    JsonArray jsonArray, jsonArray1;

    public String modifyJson(JsonObject data) {
        jsonArray = data.getAsJsonArray("events");
        for (JsonElement jsonElement : jsonArray) {
            jsonObject1 = jsonElement.getAsJsonObject();
            jsonArray1 = jsonObject1.getAsJsonArray("organization");
            jsonObject1.remove("organization");
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("organization", jsonArray);
            jsonObject1.add("org", jsonObject2);
        }
        return data.toString();
    }
}
