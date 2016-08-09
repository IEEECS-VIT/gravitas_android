package striker.gravitas_android.fragments.about;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import striker.gravitas_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutTeamFragment extends Fragment {

    private List<TeamMember> teamMemberList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    public AboutTeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about_team, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view_team);
        teamAdapter = new TeamAdapter(teamMemberList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getData();
        return v;
    }

    private void getData(){

        /*//TODO ENTER DATA HERE
        TeamMember teamMember = new TeamMember("Sample Name",R.drawable.graivtas16);
        teamMemberList.add(teamMember);

        for(int i=0;i<30;i++){
            teamMember = new TeamMember("Sample Name",R.drawable.graivtas16);
            teamMemberList.add(teamMember);
        }*/

        String[] names = {"Shivam Mathur","Ayush Agarwal","Aditya Rola","Sulabh Agarwal","Waris Chutani","Tushar Narula","Prateek Tank","Saurabh Mathur","Harshal Varday","Tanisha Chawla","Sakshi Anand","Mustafa Yusuf","Rutuja Jadhav","Vansh"};
        String[] drawableId = new String[14];
        for (int i=0;i<14;i++) {
            drawableId[i] = "x" + i;
        }

        TeamMember teamMember;

        for (int i=0;i<14;i++) {
            int resId = getResources().getIdentifier(drawableId[i],"drawable",getActivity().getPackageName());
            teamMember = new TeamMember(names[i],resId);
            teamMemberList.add(teamMember);
        }

    }

}
