package striker.gravitas_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by striker on 2/17/16.
 */
public class Teamdb extends RealmObject {

    @Expose
    @SerializedName("_id")
    private String _id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("room")
    private String room;

    @Expose
    @SerializedName("team")
    private String team;

    public Teamdb(String id, String name, String phone, String email, String type, String room, String team) {
        _id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.room = room;
        this.team = team;
    }
}