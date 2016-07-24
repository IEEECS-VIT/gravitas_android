package striker.gravitas_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by root on 24/7/16.
 */
public class Event extends RealmObject {

    @PrimaryKey
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("subCategory")
    @Expose
    private String subCategory;

    @SerializedName("org")
    @Expose
    private RealmList<Org> org;

    @SerializedName("coordinators")
    @Expose
    private RealmList<Coordinator> coordinators;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("teamSize")
    @Expose
    private int teamSize;

    @SerializedName("participationFee")
    @Expose
    private int participationFee;


    public Event(String name, String category, String subCategory, RealmList<Org> orgs, RealmList<Coordinator> coordinators, String description, int teamSize, int participationFee) {
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.org = orgs;
        this.coordinators = coordinators;
        this.description = description;
        this.teamSize = teamSize;
        this.participationFee = participationFee;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public RealmList<Org> getOrgs() {
        return org;
    }

    public void setOrgs(RealmList<Org> orgs) {
        this.org = orgs;
    }

    public RealmList<Coordinator> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(RealmList<Coordinator> coordinators) {
        this.coordinators = coordinators;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getParticipationFee() {
        return participationFee;
    }

    public void setParticipationFee(int participationFee) {
        this.participationFee = participationFee;
    }
}
