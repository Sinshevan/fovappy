package uas.if51.fovappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uas.if51.fovappy.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, SignInActivity.class));
                finish();
            }
        });
    }


}