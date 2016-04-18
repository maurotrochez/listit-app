package com.example.android.comprasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResumeActivity extends AppCompatActivity {

    TextView txtResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        txtResume = (TextView) findViewById(R.id.txtVwResume);
        txtResume.setText(getIntent().getStringExtra("Resume"));
    }
}
