package com.example.myclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SimAdapter extends ArrayAdapter<SimItem> {

    public SimAdapter(Context context, ArrayList<SimItem> SimList) {
        super(context, 0, SimList);
    }

    public SimAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView2(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView2(position, convertView, parent);
    }


    private View initView2(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.sim_spinner_row, parent, false
            );
        }

        TextView textSimName = convertView.findViewById(R.id.text_view_sim);
        TextView textViewSim = convertView.findViewById(R.id.text_view_sim_name);

        SimItem currentItem = getItem(position);

        if (currentItem != null) {
            textSimName.setText(currentItem.getViewSim());
            textViewSim.setText(currentItem.getSimName());
        }

        return convertView;
    }
}
