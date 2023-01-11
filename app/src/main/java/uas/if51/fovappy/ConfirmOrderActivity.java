package uas.if51.fovappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import uas.if51.fovappy.R;

public class ConfirmOrderActivity extends AppCompatActivity {

    private ImageView ivback;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        btnBack = findViewById(R.id.btn_back);
        ivback = findViewById(R.id.iv_back);

        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}