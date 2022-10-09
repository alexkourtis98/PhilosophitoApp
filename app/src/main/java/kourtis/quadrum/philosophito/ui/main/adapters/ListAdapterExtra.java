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

public class ListAdapterExtra extends ArrayAdapter<ExtraItem> {

    private final Context mContext;
    private final int mResource;

    public ListAdapterExtra(@NonNull Context context, int resource, @NonNull ArrayList<ExtraItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);
        TextView textViewTitle = convertView.findViewById(R.id.title);
        String text = "<u> " + getItem(position).getTitle() + " </u>";
        textViewTitle.setText(Html.fromHtml(text));
        textViewTitle.setClickable(true);
        textViewTitle.setMovementMethod(LinkMovementMethod.getInstance());

        View finalConvertView = convertView;
        textViewTitle.setOnClickListener(click -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getItem(position).getLink()));
            finalConvertView.getContext().startActivity(i);
        });

        TextView textViewDesc = convertView.findViewById(R.id.description);
        textViewDesc.setText(getItem(position).getDescription());

        return convertView;
    }
}
