package striker.gravitas_android.navigationDrawer.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import striker.gravitas_android.R;

/**
 * Created by HP on 7/25/2016.
 */
public class CustomExpandableListAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private List<String> mExpandableListTitle;
    private Map<String, List<String>> mExpandableListDetail;
    private LayoutInflater mLayoutInflater;
    private int indicator;
    private ExpandableListView mExpandableListView;

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       Map<String, List<String>> expandableListDetail) {
        mContext = context;
        mExpandableListTitle = expandableListTitle;
        mExpandableListDetail = expandableListDetail;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return mExpandableListDetail.get(mExpandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.navigation_list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return mExpandableListDetail.get(mExpandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return mExpandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return mExpandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.navigation_list_group, null);
        }

        ImageView listImageView = (ImageView) convertView.findViewById(R.id.navigationImageView);
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);

        switch (listTitle) {
            case "Licenses":
                listImageView.setImageResource(R.drawable.ic_developer_mode_black_18dp);
                break;
            case "Wishlist":
                listImageView.setImageResource(R.drawable.ic_favorite_black_18dp);
                break;
            case "Contact Us":
                listImageView.setImageResource(R.drawable.ic_email_black_18dp);
                break;
            case "About Gravitas":
                listImageView.setImageResource(R.drawable.ic_info_black_18dp);
                break;
            case "Categories":
                listImageView.setImageResource(R.drawable.ic_format_list_bulleted_black_18dp);
                break;
            case "Register":
                listImageView.setImageResource(R.drawable.ic_public_black_48dp);
                break;

        }
        listTitleTextView.setTypeface(null, Typeface.NORMAL);
        listTitleTextView.setText(listTitle);
        mExpandableListView = (ExpandableListView) parent.findViewById(R.id.navList);
        if (getChildrenCount(listPosition) == 0){
            mExpandableListView.setGroupIndicator(null);
        }else {

        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
