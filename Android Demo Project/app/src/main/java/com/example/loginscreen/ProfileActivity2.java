 package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView email, password,tv;
    private Spinner spinner;
    private Switch aSwitch;
    private Context context;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
        tv=findViewById(R.id.text1);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        spinner = findViewById(R.id.spinner1);
        aSwitch = (Switch) findViewById(R.id.switch1);
        seekBar= (SeekBar)findViewById(R.id.seekbar1);
       // spinner.setEnabled(false);

        String useremail = getIntent().getStringExtra("keyemail");
        String userpassword = getIntent().getStringExtra("keypassword");

        setAdapter();
        spinner.setEnabled(false);
        email.setText(useremail);
        password.setText(userpassword);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int i=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i=progress;
                tv.setText(""+i+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    spinner.setEnabled(true);
                }
                else{
                    spinner.setEnabled(false);
                }
            }

        });


    }

    private void setAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(ProfileActivity2.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}