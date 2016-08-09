package striker.gravitas_android.fragments.about;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import striker.gravitas_android.R;

/**
 * Created by root on 9/8/16.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {

    private List<TeamMember> teamMemberList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public CircleImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.member_name);
            image = (CircleImageView) view.findViewById(R.id.member_image);
        }
    }
    public TeamAdapter(List<TeamMember>teamMemberList){
        this.teamMemberList = teamMemberList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_member_item,parent,false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TeamMember teamMember = teamMemberList.get(position);
        holder.name.setText(teamMember.getName());
        holder.image.setImageResource(teamMember.getImageResId());
    }

    @Override
    public int getItemCount() {
        return teamMemberList.size();
    }
}
