package striker.gravitas_android.fragments.detail.coordinator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import striker.gravitas_android.R;

/**
 * Created by HP on 7/29/2016.
 */
public class CoordinatorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_coordinator, container, false);
        return view;
    }
}
