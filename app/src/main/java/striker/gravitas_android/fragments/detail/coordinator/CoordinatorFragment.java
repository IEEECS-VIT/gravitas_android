package striker.gravitas_android.fragments.detail.coordinator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmList;
import striker.gravitas_android.R;
import striker.gravitas_android.activities.CategoryActivity;
import striker.gravitas_android.models.Coordinator;
import striker.gravitas_android.models.Event;

/**
 * Created by HP on 7/29/2016.
 */
public class CoordinatorFragment extends Fragment {

    TextView name1,num1,email1,name2,num2,email2,coordinator2;
    private String eventName;
    private Event event;
    private RealmList<Coordinator> coordinator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_coordinator, container, false);

        Bundle args = getArguments();
        if(args != null) {
            eventName = args.getString(CategoryActivity.category_key);
        }
        initialiseTextView(view);
        populateData();

        return view;
    }


    private void populateData() {

        Realm realm = Realm.getDefaultInstance();
        event = realm.where(Event.class).equalTo("name", eventName).findFirst();
        coordinator = event.getCoordinators();
        if(coordinator.get(0) != null) {
            name1.setText("Name: " + coordinator.get(0).getName());
            num1.setText("Contact: " + coordinator.get(0).getPhone());
            email1.setText("Email: " + coordinator.get(0).getEmail());
        }else{
            name1.setText("Name: null");
            num1.setText("Contact: null");
            email1.setText("Email: null");
        }
        if (coordinator.size() == 2){
            name2.setText("Name: " + coordinator.get(1).getName());
            num2.setText("Contact: " + coordinator.get(1).getPhone());
            email2.setText("Email: " + coordinator.get(1).getEmail());
        }else{
            name2.setVisibility(View.GONE);
            num2.setVisibility(View.GONE);
            email2.setVisibility(View.GONE);
            coordinator2.setVisibility(View.GONE);
        }
    }

    private void initialiseTextView(View itemView) {
        name1 = (TextView) itemView.findViewById(R.id.txt_codname);
        name2 = (TextView) itemView.findViewById(R.id.txt_codname2);
        num1 = (TextView) itemView.findViewById(R.id.txt_codcontact);
        num2 = (TextView) itemView.findViewById(R.id.txt_codcontact2);
        email1 = (TextView) itemView.findViewById(R.id.txt_codemail);
        email2 = (TextView) itemView.findViewById(R.id.txt_codemail2);
        coordinator2 = (TextView) itemView.findViewById(R.id.txt_cood2);
    }
}
