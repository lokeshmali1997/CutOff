package com.example.cutoff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCourseItem  extends RecyclerView.Adapter<AdapterCourseItem.ViewHolder> {
    View v;
    List<String> titles;
    List<String> yeartitles;
    List<Integer> images;
    Context context;
    LayoutInflater inflater ;


    public AdapterCourseItem(Context context, List<String> titles,List<String> yeartitles, List<Integer> images)
    {
        this.titles = titles;
        this.yeartitles = yeartitles;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_course_item,parent,false);
        return new AdapterCourseItem.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.yeartitle.setText(yeartitles.get(position));
        holder.images.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,yeartitle;
        ImageView images;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.couesetitle);
            yeartitle = itemView.findViewById(R.id.coueseyear);
            images = itemView.findViewById(R.id.coueseimage);



        }
    }


}
