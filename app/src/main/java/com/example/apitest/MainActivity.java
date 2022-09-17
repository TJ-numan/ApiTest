package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("search your cats injury here");
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

                    textViewResult.setText("code:"+ response.code());
                }

               List<Post> posts =response.body();
                for(Post post: posts){
                    arrayList.add(new FirstAidModel(post.getId(),post.getHospitalCode(),post.getHospitalName()));

                    String content = "";
                    content+="ID="+post.getId()+"\n";
                    content+="HospitalCode="+post.getHospitalCode()+"\n";
                    content+="Dist="+post.getDist()+"\n";
                    content+="HospitalName="+post.getHospitalName()+"\n";
                    content+="DistName="+post.getDistName()+"\n\n\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });

        recyclerView = findViewById(R.id.itemsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new reAdapter(this,arrayList);
      recyclerView.setAdapter(adapter);

    }
}