package com.msaenz424.myandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);
        tvJoke.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }
}
