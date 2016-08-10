package striker.gravitas_android.Utils;

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
    }

    public String modifyJson(JsonObject data) {
        jsonArray = data.getAsJsonArray("events");
        for (JsonElement jsonElement : jsonArray) {
            jsonObject1 = jsonElement.getAsJsonObject();
            jsonArray1 = new JsonArray();
            List<String> strings = gson.fromJson(jsonObject1.get("organization"), new TypeToken<List<String>>() {
            }.getType());
            for (int i = 0; i < strings.size(); i++) {
                JsonObject object = new JsonObject();
                object.addProperty("organization", strings.get(i));
                jsonArray1.add(object);
            }
            //jsonArray = gson.fromJson(array,JsonArray.class).getAsJsonArray();
            jsonObject1.remove("organization");
            jsonObject1.add("org", jsonArray1);

            if (jsonObject1.get("name").getAsString().contains("\n")) {
                String tempName = jsonObject1.get("name").getAsString();
                tempName.replace("\n", "");
                jsonObject1.remove("name");
                jsonObject1.addProperty("name", tempName);
            }


            if (jsonObject1.get("category").getAsString().equalsIgnoreCase("workshop")) {
                jsonObject1.remove("subCategory");
                jsonObject1.addProperty("subCategory", "workshop");
            } else {
                String tempSubCategory = jsonObject1.get("subCategory").getAsString();
                jsonObject1.remove("subCategory");
                jsonObject1.addProperty("subCategory", tempSubCategory.toLowerCase());

            }
        }
        return data.toString();
    }

    public String modJson(JsonObject data) {
        return data.toString();
    }
}
