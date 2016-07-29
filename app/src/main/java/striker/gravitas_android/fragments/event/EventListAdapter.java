package striker.gravitas_android.fragments.event;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import striker.gravitas_android.R;
import striker.gravitas_android.Utils.RecyclerViewOnClickListener;
import striker.gravitas_android.Utils.dummyCategoryClass;
import striker.gravitas_android.models.Event;

/**
 * Created by HP on 7/26/2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.eventViewHolder> {
    private Context context;
    private List<Event> events;
    private RecyclerViewOnClickListener<Event> onClickListener;

    public EventListAdapter(Context context,List<Event> events){
        this.context = context;
        this.events = events;
    }
    @Override
    public eventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.event_list,parent,false);
        return new eventViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(eventViewHolder holder, int position) {
        Event current = events.get(position);
        String organizers = current.getOrgs().get(0).getOrganization();
        for(int i=1;i<current.getOrgs().size();i++){
            organizers+=", "+current.getOrgs().get(i).getOrganization();
        }
        holder.wishIcon.setImageResource(R.drawable.ic_circle_check);
        holder.eventName.setText(current.getName());
        holder.clubName.setText(organizers);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setOnClickListener(RecyclerViewOnClickListener<Event> onClickListener) {
        this.onClickListener = onClickListener;
    }

    class eventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView clubName,eventName;
        ImageView wishIcon;
        public eventViewHolder(View itemView) {
            super(itemView);
            clubName = (TextView) itemView.findViewById(R.id.mtv_club);
            eventName = (TextView) itemView.findViewById(R.id.mtv_event);
            wishIcon = (ImageView) itemView.findViewById(R.id.imv_icon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Event current = events.get(getAdapterPosition());
            onClickListener.onItemClick(current);
        }
    }
}
