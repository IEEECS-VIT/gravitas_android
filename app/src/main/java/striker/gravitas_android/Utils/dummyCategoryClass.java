package striker.gravitas_android.Utils;

/**
 * Created by HP on 7/25/2016.
 */
public class dummyCategoryClass {
    private int icon;
    private String event;
    private String organiser;

    public dummyCategoryClass(String event, String organiser, int icon) {
        this.icon = icon;
        this.event = event;
        this.organiser = organiser;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }
}
