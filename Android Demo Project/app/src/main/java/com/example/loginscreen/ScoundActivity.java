package com.example.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ScoundActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

       // findViewById(R.id.image_button).setOnClickListener(this);
    }

    public void btnBack(View v) {
        finish();
    }

    public void btnBackImage(View v) {
        finish();
    }
    public void btnNext(View v){
        Intent intent= new Intent(this,ProfileActivity2.class);
        Toast.makeText(this, "Next Activity Open", Toast.LENGTH_SHORT).show();
        startActivity(intent);


    }

}
