package kourtis.quadrum.philosophito.ui.main.adapters;

import android.annotation.SuppressLint;
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

public class ListAdapterExtra extends ArrayAdapter<ExtraItem> {

    private final Context mContext;
    private final int resource;
    private View view;

    public ListAdapterExtra(@NonNull Context context, int resource, @NonNull ArrayList<ExtraItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
    }

    private void openLink(int position) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(getItem(position).getLink()));
        this.view.getContext().startActivity(i);
    }

    private void markTitleAsHrefTag(int position) {
        TextView textViewTitle = this.view.findViewById(R.id.title);
        String text = "<u> " + getItem(position).getTitle() + " </u>";
        textViewTitle.setText(Html.fromHtml(text));
        textViewTitle.setClickable(true);
        textViewTitle.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setTextsAndListenersAndMarkTag(int position) {
        ((TextView) this.view.findViewById(R.id.description)).setText(getItem(position).getDescription());
        this.view.findViewById(R.id.title).setOnClickListener(click -> openLink(position));
        this.markTitleAsHrefTag(position);
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        this.view = layoutInflater.inflate(resource, parent, false);

        this.setTextsAndListenersAndMarkTag(position);

        return this.view;
    }
}
