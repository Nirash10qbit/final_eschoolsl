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


public class GradeAdapter extends ArrayAdapter<GradeItem> {

    public GradeAdapter(Context context, ArrayList<GradeItem> gradeList) {
        super(context, 0, gradeList);
    }

    public GradeAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }


    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grade_spinner_row, parent, false
            );
        }

        TextView textGradeName = convertView.findViewById(R.id.text_view_grade);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        GradeItem currentItem = getItem(position);

        if (currentItem != null) {
            textGradeName.setText(currentItem.getGradeName());
            textViewName.setText(currentItem.getViewName());
        }

        return convertView;
    }
}
