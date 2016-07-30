package striker.gravitas_android.fragments.detail.description;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import io.realm.Realm;
import io.realm.RealmList;
import striker.gravitas_android.R;
import striker.gravitas_android.activities.CategoryActivity;
import striker.gravitas_android.models.Event;
import striker.gravitas_android.models.Org;

/**
 * Created by HP on 7/29/2016.
 */
public class DescriptionFragment extends Fragment {

    TextView name,org,description,participationFee,venue,time,date,teamSize,category;
    private Event event;
    private String eventName;
    private RealmList<Org> orgs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_description, container, false);

        Bundle args = getArguments();
        if(args != null) {
            eventName = args.getString(CategoryActivity.category_key);
        }
        initialiseTextViews(view);
        populateData();
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void getEvent(Event e) {
        Log.d("DF", "Get event called");
        event = e;
        populateData();

    }

    private void populateData() {

        Realm realm = Realm.getDefaultInstance();
        event = realm.where(Event.class).equalTo("name", eventName).findFirst();
        Log.d("Selected",event.toString());
        name.setText("Name: " + event.getName());
        category.setText("Category: " + event.getSubCategory());
        teamSize.setText("Team Size: " + String.valueOf(event.getTeamSize()));
        participationFee.setText("Participation Fee: " + String.valueOf(event.getParticipationFee()));
        description.setText(event.getDescription());
        venue.setText("null");
        date.setText("null");
        time.setText("null");
        orgs = event.getOrgs();
        String organizations = orgs.get(0).getOrganization();
        for(int j=1;j<orgs.size();j++){
            organizations = organizations + "," + orgs.get(j).getOrganization();
        }
        org.setText("Club/Chapter: " + organizations);
    }

    private void initialiseTextViews(View itemView) {
        name = (TextView) itemView.findViewById(R.id.txt_name);
        org = (TextView) itemView.findViewById(R.id.txt_org);
        category = (TextView) itemView.findViewById(R.id.txt_category);
        description = (TextView) itemView.findViewById(R.id.txt_event_description);
        participationFee = (TextView) itemView.findViewById(R.id.txt_fee);
        venue = (TextView) itemView.findViewById(R.id.txt_venue);
        time = (TextView) itemView.findViewById(R.id.txt_time);
        date = (TextView) itemView.findViewById(R.id.txt_date);
        teamSize = (TextView) itemView.findViewById(R.id.txt_team);
    }

    public void postEventFab() {
        EventBus.getDefault().post(event);
    }
}
