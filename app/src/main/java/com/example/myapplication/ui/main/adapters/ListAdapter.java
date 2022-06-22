package com.example.myapplication.ui.main.adapters;

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

import com.example.myapplication.R;
import com.example.myapplication.ui.main.MoralTheoriesItemActivitiy;
import com.example.myapplication.ui.main.data.Theory;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Theory> {

    private Context mContext;
    private int mResource;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Theory> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textView = convertView.findViewById(R.id.theoryTitle);
        textView.setText(getItem(position).getTitle());

        TextView textViewdesc = convertView.findViewById(R.id.theoryDesc);
        textViewdesc.setText(getItem(position).getShortDescription());

        Button readmorebtn = convertView.findViewById(R.id.readmorebtn);
        View finalConvertView = convertView;

        readmorebtn.setOnClickListener(click -> {
            Intent intent = new Intent(finalConvertView.getContext(), MoralTheoriesItemActivitiy.class);
            intent.putExtra("title", getItem(position).getTitle());
            intent.putExtra("content", getItem(position).getFullContent());
            finalConvertView.getContext().startActivity(intent);
        });

//        ImageView imageView = convertView.findViewById(R.id.image);
//        String name = getItem(position).getImage();
//        int id = convertView.getResources().getIdentifier(getItem(position).getImage(), "id", getContext().getPackageName());
//        Drawable drawable = convertView.getResources().getDrawable(id);
//        imageView.setBackground(drawable);

        return convertView;
    }
}
