package com.example.myapplication.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.ui.main.data.DictionaryItem;

import java.util.ArrayList;

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

        return convertView;
    }
}
