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

/**
 * Created by HP on 7/26/2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.eventViewHolder> {
    private Context context;
    private List<dummyCategoryClass> category;
    private RecyclerViewOnClickListener<dummyCategoryClass> onClickListener;

    public EventListAdapter(Context context,List<dummyCategoryClass> category){
        this.context = context;
        this.category = category;
    }
    @Override
    public eventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.event_list,parent,false);
        return new eventViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(eventViewHolder holder, int position) {
        dummyCategoryClass current = category.get(position);

        holder.wishIcon.setImageResource(current.getIcon());
        holder.eventName.setText(current.getEvent());
        holder.clubName.setText(current.getOrganiser());
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public void setOnClickListener(RecyclerViewOnClickListener<dummyCategoryClass> onClickListener) {
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
            dummyCategoryClass dum = category.get(getAdapterPosition());
            onClickListener.onItemClick(dum);
        }
    }
}
