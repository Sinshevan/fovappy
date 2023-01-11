package uas.if51.fovappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uas.if51.fovappy.R;
import uas.if51.fovappy.adapter.AdapterData;
import uas.if51.fovappy.adapter.AdapterMain;
import uas.if51.fovappy.adapter.MainAdapter;
import uas.if51.fovappy.api.APIRequestData;
import uas.if51.fovappy.api.RetroServer;
import uas.if51.fovappy.models.DataModel;
import uas.if51.fovappy.models.MakananModel;
import uas.if51.fovappy.models.ResponseModel;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listRestaurant = new ArrayList<>();
    private EditText etSearch;
    private TextView tvResto;
    private ImageView btnSearch, ivBack;
    private DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ivBack = findViewById(R.id.iv_back);
        tvResto = findViewById(R.id.tv_resto);
        etSearch = findViewById(R.id.et_search);
        btnSearch = findViewById(R.id.iv_search);
        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(etSearch.getText().toString());
            }
        });
        retrieveData();

        tvResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });

    }


    public void search(String searchname){
        APIRequestData arData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> search = arData.search(searchname);

        search.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(CategoryActivity.this, "Kode : "+ kode + "| Pesan : " + pesan , Toast.LENGTH_SHORT).show();

                listRestaurant = response.body().getData();

                adData = new AdapterMain(CategoryActivity.this, listRestaurant);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void retrieveData(){
        APIRequestData arData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = arData.ardRetrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(CategoryActivity.this, "Kode : "+ kode + "| Pesan : " + pesan , Toast.LENGTH_SHORT).show();

                listRestaurant = response.body().getData();

                adData = new AdapterMain(CategoryActivity.this, listRestaurant);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });

    }


}