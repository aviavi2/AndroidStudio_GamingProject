package com.example.gamingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SearchSpecificGame extends AppCompatActivity {
    private final String KEY1="colKey";
    private final String KEY2="parameterKey";
    private final String KEY3="displayKey";
    ListView lv_specificList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_specific_game);
        //gets category and sub-category from previous activities
        String str_parameter = getIntent().getStringExtra(KEY2);
        String str_col = getIntent().getStringExtra(KEY1);

        //get the specific games list according to user's selection
        lv_specificList=(ListView)findViewById(R.id.lv_gamesList);
        DataBaseHelper dataBaseHelper=new DataBaseHelper(SearchSpecificGame.this);
        List<Game> specificList=dataBaseHelper.getSpecificGamesList(str_col,str_parameter);
        ArrayAdapter<Game> gamesArrayAdapter=new ArrayAdapter<Game>(SearchSpecificGame.this, android.R.layout.simple_list_item_1,specificList);
        lv_specificList.setAdapter(gamesArrayAdapter);

        //get selected game from list and send its id to DisplayGameActivity
        lv_specificList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Game clickedGame= (Game)parent.getItemAtPosition(position);
                String id_str=String.valueOf(clickedGame.getId());
                Intent i = new Intent(SearchSpecificGame.this,DisplayGameActivity.class);
                i.putExtra(KEY3,id_str);
                startActivity(i);

            }
        });
    }

}