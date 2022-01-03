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

public class LanguageAdapter extends ArrayAdapter<LanguageItem> {

    public LanguageAdapter(Context context, ArrayList<LanguageItem> languageList) {
        super(context, 0, languageList);
    }

    public LanguageAdapter(@NonNull Context context, int resource) {
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
                    R.layout.language_spinner_row, parent, false
            );
        }

        TextView textLanguageName = convertView.findViewById(R.id.text_view_language);
        TextView textViewLanguage = convertView.findViewById(R.id.text_view_language_name);

        LanguageItem currentItem = getItem(position);

        if (currentItem != null) {
            textLanguageName.setText(currentItem.getViewLanguage());
            textViewLanguage.setText(currentItem.getLanguageName());
        }

        return convertView;
    }
}
