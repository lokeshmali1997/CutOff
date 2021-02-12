package com.example.cutoff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class CourseItemFragment extends Fragment {
    RecyclerView datalist;
    List<String> titles;
    List<String> yeartitles;
    List<Integer> images;
    AdapterCourseItem adapterCourseItem;

    public CourseItemFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v =inflater.inflate(R.layout.fragment_course_item, container, false);

        datalist = v.findViewById(R.id.courseitemrecyclerview);

        titles = new ArrayList<>();
        yeartitles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("DTE Maharashtra");
        titles.add("DTE Maharashtra");
        titles.add("DTE Maharashtra");
        titles.add("DTE Maharashtra");


        yeartitles.add("Predication 2020-21");
        yeartitles.add("Predication 2020-21");
        yeartitles.add("Predication 2020-21");
        yeartitles.add("Predication 2020-21");


        images.add(R.drawable.ic_baseline_cast_for_education_24);
        images.add(R.drawable.ic_baseline_cast_for_education_24);
        images.add(R.drawable.ic_baseline_cast_for_education_24);
        images.add(R.drawable.ic_baseline_cast_for_education_24);

        adapterCourseItem = new AdapterCourseItem(getActivity(),titles,yeartitles,images);
        datalist.setLayoutManager(new LinearLayoutManager(getContext()));
        datalist.setAdapter(adapterCourseItem);


        ImageButton imageButton = v.findViewById(R.id.backimgbtn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
                return;
            }
        });


         return v;
    }
}