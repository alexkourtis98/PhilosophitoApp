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
import kourtis.quadrum.philosophito.ui.main.data.Issue;
import kourtis.quadrum.philosophito.ui.main.home.issues.MoralIssueItemActivitiy;

/**
 * Custom ArrayAdapter for displaying Issue items in a ListView.
 * Implements the ViewHolder pattern for optimal performance.
 *
 * @version 2.0
 * @see Issue
 * @see MoralIssueItemActivitiy
 */
public class ListAdapterIssue extends ArrayAdapter<Issue> {

    private final Context mContext;
    private final int mResource;

    /**
     * Constructor for ListAdapterIssue
     *
     * @param context  Application context
     * @param resource Layout resource ID
     * @param objects  List of Issue objects to display
     */
    public ListAdapterIssue(@NonNull Context context, int resource, @NonNull ArrayList<Issue> objects) {
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
            holder.title = convertView.findViewById(R.id.issueTitle);
            holder.description = convertView.findViewById(R.id.issueDesc);
            holder.button = convertView.findViewById(R.id.readmorebtn);

            convertView.setTag(holder);
        } else {
            // Reuse existing view
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data
        Issue issue = getItem(position);
        if (issue != null) {
            if (holder.title != null) {
                holder.title.setText(issue.getTitle());
            }
            if (holder.description != null) {
                holder.description.setText(issue.getShortDescription());
            }
            if (holder.button != null) {
                holder.button.setOnClickListener(v -> goToIssueActivity(issue));
            }
        }

        return convertView;
    }

    /**
     * Launches the issue detail activity with the selected issue data
     *
     * @param issue Issue object to display
     */
    private void goToIssueActivity(Issue issue) {
        if (issue == null) {
            return;
        }

        Intent intent = new Intent(mContext, MoralIssueItemActivitiy.class);
        intent.putExtra(IntentKeys.EXTRA_TITLE, issue.getTitle());
        intent.putExtra(IntentKeys.EXTRA_MD_LOCATION, issue.getMdLocation());
        intent.putExtra(IntentKeys.EXTRA_ENUM_TYPE, issue.getEnumtype());
        intent.putExtra(IntentKeys.EXTRA_AUDIO_LOCATION, issue.getAudioLocation());
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
