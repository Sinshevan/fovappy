package uas.if51.fovappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.if51.fovappy.R;
import uas.if51.fovappy.adapter.AdapterData;
import uas.if51.fovappy.adapter.MainAdapter;
import uas.if51.fovappy.adapter.RestarurantData;
import uas.if51.fovappy.api.APIRequestData;
import uas.if51.fovappy.api.RetroServer;
import uas.if51.fovappy.models.DataModel;
import uas.if51.fovappy.models.MakananModel;
import uas.if51.fovappy.models.ResponseModel;

public class RestaurantActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView rvMakanan;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listRestaurant = new ArrayList<>();
    private List<MakananModel> listMakanan = new ArrayList<>();
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        rvMakanan = findViewById(R.id.rv_makanan);
        ivBack = findViewById(R.id.iv_back);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMakanan.setLayoutManager(lmData);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void retrieveData(){
        APIRequestData arData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = arData.restaurant();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                listRestaurant = response.body().getData();

                adData = new RestarurantData(RestaurantActivity.this, listRestaurant);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void retrieveMakanan(){
        APIRequestData arData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = arData.makanan();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                listMakanan = response.body().getMakanan();

                adData = new MainAdapter(RestaurantActivity.this, listMakanan);
                rvMakanan.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}