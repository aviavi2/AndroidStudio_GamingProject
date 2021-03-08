package com.example.gamingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayGameActivity extends AppCompatActivity {

    private final String KEY3="displayKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_game);
        String game_id = getIntent().getStringExtra(KEY3);
        //set the correct picture to game by id
        String picture_name="@drawable/a"+game_id;
        int image=getResources().getIdentifier(picture_name,null,this.getPackageName());
        ImageView iv_picture=findViewById(R.id.imageView);
        iv_picture.setImageResource(image);

        TextView tv_trailer=findViewById(R.id.tv_trailer);
        TextView tv_Name=findViewById(R.id.tv_gameName);
        TextView tv_Series=findViewById(R.id.tv_series);
        TextView tv_Year=findViewById(R.id.tv_year);
        TextView tv_Company=findViewById(R.id.tv_company);
        TextView tv_Genre=findViewById(R.id.tv_genre);
        TextView tv_Desc=findViewById(R.id.tv_desc);
        //set the correct link to game by id
        String trailer_name="@string/a"+game_id;
        int resourceId = this.getResources().getIdentifier(trailer_name, "id", this.getPackageName());
        tv_trailer.setText(Html.fromHtml(getString(resourceId)));
        tv_trailer.setMovementMethod(LinkMovementMethod.getInstance());


        //set initial text
        tv_Series.setText("Series: ");
        tv_Year.setText("Release Year: ");
        tv_Company.setText("Developer: ");
        tv_Genre.setText("Genre: ");
        tv_Desc.setText("Description: ");
        //get required game from db and set information in text views
        DataBaseHelper dataBaseHelper=new DataBaseHelper(DisplayGameActivity.this);
        Game selectedGame=dataBaseHelper.getGameById(game_id);
        tv_Name.setText(selectedGame.getName());
        tv_Series.append(selectedGame.getSeries());
        tv_Year.append(String.valueOf(selectedGame.getYear()));
        tv_Company.append(selectedGame.getCompany());
        tv_Genre.append(selectedGame.getGenre());
        tv_Desc.append(selectedGame.getDesc());


    }
}