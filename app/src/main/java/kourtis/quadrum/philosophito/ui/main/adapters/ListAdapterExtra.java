package kourtis.quadrum.philosophito.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.ExtraItem;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.datanames;

public class ListAdapterExtra extends ArrayAdapter<ExtraItem> {

    private Context mContext;
    private int mResource;
    private View view;

    public ListAdapterExtra(@NonNull Context context, int resource, @NonNull ArrayList<ExtraItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    private void saveItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);

        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setId(datanames.CSR.toString());
        favoriteItem.setTextcontent("");
        favoriteItem.setTitle("Corporate Social Responsibility");
        favoriteItem.setMdFile("file:///android_asset/csr.md");

        SharedPreferences.Editor prefsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        prefsEditor.putString(favoriteItem.getId(), json);
        prefsEditor.apply();
    }

    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        this.view.findViewById(R.id.bookmark).setVisibility(View.GONE);
        this.view.findViewById(R.id.bookmarkUnmark).setVisibility(View.VISIBLE);
    }

    private void changeIconToUnbooked() {
        this.view.findViewById(R.id.bookmark).setVisibility(View.VISIBLE);
        this.view.findViewById(R.id.bookmarkUnmark).setVisibility(View.GONE);
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove(datanames.CSR.toString());
        prefsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void setBookMarkListeners() {
        this.view.findViewById(R.id.bookmark).setOnClickListener(click -> {
            bookMark();
            Toast.makeText(getContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        this.view.findViewById(R.id.bookmarkUnmark).setOnClickListener(click -> {
            bookUnmark();
        });
    }

    private void checkIfBooked() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (mPrefs.getAll().containsKey(datanames.CSR.toString())) {
            bookMark();
        } else {
            bookUnmark();
        }
    }

    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);
        this.view = convertView;
        TextView textViewTitle = convertView.findViewById(R.id.title);
        String text = "<u> " + getItem(position).getTitle() + " </u>";
        textViewTitle.setText(Html.fromHtml(text));
//        bookStuff();
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
