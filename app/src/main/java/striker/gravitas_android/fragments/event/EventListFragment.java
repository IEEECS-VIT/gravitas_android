package striker.gravitas_android.fragments.event;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import striker.gravitas_android.R;
import striker.gravitas_android.Utils.RecyclerViewOnClickListener;
import striker.gravitas_android.Utils.dummyCategoryClass;

/**
 * Created by HP on 7/26/2016.
 */
public class EventListFragment extends Fragment {

    //dummy event list to check

    private static RecyclerView recyclerview;
    private View view;
    private int category;
    private EventListAdapter eventAdapter;
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
        String[][] event = {{"event1", "event2", "event3", "event4", "event5", "event6", "event7", "event8", "event9", "event10"},
                {"club1","club2","club3","club4","club5","club6","club7","club8","club9","club10"}};

        dummyList.clear();
        for(int i=0;i<10;i++){
            dummyList.add(new dummyCategoryClass(event[0][i],event[1][i],R.drawable.ic_circle_check));
        }

    }


}
