package uas.if51.fovappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import uas.if51.fovappy.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRoot, mRef;
    private Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRoot = mDatabase.getReference();

        btnSignOut = findViewById(R.id.btn_signout);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}