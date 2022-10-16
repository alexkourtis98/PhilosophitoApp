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
    private View view;
    private ViewGroup parent;

    public ListAdapterFavorites(@NonNull Context context, int resource, @NonNull ArrayList<FavoriteItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    private void setIdToThisView() {
        this.view.setId(View.generateViewId());
    }

    private void setClickListeners(int position) {
        this.view.setOnClickListener(click -> {
            switchToNewFragment(makeBundle(position));
        });
    }

    private Bundle makeBundle(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", getItem(position).getTitle());
        bundle.putString("text", getItem(position).getTextcontent());
        bundle.putString("mdlocation", getItem(position).getMdFile());
        bundle.putString("source", getItem(position).getSource());
        bundle.putString("enumtype", getItem(position).getEnumtype());
        bundle.putString("audiolocation", getItem(position).getAudiofile());
        bundle.putString("id", String.valueOf(this.view.getId()));

        return bundle;
    }

    private void switchToNewFragment(Bundle bundle) {
        FavoriteItemFragment dictionaryItemFragment = new FavoriteItemFragment();
        dictionaryItemFragment.setArguments(bundle);

        this.parent.getRootView().findViewById(R.id.mywrapperlayout).setVisibility(View.GONE);

        ((FragmentActivity) this.context).getSupportFragmentManager().beginTransaction().replace(R.id.wrapperfavframe, dictionaryItemFragment).addToBackStack(null).commit();
    }

    private void setTexts(int position) {
        ((TextView) this.view.findViewById(R.id.favtitle)).setText(getItem(position).getTitle());
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        this.view = layoutInflater.inflate(resource, parent, false);
        this.parent = parent;

        setIdToThisView();
        setTexts(position);
        setClickListeners(position);

        return this.view;
    }
}
