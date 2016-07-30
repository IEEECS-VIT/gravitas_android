package striker.gravitas_android.fragments.detail.description;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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
    private List<Event> event;
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

    private void populateData() {
        Realm realm = Realm.getDefaultInstance();
        event = realm.where(Event.class).equalTo("name",eventName).findAll();
        Log.d("Selected",event.toString());
        name.setText("Name: " + event.get(0).getName());
        category.setText("Category: " + event.get(0).getSubCategory());
        teamSize.setText("Team Size: " + String.valueOf(event.get(0).getTeamSize()));
        participationFee.setText("Participation Fee: " + String.valueOf(event.get(0).getParticipationFee()));
        description.setText(event.get(0).getDescription());
        venue.setText("null");
        date.setText("null");
        time.setText("null");
        orgs = event.get(0).getOrgs();
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
}
