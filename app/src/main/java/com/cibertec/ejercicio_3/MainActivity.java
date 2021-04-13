package com.cibertec.ejercicio_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cibertec.ejercicio_3.api.ServiceApi;
import com.cibertec.ejercicio_3.entity.Posts;
import com.cibertec.ejercicio_3.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    ListView lsPosts = null;
    ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsPosts = findViewById(R.id.idListTitle);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        lsPosts.setAdapter(adapter);

        cargadata();

    }

    private void cargadata() {
        ServiceApi api = ConnectionRest.getConexion().create(ServiceApi.class);
        Call<List<Posts>> call =  api.listaPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                mensaje("LISTA CON ÉXITO");
                if(response.isSuccessful()) {
                    List<Posts> posts = response.body();
                    for (Posts x: posts){
                        data.add(x.getTitle());
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                  mensaje(t.getMessage());
                  t.fillInStackTrace();
            }
        });

    }
    public void mensaje(String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(msg);
        alert.show();
    }
}