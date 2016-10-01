package com.example.chrisbennett.mylistview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class summary_view_name extends AppCompatActivity {

    ReviewDBHelper mDbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_view);


        mDbHelper = new ReviewDBHelper(this);
        db = mDbHelper.getReadableDatabase();


        //Cursor c = db.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME,null);
        Cursor c = db.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME + "ORDER BY NAME",null);
        //Cursor d = db2.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME + test,null);
        ReviewCursorAdapter adapter = new ReviewCursorAdapter(this,c);
        ListView listview = (ListView) findViewById(R.id.listView);

        listview.setAdapter(adapter);

    }


}
