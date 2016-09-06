package striker.gravitas_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by root on 24/7/16.
 */
public class Coordinator extends RealmObject {

    private int k;

    private int j;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("_id")
    @Expose
    private String cid;

    @SerializedName("email")
    @Expose
    private String email;


    public Coordinator(String phone, String name, String cid, String email) {
        this.phone = phone;
        this.name = name;

        this.cid = cid;
        this.email = email;
    }

    public Coordinator() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
