package com.example.volleytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<AcademicRecommendation> {

    Context context;
    List<AcademicRecommendation> academicRecommendationList;

    public MyAdapter(@NonNull Context context, List<AcademicRecommendation> academicRecommendationList) {
        super(context, R.layout.activity_main2,academicRecommendationList);

        this.context = context;
        this.academicRecommendationList = academicRecommendationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2,null,true);

        TextView t_id = view.findViewById(R.id.txt_id);
        TextView t_name_event = view.findViewById(R.id.txt_name_event);
        TextView t_site_event = view.findViewById(R.id.txt_site_event);
        TextView t_time = view.findViewById(R.id.txt_site_time);

        t_id.setText(String.valueOf(academicRecommendationList.get(position).getId_academic_event()));
        t_name_event.setText(academicRecommendationList.get(position).getName_event());
        t_site_event.setText(academicRecommendationList.get(position).getSite_event());
        t_time.setText(academicRecommendationList.get(position).getStart_time_event());

        return view;
    }
}
