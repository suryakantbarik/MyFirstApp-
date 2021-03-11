
package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.loginscreen.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText email;
    EditText password;
    boolean isEmailValid, isPasswordValid;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        setOnClick();
    }
    private void setOnClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity2.class);
                    intent.putExtra("keyemail", email.getText().toString());
                    intent.putExtra("keypassword", password.getText().toString());
                    Toast.makeText(MainActivity.this, "Next Activity Open", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });
    }
    private void init() {
        context = this;
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.confirm_button);
    }
    private boolean isValid(){
       // String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!AppUtils.isValidEmail(email.getText().toString())){
            Toast.makeText(this, "Please enter your valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}




