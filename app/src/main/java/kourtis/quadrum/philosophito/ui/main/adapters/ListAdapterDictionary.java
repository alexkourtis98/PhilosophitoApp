package kourtis.quadrum.philosophito.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.DictionaryItem;

public class ListAdapterDictionary extends ArrayAdapter<DictionaryItem> {

    private Context mContext;
    private int mResource;

    public ListAdapterDictionary(@NonNull Context context, int resource, @NonNull ArrayList<DictionaryItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textViewTerm = convertView.findViewById(R.id.term);
        textViewTerm.setText(getItem(position).getTitle());

        TextView textViewDef = convertView.findViewById(R.id.definition);
        textViewDef.setText(getItem(position).getDefinition());

        TextView textViewSource = convertView.findViewById(R.id.source);

        textViewSource.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(getItem(position).getSource()));
            view.getContext().startActivity(intent);
        });


        return convertView;
    }
}
