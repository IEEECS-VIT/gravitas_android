package striker.gravitas_android.navigationDrawer.datasource;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import striker.gravitas_android.R;

/**
 * Created by HP on 7/25/2016.
 */
public class ExpandableListDataSource {
    /**
     * Returns data of navigation drawer.
     *
     * @param context
     * @return
     */
    public static Map<String, List<String>> getData(Context context) {
        Map<String, List<String>> expandableListData = new TreeMap<>();

        List<String> navHeading = Arrays.asList(context.getResources().getStringArray(R.array.nav_list));

        List<String> wishlist= Arrays.asList(context.getResources().getStringArray(R.array.Wishlist));
        List<String> categories = Arrays.asList(context.getResources().getStringArray(R.array.Categories));
        List<String> about = Arrays.asList(context.getResources().getStringArray(R.array.About));
        List<String> contact = Arrays.asList(context.getResources().getStringArray(R.array.contact));

        expandableListData.put(navHeading.get(1), wishlist);
        expandableListData.put(navHeading.get(2), categories);
        expandableListData.put(navHeading.get(3), about);
        expandableListData.put(navHeading.get(4), contact);

        return expandableListData;
    }
}
