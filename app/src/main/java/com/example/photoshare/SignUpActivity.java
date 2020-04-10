package com.example.photoshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    Button backToSignInButton, signUpButton;
    TextView signUpEmail, signUpPass, signUpConfirm;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backToSignInButton = findViewById(R.id.backToSignIn);
        signUpButton = findViewById(R.id.signUpButton);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPass = findViewById(R.id.signUpPassword);
        signUpConfirm = findViewById(R.id.signUpPasswordConfirm);
        mFirebaseAuth = FirebaseAuth.getInstance();
        backToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signUpEmail.getText().toString();
                String password = signUpPass.getText().toString();
                String confirm = signUpConfirm.getText().toString();
                if(email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    signUpEmail.setError("Please enter a valid email address");
                    signUpEmail.requestFocus();
                    return;
                }
                if(!password.equals(confirm)) {
                    signUpConfirm.setError("Passwords do not match");
                    System.out.println("incorrect password: " + password + " " + confirm);
                    signUpConfirm.requestFocus();
                    return;
                }
                mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Failed to sign you up", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Signed up successfully!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
            }
        });
    }
}
