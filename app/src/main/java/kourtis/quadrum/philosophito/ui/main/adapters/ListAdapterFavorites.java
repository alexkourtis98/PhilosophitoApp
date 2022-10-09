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
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.favorites.FavoriteItemFragment;

public class ListAdapterFavorites extends ArrayAdapter<FavoriteItem> {

    private final Context context;
    private final int resource;

    public ListAdapterFavorites(@NonNull Context context, int resource, @NonNull ArrayList<FavoriteItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        convertView.setId(View.generateViewId());
        TextView textViewTerm = convertView.findViewById(R.id.favtitle);
        textViewTerm.setText(getItem(position).getTitle());

        View finalConvertView = convertView;
        convertView.setOnClickListener(click -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", getItem(position).getTitle());
            bundle.putString("text", getItem(position).getTextcontent());
            bundle.putString("mdlocation", getItem(position).getMdFile());
            bundle.putString("source", getItem(position).getSource());
            bundle.putString("id", String.valueOf(finalConvertView.getId()));

            FavoriteItemFragment dictionaryItemFragment = new FavoriteItemFragment();
            dictionaryItemFragment.setArguments(bundle);

            parent.getRootView().findViewById(R.id.mywrapperlayout).setVisibility(View.GONE);

            ((FragmentActivity) this.context).getSupportFragmentManager().beginTransaction().replace(R.id.wrapperfavframe, dictionaryItemFragment).addToBackStack(null).commit();
        });

        return convertView;
    }
}
