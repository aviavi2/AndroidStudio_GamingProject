package com.example.gamingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String KEY="MainActivityKEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    //user decide by what category he wants to search,and then the category name is sent to SearchGenreActivity
    public void funcClickGenre(View view) {
        Intent intent = new Intent(this , SearchGenreActivity.class);
        intent.putExtra(KEY,"genre");
        startActivity(intent);
    }

    public void funcClickCompany(View view) {
        Intent intent = new Intent(this , SearchGenreActivity.class);
        intent.putExtra(KEY,"company");
        startActivity(intent);
    }
    public void funcClickSeries(View view) {
        Intent intent = new Intent(this , SearchGenreActivity.class);
        intent.putExtra(KEY,"series");
        startActivity(intent);
    }



}