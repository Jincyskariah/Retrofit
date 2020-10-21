package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit.Model.Categorymodel;
import com.example.retrofit.Retrofit.Retrofitconfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Categorymodel categorymodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.r_view);


        Retrofitconfig retrofitconfig=new Retrofitconfig();
        retrofitconfig.getApi().categ_call().enqueue(new Callback<Categorymodel>() {
            @Override
            public void onResponse(Call<Categorymodel> call, Response<Categorymodel> response) {

                categorymodel=response.body();

                List<Categorymodel.CategoriesBean> catList=categorymodel.getCategories();

                LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new Adapter(categorymodel, MainActivity.this));

            }

            @Override
            public void onFailure(Call<Categorymodel> call, Throwable t) {

            }
        });


    }
}
