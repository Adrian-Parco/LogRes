package com.adrianparco.mylogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextInputEditText email , pass;
    Button button;
    FirebaseAuth firebaseAuth;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailkoo);
        pass = findViewById(R.id.passwordko);
        button = findViewById(R.id.entermo);
        firebaseAuth = firebaseAuth.getInstance();
        relativeLayout = findViewById(R.id.logi);

        relativeLayout.setOnClickListener(null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString().trim();
                String passs = pass.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(emaill,passs).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        }else {
                            Snackbar fail = Snackbar.make(relativeLayout, task.getException().getMessage(),Snackbar.LENGTH_INDEFINITE)
                                    .setAction("Ok", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                        }
                                    });
                            fail.show();

                        }
                    }
                });
            }
        });



    }
}
