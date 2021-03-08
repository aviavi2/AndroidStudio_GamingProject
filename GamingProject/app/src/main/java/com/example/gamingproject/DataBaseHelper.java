package com.example.gamingproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String GAMES_TABLE ="GAMES_TABLE" ;


    public DataBaseHelper(@Nullable Context context) {
        super(context, "games.db", null, 1);
    }
    //create new table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement="CREATE TABLE GAMES_TABLE (ID INTEGER PRIMARY KEY  ,GAME_NAME TEXT,GAME_SERIES TEXT,GAME_YEAR INT,GAME_DESC TEXT,GAME_COMPANY TEXT,GAME_GENRE TEXT )";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //add a game to table
    public boolean addOne(Game game){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("GAME_NAME",game.getName());
        cv.put("GAME_SERIES",game.getSeries());
        cv.put("GAME_YEAR",game.getYear());
        cv.put("GAME_COMPANY",game.getCompany());
        cv.put("GAME_DESC",game.getDesc());
        cv.put("GAME_GENRE",game.getGenre());
        long insert = db.insert("GAMES_TABLE", null, cv);
        if (insert==-1){return false;}
        else {return true;}
    }

   public void deleteAll(){
       SQLiteDatabase db=this.getWritableDatabase();
       db.delete(GAMES_TABLE, null, null);
   }

    //get list of games according to category and sub-category
    public List<Game> getSpecificGamesList(String col_name,String value){
        List<Game> returnList=new ArrayList<>();
        //pull required data from database
        String query="SELECT * FROM "+GAMES_TABLE+" WHERE "+ col_name+" = ?";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,new String[] {value});

        if(cursor.moveToFirst()){
            //loop through cursor (result set) and create new game objects,and put them in returnList
            do {
                int id=cursor.getInt(0);
                String name=cursor.getString(1);
                String series=cursor.getString(2);
                int year=cursor.getInt(3);
                String desc=cursor.getString(4);
                String company=cursor.getString(5);
                String genre=cursor.getString(6);
                Game newGame=new Game(id,name,series,year,desc,company,genre);
                returnList.add(newGame);

            }while (cursor.moveToNext());
        }
        else {
            //fail, do not add anything to list.
        }
        cursor.close();
        db.close();

        return returnList;
    }
    //get game by id
    public Game getGameById(String id_game){

        String query="SELECT * FROM "+GAMES_TABLE+" WHERE ID="+id_game;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        int id=cursor.getInt(0);
        String name=cursor.getString(1);
        String series=cursor.getString(2);
        int year=cursor.getInt(3);
        String desc=cursor.getString(4);
        String company=cursor.getString(5);
        String genre=cursor.getString(6);
        Game newGame=new Game(id,name,series,year,desc,company,genre);
        cursor.close();
        db.close();
        return newGame;
    }


}
