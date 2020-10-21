package com.example.retrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Model.Categorymodel;

public class Adapter extends RecyclerView.Adapter<Adapter.My_vh>{

    public Adapter(Categorymodel categorymodel, Context context) {
        this.categorymodel = categorymodel;
        this.context = context;
    }

    Categorymodel categorymodel;
    Context context;

    @NonNull
    @Override
    public My_vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

      View  my_view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shape, viewGroup, false);
        return new My_vh(my_view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull My_vh holder, int position) {
        holder.name.setText(categorymodel.getCategories().get(position).getStrCategory());
        Log.e("name",categorymodel.getCategories().get(position).getStrCategory());

    }

    @Override
    public int getItemCount() {
        return categorymodel.getCategories().size();
    }

    class My_vh extends RecyclerView.ViewHolder {
TextView name;
ImageView image;

        public My_vh(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.categ_img);
            name=itemView.findViewById(R.id.categ_name);
        }
    }
}
