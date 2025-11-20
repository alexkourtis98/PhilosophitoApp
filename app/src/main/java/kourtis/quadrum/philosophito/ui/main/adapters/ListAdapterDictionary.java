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
import kourtis.quadrum.philosophito.ui.main.data.DictionaryItem;
import kourtis.quadrum.philosophito.ui.main.home.dictionary.DictionaryItemFragment;

/**
 * Custom ArrayAdapter for displaying DictionaryItem items in a ListView.
 * Implements the ViewHolder pattern for optimal performance.
 *
 * @version 2.0
 * @see DictionaryItem
 * @see DictionaryItemFragment
 */
public class ListAdapterDictionary extends ArrayAdapter<DictionaryItem> {

    private final Context context;
    private final int resource;

    /**
     * Constructor for ListAdapterDictionary
     *
     * @param context  Application context
     * @param resource Layout resource ID
     * @param objects  List of DictionaryItem objects to display
     */
    public ListAdapterDictionary(@NonNull Context context, int resource, @NonNull ArrayList<DictionaryItem> objects) {
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
            holder.title = convertView.findViewById(R.id.termtitle);

            convertView.setTag(holder);
        } else {
            // Reuse existing view
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data
        DictionaryItem item = getItem(position);
        if (item != null) {
            if (holder.title != null) {
                holder.title.setText(item.getTitle());
            }

            // Set click listener
            convertView.setOnClickListener(v -> showDictionaryItemFragment(item, parent));
        }

        return convertView;
    }

    /**
     * Creates a Bundle with dictionary item data
     *
     * @param item DictionaryItem to bundle
     * @return Bundle with item data
     */
    private Bundle makeBundle(DictionaryItem item) {
        Bundle bundle = new Bundle();
        bundle.putString(IntentKeys.EXTRA_TITLE, item.getTitle());
        bundle.putString(IntentKeys.EXTRA_DESCRIPTION, item.getDefinition());
        bundle.putString(IntentKeys.EXTRA_SOURCE_URL, item.getSource());
        return bundle;
    }

    /**
     * Shows the dictionary item detail fragment
     *
     * @param item   DictionaryItem to display
     * @param parent Parent ViewGroup
     */
    private void showDictionaryItemFragment(DictionaryItem item, ViewGroup parent) {
        if (item == null || !(context instanceof FragmentActivity)) {
            return;
        }

        // Create fragment with arguments
        DictionaryItemFragment fragment = new DictionaryItemFragment();
        fragment.setArguments(makeBundle(item));

        // Hide the parent layout
        View wrapperLayout = parent.getRootView().findViewById(R.id.mywrapperlayout);
        if (wrapperLayout != null) {
            wrapperLayout.setVisibility(View.GONE);
        }

        // Show the fragment
        ((FragmentActivity) context)
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.wrapperframe, fragment)
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
