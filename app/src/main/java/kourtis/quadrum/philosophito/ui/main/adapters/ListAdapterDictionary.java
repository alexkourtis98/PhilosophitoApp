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
import kourtis.quadrum.philosophito.ui.main.data.DictionaryItem;
import kourtis.quadrum.philosophito.ui.main.home.dictionary.DictionaryItemFragment;

public class ListAdapterDictionary extends ArrayAdapter<DictionaryItem> {

    private final Context context;
    private final int resource;
    private View view;
    private ViewGroup parent;

    public ListAdapterDictionary(@NonNull Context context, int resource, @NonNull ArrayList<DictionaryItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    private void setTexts(int position) {
        ((TextView) this.view.findViewById(R.id.termtitle)).setText(getItem(position).getTitle());
    }

    private Bundle makeBundle(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", getItem(position).getTitle());
        bundle.putString("definition", getItem(position).getDefinition());
        bundle.putString("source", getItem(position).getSource());

        return bundle;
    }

    private void showDictionaryItemFragment(Bundle bundle) {
        // make fragment
        DictionaryItemFragment dictionaryItemFragment = new DictionaryItemFragment();
        dictionaryItemFragment.setArguments(bundle);

        // make parent view invisible
        this.parent.getRootView().findViewById(R.id.mywrapperlayout).setVisibility(View.GONE);

        // complete parente fragment view with the new one
        ((FragmentActivity) this.context).getSupportFragmentManager().beginTransaction().replace(R.id.wrapperframe, dictionaryItemFragment).addToBackStack(null).commit();
    }

    private void setClickListener(int position) {
        this.view.setOnClickListener(click -> {
            Bundle bundle = makeBundle(position);
            showDictionaryItemFragment(bundle);
        });
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        this.view = layoutInflater.inflate(resource, parent, false);
        this.parent = parent;

        this.setTexts(position);
        this.setClickListener(position);

        return this.view;
    }
}
