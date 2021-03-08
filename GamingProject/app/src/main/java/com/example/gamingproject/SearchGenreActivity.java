package com.example.gamingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchGenreActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String KEY="MainActivityKEY";
    private final String KEY1="colKey";
    private final String KEY2="parameterKey";
    String p="none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_genre);
        //get selected category to search by
        String str = getIntent().getStringExtra(KEY);

        //gives spinner the selected category array
        if(str.equals("genre")) {
            Spinner spinner = (Spinner) findViewById(R.id.spinnerPrimarySearch);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.genre_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            p="GAME_GENRE";

        }

        if(str.equals("company")) {
            Spinner spinner = (Spinner) findViewById(R.id.spinnerPrimarySearch);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.company_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            p="GAME_COMPANY";
        }
        if(str.equals("series")) {
            Spinner spinner = (Spinner) findViewById(R.id.spinnerPrimarySearch);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.series_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            p="GAME_SERIES";

        }

    }
    //sends to SearchSpecificGame the selected category and sub-category
    public void funcSearch(View view) {
        Spinner spinner = (Spinner)findViewById(R.id.spinnerPrimarySearch);
        String text = spinner.getSelectedItem().toString();
        Intent intent = new Intent(this , SearchSpecificGame.class);
        intent.putExtra(KEY1,p);
        intent.putExtra(KEY2,text);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        //Spinner Spinner = (Spinner) findViewById(R.id.spinnerPrimarySearch);
        //text = parent.getItemAtPosition(pos).toString();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}