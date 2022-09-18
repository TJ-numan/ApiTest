package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView tasksRecyclerView, recyclerView;
    private reAdapter adapter;
    private Toolbar toolbar;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("search your Hospital here");
        ArrayList<FirstAidModel> arrayList = new ArrayList<>();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ims.nrbglife.com/crm/HospitalNetwork/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JesonPlaceHolder jesonPlaceHolder = retrofit.create(JesonPlaceHolder.class);
        Call<List<Post>> call = jesonPlaceHolder.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){

                    textViewResult.setVisibility(View.VISIBLE);
                    textViewResult.setText("code:"+ response.code());
                }

               List<Post> posts =response.body();
                for(Post post: posts){

//                    String content = "";
//                    content+="ID="+post.getId()+"\n";
//                    content+="HospitalCode="+post.getHospitalCode()+"\n";
//                    content+="Dist="+post.getDist()+"\n";
//                    content+="HospitalName="+post.getHospitalName()+"\n";
//                    content+="DistName="+post.getDistName()+"\n\n\n";
//
//                    textViewResult.append(content);

                    arrayList.add(new FirstAidModel(post.getId(),post.getHospitalCode(),post.getHospitalName(),post.getHospitalAddress()));


                    recyclerView = findViewById(R.id.itemsrecycler);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    Log.d("arraysize","size:"+arrayList.size());
                    adapter = new reAdapter(MainActivity.this,arrayList);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setVisibility(View.VISIBLE);
                textViewResult.setText(t.getMessage());

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search_id);
        android.widget.SearchView searchView=(android.widget.SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return true;
    }
}