package com.example.cutoff;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.cutoff.models.CourseApiResponse;
import com.example.cutoff.retrofitutil.CourseApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    GridView gridView;
    CustomAdapter customAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
//          adapterHomeItem = new AdapterHomeItem(getActivity(),titles,images);
        return v;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.homerecyclerview);

        Call<List<CourseApiResponse>> call = CourseApiClient.courseApiInterface().getCourseApiResponse();

        call.enqueue(new Callback<List<CourseApiResponse>>() {
            @Override
            public void onResponse(Call<List<CourseApiResponse>> call, Response<List<CourseApiResponse>> response) {

                if(response.isSuccessful())
                {
                    customAdapter = new CustomAdapter(response.body(), getActivity());

                    gridView.setAdapter(customAdapter);

                }else{
                    Toast.makeText(getActivity(), "Error occurs!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CourseApiResponse>> call, Throwable t) {

                Toast.makeText(getActivity(), "Error occurs!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public static class CustomAdapter extends BaseAdapter {

        public List<CourseApiResponse> courseList;
        public Context context;

        public CustomAdapter(List<CourseApiResponse> courseList, Context context) {
            this.courseList = courseList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return courseList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            View v = LayoutInflater.from(context).inflate(R.layout.custom_gridview_home, null);

            TextView courseName = v.findViewById(R.id.couesetitle);
            ImageView courseIcon = v.findViewById(R.id.coueseimage);

            courseName.setText(courseList.get(position).getCourseName());

            Glide.with(context)
                    .load(courseList.get(position).getCourseIcon())
                    .into(courseIcon);

            return v;
        }
    }

}