package com.example.cutoff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterHomeItem extends RecyclerView.Adapter<AdapterHomeItem.ViewHolder> {
     View v;
     List<String> titles;
     List<Integer> images;
     Context context;
     LayoutInflater inflater ;


     public AdapterHomeItem(Context context, List<String> titles, List<Integer> images)
     {
         this.titles = titles;
         this.images = images;
         this.inflater = LayoutInflater.from(context);
     }

    @NonNull
    @Override
    public AdapterHomeItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_gridview_home,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHomeItem.ViewHolder holder, int position) {
             holder.title.setText(titles.get(position));
             holder.images.setImageResource(images.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,new CourseItemFragment()).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          TextView title;
          ImageView images;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.couesetitle);
            images = itemView.findViewById(R.id.coueseimage);



        }
    }



}
