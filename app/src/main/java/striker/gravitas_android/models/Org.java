package striker.gravitas_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by root on 24/7/16.
 */
public class Org extends RealmObject {

    @SerializedName("organization")
    @Expose
    private String organization;

    public Org(String organization) {
        this.organization = organization;
    }

    public Org() {
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
