package striker.gravitas_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by striker on 2/17/16.
 */
public class Orgdb extends RealmObject {

    @Expose
    @SerializedName("_id")
    private String _id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("type")
    private String type;

    public Orgdb(String id, String name, String type) {
        _id = id;
        this.name = name;
        this.type = type;
    }
}