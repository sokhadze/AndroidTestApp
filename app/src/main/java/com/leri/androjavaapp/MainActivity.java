package com.leri.androjavaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView view = (RecyclerView) findViewById(R.id.viewForResponse);
        apiInterface = APIClient.getClient().create(APIInterface.class);



        Call<ToDoModel> call = apiInterface.doGetListResources();

        call.enqueue(new Callback<ToDoModel>() {
            @Override
            public void onResponse(Call<ToDoModel> call, Response<ToDoModel> response) {


//                Log.d("TAG",response.code()+"");


//                Integer id = resource.id;
//                Integer userId = resource.userId;
//                String completed = resource.completed;
//                String title = resource.title;

                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                List<ToDoModel> resource = (List<ToDoModel>) response.body();

                for (ToDoModel datum : resource) {
                    displayResponse += datum.id + " " + datum.userId + " " + datum.completed + " " + datum.title + "\n";
                }

                responseText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<ToDoModel> call, Throwable t) {
                call.cancel();
            }
        });


    }
}
