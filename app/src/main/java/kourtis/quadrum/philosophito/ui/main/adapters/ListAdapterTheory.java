package kourtis.quadrum.philosophito.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.ui.main.data.Theory;
import kourtis.quadrum.philosophito.ui.main.home.theories.MoralTheoriesItemActivitiy;

/**
 * Custom ArrayAdapter for displaying Theory items in a ListView.
 * Implements the ViewHolder pattern for optimal performance.
 *
 * @version 2.0
 * @see Theory
 * @see MoralTheoriesItemActivitiy
 */
public class ListAdapterTheory extends ArrayAdapter<Theory> {

    private final Context mContext;
    private final int mResource;

    /**
     * Constructor for ListAdapterTheory
     *
     * @param context  Application context
     * @param resource Layout resource ID
     * @param objects  List of Theory objects to display
     */
    public ListAdapterTheory(@NonNull Context context, int resource, @NonNull ArrayList<Theory> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Only inflate when needed
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);

            // Create holder and cache views
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.theoryTitle);
            holder.description = convertView.findViewById(R.id.theoryDesc);
            holder.button = convertView.findViewById(R.id.readmorebtn);

            convertView.setTag(holder);
        } else {
            // Reuse existing view
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data
        Theory theory = getItem(position);
        if (theory != null) {
            if (holder.title != null) {
                holder.title.setText(theory.getTitle());
            }
            if (holder.description != null) {
                holder.description.setText(theory.getShortDescription());
            }
            if (holder.button != null) {
                holder.button.setOnClickListener(v -> goToTheoryActivity(theory));
            }
        }

        return convertView;
    }

    /**
     * Launches the theory detail activity with the selected theory data
     *
     * @param theory Theory object to display
     */
    private void goToTheoryActivity(Theory theory) {
        if (theory == null) {
            return;
        }

        Intent intent = new Intent(mContext, MoralTheoriesItemActivitiy.class);
        intent.putExtra(IntentKeys.EXTRA_TITLE, theory.getTitle());
        intent.putExtra(IntentKeys.EXTRA_MD_LOCATION, theory.getMdLocation());
        intent.putExtra(IntentKeys.EXTRA_ENUM_TYPE, theory.getEnumtype());
        intent.putExtra(IntentKeys.EXTRA_AUDIO_LOCATION, theory.getAudioLocation());
        mContext.startActivity(intent);
    }

    /**
     * ViewHolder pattern to cache view references for performance
     */
    private static class ViewHolder {
        TextView title;
        TextView description;
        Button button;
    }
}
