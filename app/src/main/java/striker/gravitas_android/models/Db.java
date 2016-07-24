package striker.gravitas_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by root on 24/7/16.
 */
public class Db extends RealmObject {

    @SerializedName("events")
    @Expose
    private RealmList<Event> events;


    public Db(RealmList<Event> events) {
        this.events = events;
    }

    public Db() {
    }

    public RealmList<Event> getEvents() {
        return events;
    }

    public void setEvents(RealmList<Event> events) {
        this.events = events;
    }
}
