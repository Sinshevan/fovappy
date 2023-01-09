package uas.if51.fovappy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import uas.if51.fovappy.models.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirmPassword, etFullName;
    private Button btnSignUp, btnSignIn, btnForgotPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRoot, mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRoot = mDatabase.getReference();

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        etFullName = findViewById(R.id.et_fullname);
        btnSignUp = findViewById(R.id.btn_signup);
        btnSignIn = findViewById(R.id.btn_signin);
        btnForgotPassword = findViewById(R.id.btn_resetpassword);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                final String fullName = etFullName.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Enter your email address!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Enter your password!");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Enter your confirm password!");
                    return;
                }
                if (TextUtils.isEmpty(fullName)) {
                    etFullName.setError("Enter your full name!");
                    return;
                }
                if (password.length() < 6) {
                    etPassword.setError("Password too short, enter minimum 6 characters!");
                    return;
                }
                if (!confirmPassword.equals(password)) {
                    etConfirmPassword.setError("Password doesn't match!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
                                    User user = new User(email, fullName);
                                    String userId = task.getResult().getUser().getUid();
                                    mRef = mRoot.child("users").child(userId);
                                    mRef.setValue(user);
                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Sign Up failed!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}