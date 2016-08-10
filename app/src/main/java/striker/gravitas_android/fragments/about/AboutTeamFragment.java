package striker.gravitas_android.fragments.about;


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
    private View v;

    public AboutTeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_about_team, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view_team);
        teamAdapter = new TeamAdapter(teamMemberList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getData();
        recyclerView.setNestedScrollingEnabled(false);
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

        String[] names = {"Shivam Mathur\nhttps://github.com/BurnUalive", "Ayush Agarwal\nhttps://github.com/ayushagarwal95", "Aditya Rola\nadityarola@hotmail.com", "Sulabh Agarwal\nhttps://github.com/SulabhAgarwal", "Waris Chutani\nhttps://github.com/waris0023", "Tushar Narula\nhttps://github.com/drenaw", "Prateek Tank\nhttps://github.com/Str1k3-r", "Saurabh Mathur\nhttps://github.com/saurabhmathur96", "Harshal Varday\nhttps://github.com/hvarday", "Tanisha Chawla\nhttps://github.com/TanishaChawla", "Sakshi Anand\nhttps://github.com/sakshianand", "Mustafa Yusuf\nhttps://github.com/myc52", "Rutuja Jadhav\nhttps://github.com/RutujaJadhav", "Vansh\nhttps://github.com/vansh1sh"};
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
