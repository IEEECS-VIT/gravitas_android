package striker.gravitas_android.fragments.event;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import striker.gravitas_android.R;
import striker.gravitas_android.Utils.RecyclerViewOnClickListener;
import striker.gravitas_android.Utils.dummyCategoryClass;
import striker.gravitas_android.models.Event;
import striker.gravitas_android.models.Org;

/**
 * Created by HP on 7/26/2016.
 */
public class EventListFragment extends Fragment {

    //dummy event list to check

    private static RecyclerView recyclerview;
    private View view;
    private int category;
    private EventListAdapter eventAdapter;
    private List<Event> events;
    private RealmList<Org> orgs;
    private static List<dummyCategoryClass> dummyList = new ArrayList<dummyCategoryClass>();
    public EventListFragment() {

    }

    public static EventListFragment newInstance(int category) {
        EventListFragment fragment = new EventListFragment();
        fragment.category = category;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event_list, container, false);
        populateDummyClass();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view_category);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);


        eventAdapter = new EventListAdapter(getActivity(), dummyList);
        eventAdapter.setOnClickListener(new RecyclerViewOnClickListener<dummyCategoryClass>(){

            @Override
            public void onItemClick(dummyCategoryClass data) {
                // Intent intent = new Intent(getActivity(),DetailActivity.class);
                //startActivity(intent);
            }
        });

        recyclerview.setAdapter(eventAdapter);

    }

    private void populateDummyClass() {
        Realm realm = Realm.getDefaultInstance();
        String[] currentTab = getResources().getStringArray(R.array.Categories);
        events = realm.where(Event.class).equalTo("subCategory",currentTab[category].toLowerCase()).findAll();
        dummyList.clear();
        for(int i=0;i<events.size();i++){
            orgs = events.get(i).getOrgs();
            String organizations = orgs.get(0).getOrganization();
            for(int j=1;j<orgs.size();j++){
                organizations = organizations + "," + orgs.get(j).getOrganization();
            }
            dummyList.add(new dummyCategoryClass(events.get(i).getName(),organizations,R.drawable.ic_circle_check));
        }
    }
}
