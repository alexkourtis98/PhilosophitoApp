package kourtis.quadrum.philosophito.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.ExtraItem;

/**
 * Custom ArrayAdapter for displaying ExtraItem items in a ListView.
 * ExtraItems are external links with titles and descriptions.
 * Implements the ViewHolder pattern for optimal performance.
 *
 * @version 2.0
 * @see ExtraItem
 */
public class ListAdapterExtra extends ArrayAdapter<ExtraItem> {

    private final Context mContext;
    private final int resource;

    /**
     * Constructor for ListAdapterExtra
     *
     * @param context  Application context
     * @param resource Layout resource ID
     * @param objects  List of ExtraItem objects to display
     */
    public ListAdapterExtra(@NonNull Context context, int resource, @NonNull ArrayList<ExtraItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Only inflate when needed
            convertView = LayoutInflater.from(mContext).inflate(resource, parent, false);

            // Create holder and cache views
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.description = convertView.findViewById(R.id.description);

            convertView.setTag(holder);
        } else {
            // Reuse existing view
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data
        ExtraItem item = getItem(position);
        if (item != null) {
            if (holder.title != null) {
                markTitleAsLink(holder.title, item.getTitle());
                holder.title.setOnClickListener(v -> openLink(item.getLink()));
            }
            if (holder.description != null) {
                holder.description.setText(item.getDescription());
            }
        }

        return convertView;
    }

    /**
     * Opens an external link in a browser
     *
     * @param link URL to open
     */
    private void openLink(String link) {
        if (link == null || link.isEmpty()) {
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        mContext.startActivity(intent);
    }

    /**
     * Formats the title as an underlined link
     *
     * @param titleView TextView to format
     * @param title     Title text
     */
    private void markTitleAsLink(TextView titleView, String title) {
        if (titleView == null || title == null) {
            return;
        }

        String htmlText = "<u> " + title + " </u>";
        titleView.setText(Html.fromHtml(htmlText));
        titleView.setClickable(true);
        titleView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * ViewHolder pattern to cache view references for performance
     */
    private static class ViewHolder {
        TextView title;
        TextView description;
    }
}
