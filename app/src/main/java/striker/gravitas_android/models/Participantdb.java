package striker.gravitas_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by striker on 2/17/16.
 */
public class Participantdb extends RealmObject {
    private String _id;
    private Participant[] participants;

    public Participantdb(String id, Participant[] participants) {
        _id = id;
        this.participants = participants;
    }
}

class Participant extends RealmObject {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("room")
    private String room;

    @Expose
    @SerializedName("regno")
    private String regno;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("time")
    private String time;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("university")
    private String university;

    @Expose
    @SerializedName("combo")
    private String combo;

    Participant(String name, String phone, String room, String regno, String email, String time, String type, String university, String combo) {
        this.name = name;
        this.phone = phone;
        this.room = room;
        this.regno = regno;
        this.email = email;
        this.time = time;
        this.type = type;
        this.university = university;
        this.combo = combo;
    }
}