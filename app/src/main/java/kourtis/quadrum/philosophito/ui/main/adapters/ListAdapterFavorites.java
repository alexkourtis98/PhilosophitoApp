package kourtis.quadrum.philosophito.ui.main.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.favorites.FavoriteItemFragment;

/**
 * Custom ArrayAdapter for displaying FavoriteItem items in a ListView.
 * FavoriteItems can be either dictionary terms or moral theories/issues.
 * Implements the ViewHolder pattern for optimal performance.
 *
 * @version 2.0
 * @see FavoriteItem
 * @see FavoriteItemFragment
 */
public class ListAdapterFavorites extends ArrayAdapter<FavoriteItem> {

    private final Context context;
    private final int resource;

    /**
     * Constructor for ListAdapterFavorites
     *
     * @param context  Application context
     * @param resource Layout resource ID
     * @param objects  List of FavoriteItem objects to display
     */
    public ListAdapterFavorites(@NonNull Context context, int resource, @NonNull ArrayList<FavoriteItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Only inflate when needed
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);

            // Create holder and cache views
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.favtitle);

            // Generate unique ID for this view
            convertView.setId(View.generateViewId());

            convertView.setTag(holder);
        } else {
            // Reuse existing view
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data
        FavoriteItem item = getItem(position);
        if (item != null) {
            if (holder.title != null) {
                holder.title.setText(item.getTitle());
            }

            // Set click listener with view ID
            final int viewId = convertView.getId();
            convertView.setOnClickListener(v -> switchToFavoriteFragment(item, viewId, parent));
        }

        return convertView;
    }

    /**
     * Creates a Bundle with favorite item data
     *
     * @param item   FavoriteItem to bundle
     * @param viewId View ID for tracking
     * @return Bundle with item data
     */
    private Bundle makeBundle(FavoriteItem item, int viewId) {
        Bundle bundle = new Bundle();
        bundle.putString(IntentKeys.EXTRA_TITLE, item.getTitle());
        bundle.putString(IntentKeys.EXTRA_DESCRIPTION, item.getTextcontent());
        bundle.putString(IntentKeys.EXTRA_MD_LOCATION, item.getMdFile());
        bundle.putString(IntentKeys.EXTRA_SOURCE_URL, item.getSource());
        bundle.putString(IntentKeys.EXTRA_ENUM_TYPE, item.getEnumtype());
        bundle.putString(IntentKeys.EXTRA_AUDIO_LOCATION, item.getAudiofile());
        bundle.putString("id", String.valueOf(viewId));
        return bundle;
    }

    /**
     * Switches to the favorite item detail fragment
     *
     * @param item   FavoriteItem to display
     * @param viewId View ID for tracking
     * @param parent Parent ViewGroup
     */
    private void switchToFavoriteFragment(FavoriteItem item, int viewId, ViewGroup parent) {
        if (item == null || !(context instanceof FragmentActivity)) {
            return;
        }

        // Create fragment with arguments
        FavoriteItemFragment fragment = new FavoriteItemFragment();
        fragment.setArguments(makeBundle(item, viewId));

        // Hide the parent layout
        View wrapperLayout = parent.getRootView().findViewById(R.id.mywrapperlayout);
        if (wrapperLayout != null) {
            wrapperLayout.setVisibility(View.GONE);
        }

        // Show the fragment
        ((FragmentActivity) context)
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.wrapperfavframe, fragment)
                .addToBackStack(null)
                .commit();
    }

    /**
     * ViewHolder pattern to cache view references for performance
     */
    private static class ViewHolder {
        TextView title;
    }
}
