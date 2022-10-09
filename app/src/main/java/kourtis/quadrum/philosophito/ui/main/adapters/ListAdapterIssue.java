package kourtis.quadrum.philosophito.ui.main.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.home.issues.MoralIssueItemActivitiy;
import kourtis.quadrum.philosophito.ui.main.data.Issue;

public class ListAdapterIssue extends ArrayAdapter<Issue> {

    private final Context mContext;
    private final int mResource;
    private View view;

    public ListAdapterIssue(@NonNull Context context, int resource, @NonNull ArrayList<Issue> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        this.view = layoutInflater.inflate(mResource, parent, false);
        setUpUI(position);
        return this.view;
    }

    private void setUpUI(int position) {
        setTexts(position);
        onClickOpenMoralIssue(position);
        setImage(position);
    }

    private void setImage(int position) {
        ImageView layoutimg = view.findViewById(R.id.layoutimg);
        int id = view.getResources().getIdentifier(getItem(position).getImage(), "id", getContext().getPackageName());
        layoutimg.setImageResource(id);
        layoutimg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void setTexts(int position) {
        TextView textView = view.findViewById(R.id.issueTitle);
        textView.setText(getItem(position).getTitle());

        TextView textViewdesc = view.findViewById(R.id.issueDesc);
        textViewdesc.setText(getItem(position).getShortDescription());
    }

    private void onClickOpenMoralIssue(int position) {
        LinearLayout item = this.view.findViewById(R.id.item);
        View myview = this.view;
        item.setOnClickListener(click -> {
            Intent intent = new Intent(myview.getContext(), MoralIssueItemActivitiy.class);
            intent.putExtra("title", getItem(position).getTitle());
            intent.putExtra("audiolocation", getItem(position).getAudioLocation());
            intent.putExtra("mdlocation", getItem(position).getMdLocation());
            intent.putExtra("enumname", getItem(position).getEnumname());
            myview.getContext().startActivity(intent);
        });
    }
}
