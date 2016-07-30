package striker.gravitas_android.fragments.Wishlist;

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
import striker.gravitas_android.models.Favourites;

/**
 * Created by root on 30/7/16.
 */
public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.VH> {

    List<Favourites> favourites;
    Context context;
    private RecyclerViewOnClickListener<Favourites> onClickListener;


    public WishlistAdapter(List<Favourites> favourites, Context context) {
        this.context = context;
        this.favourites = favourites;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.event_list, parent, false);
        return new VH(rootView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Favourites favourite = favourites.get(position);
        String organizers = favourite.getOrgs().get(0).getOrganization();
        for (int i = 1; i < favourite.getOrgs().size(); i++) {
            organizers += ", " + favourite.getOrgs().get(i).getOrganization();
        }
        holder.eventName.setText(favourite.getName());
        holder.clubName.setText(organizers);
        holder.wishIcon.setImageResource(R.drawable.ic_circle_check);
    }


    @Override
    public int getItemCount() {
        return favourites.size();
    }

    public void setOnClickListener(RecyclerViewOnClickListener<Favourites> onClickListener) {
        this.onClickListener = onClickListener;
    }


    public class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView clubName, eventName;
        ImageView wishIcon;

        public VH(View itemView) {
            super(itemView);
            clubName = (TextView) itemView.findViewById(R.id.mtv_club);
            eventName = (TextView) itemView.findViewById(R.id.mtv_event);
            wishIcon = (ImageView) itemView.findViewById(R.id.imv_icon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Favourites current = favourites.get(getAdapterPosition());
            onClickListener.onItemClick(current);
        }
    }

}



