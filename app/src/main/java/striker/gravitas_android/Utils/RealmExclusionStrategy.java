package striker.gravitas_android.Utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import io.realm.RealmObject;

/**
 * Created by striker on 2/29/16.
 */
public class RealmExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaredClass().equals(RealmObject.class);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}