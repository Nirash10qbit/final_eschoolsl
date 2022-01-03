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

public class SubjectAdapter extends ArrayAdapter<SubjectItem> {

    public SubjectAdapter(Context context, ArrayList<SubjectItem> subjectList) {
        super(context, 0, subjectList);
    }

    public SubjectAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView1(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView1(position, convertView, parent);
    }


    private View initView1(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.subject_spinner_row, parent, false
            );
        }

        TextView textSubjectName = convertView.findViewById(R.id.text_view_subject);
        TextView textViewSubject = convertView.findViewById(R.id.text_view_subject_name);

        SubjectItem currentItem = getItem(position);

        if (currentItem != null) {
            textSubjectName.setText(currentItem.getViewSubject());
            textViewSubject.setText(currentItem.getSubjectName());
        }

        return convertView;
    }
}