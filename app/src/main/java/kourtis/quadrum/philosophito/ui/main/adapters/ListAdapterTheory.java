package kourtis.quadrum.philosophito.ui.main.adapters;

import android.annotation.SuppressLint;
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
import kourtis.quadrum.philosophito.ui.main.data.Theory;
import kourtis.quadrum.philosophito.ui.main.home.theories.MoralTheoriesItemActivitiy;

public class ListAdapterTheory extends ArrayAdapter<Theory> {

    private final Context mContext;
    private final int mResource;
    private View view;

    public ListAdapterTheory(@NonNull Context context, int resource, @NonNull ArrayList<Theory> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    private void setTexts(int position) {
        ((TextView) this.view.findViewById(R.id.theoryTitle)).setText(getItem(position).getTitle());
        ((TextView) this.view.findViewById(R.id.theoryDesc)).setText(getItem(position).getShortDescription());
    }

    private void goToTheoryActivity(int position) {
        Intent intent = new Intent(this.view.getContext(), MoralTheoriesItemActivitiy.class);
        intent.putExtra("title", getItem(position).getTitle());
        intent.putExtra("mdLocation", getItem(position).getMdLocation());
        intent.putExtra("enumtype", getItem(position).getEnumtype());
        intent.putExtra("audioLocation", getItem(position).getAudioLocation());
        this.view.getContext().startActivity(intent);
    }

    private void setClickListenersToLayout(int position) {
        Button button = this.view.findViewById(R.id.readmorebtn);
        button.setOnClickListener(click -> {
            goToTheoryActivity(position);
        });
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        this.view = layoutInflater.inflate(mResource, parent, false);

        this.setTexts(position);
        this.setClickListenersToLayout(position);

        return this.view;
    }
}
