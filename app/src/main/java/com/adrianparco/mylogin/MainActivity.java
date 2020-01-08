package com.adrianparco.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button signnn, looggg;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signnn = findViewById(R.id.create);
        looggg = findViewById(R.id.log);

        signnn.setOnClickListener(this);
        looggg.setOnClickListener(this);
        firebaseAuth = firebaseAuth.getInstance();

    }

    @Override
    public void onBackPressed() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        if (firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(this,home.class));
            finish();
        }
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create: startActivity(new Intent(this,signup.class));
                break;
            case R.id.log: startActivity(new Intent(this,login.class));
                break;
        }
    }
}
