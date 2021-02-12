package com.example.cutoff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
      RecyclerView datalist;
    List<String> titles;
    List<Integer> images;
    AdapterHomeItem adapterHomeItem;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

         datalist = v.findViewById(R.id.homerecyclerview);

          titles = new ArrayList<>();
          images = new ArrayList<>();

          titles.add("DTE Maharashtra");
          titles.add("DTE Maharashtra");
          titles.add("DTE Maharashtra");
          titles.add("DTE Maharashtra");
          titles.add("DTE Maharashtra");
          titles.add("DTE Maharashtra");


          images.add(R.drawable.ic_baseline_cast_for_education_24);
          images.add(R.drawable.ic_baseline_cast_for_education_24);
          images.add(R.drawable.ic_baseline_cast_for_education_24);
          images.add(R.drawable.ic_baseline_cast_for_education_24);
          images.add(R.drawable.ic_baseline_cast_for_education_24);
          images.add(R.drawable.ic_baseline_cast_for_education_24);

          adapterHomeItem = new AdapterHomeItem(getActivity(),titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        datalist.setLayoutManager(gridLayoutManager);
        datalist.setAdapter(adapterHomeItem);

        return v;

    }
}