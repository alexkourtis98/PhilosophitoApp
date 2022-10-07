package kourtis.quadrum.philosophito.ui.main.adapters;

import android.annotation.SuppressLint;
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
import kourtis.quadrum.philosophito.ui.main.DictionaryItemFragment;
import kourtis.quadrum.philosophito.ui.main.data.DictionaryItem;

public class ListAdapterDictionary extends ArrayAdapter<DictionaryItem> {

    private final Context context;
    private final int resource;
    ArrayList<DictionaryItem> localdictionary;

    public ListAdapterDictionary(@NonNull Context context, int resource, @NonNull ArrayList<DictionaryItem> objects) {
        super(context, resource, objects);
        this.localdictionary = objects;
        this.context = context;
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);
        TextView textViewTerm = convertView.findViewById(R.id.termtitle);
        textViewTerm.setText(getItem(position).getTitle());
//
        View finalConvertView = convertView;
        convertView.setOnClickListener(click -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", getItem(position).getTitle());
            bundle.putString("definition", getItem(position).getDefinition());
            bundle.putString("source", getItem(position).getSource());

            DictionaryItemFragment dictionaryItemFragment = new DictionaryItemFragment();
            dictionaryItemFragment.setArguments(bundle);

            parent.getRootView().findViewById(R.id.mywrapperlayout).setVisibility(View.GONE);
            
            ((FragmentActivity) this.context).getSupportFragmentManager().beginTransaction().replace(R.id.wrapperframe, dictionaryItemFragment).addToBackStack(null).commit();
        });

        return convertView;
    }
}
