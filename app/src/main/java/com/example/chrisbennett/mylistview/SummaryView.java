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

public class SummaryView extends AppCompatActivity {

    ReviewDBHelper mDbHelper;
    SQLiteDatabase db;
    boolean switchRa = false, switchBr = false, switchNa = false, switchRe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_view);


        mDbHelper = new ReviewDBHelper(this);
        db = mDbHelper.getReadableDatabase();


        //Cursor c = db.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME,null);
        Cursor c = db.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME,null);
        //Cursor d = db2.rawQuery("SELECT * FROM "  + ReviewSchema.Review.TABLE_NAME + test,null);
        ReviewCursorAdapter adapter = new ReviewCursorAdapter(this,c);
        ListView listview = (ListView) findViewById(R.id.listView);

        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create intent
                Intent intent = new Intent(view.getContext(), DetailView.class);

                //pack in info
                intent.putExtra("position",position);

                //start activity
                startActivity(intent);
            }


        });
    }

    public void sortName(View view) {
        if(!switchNa) {
            switchNa = true;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY REVIEWER ASC", null);//name
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
        else {
            switchNa = false;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY REVIEWER DESC", null);//name
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
    }

    public void sortRating(View view) {
        if(!switchRa) {
            switchRa = true;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY RATING ASC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
        else {
            switchRa = false;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY RATING DESC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
    }

    public void sortBrand(View view) {
        if(!switchBr) {
            switchBr = true;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY TITLE ASC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
        else {
            switchBr = false;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY TITLE DESC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
    }

    public void sortReview(View view) {
        if(!switchRe) {
            switchRe = true;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY REViEW ASC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
        else {
            switchRe = false;
            Cursor c = db.rawQuery("SELECT * FROM " + ReviewSchema.Review.TABLE_NAME + " ORDER BY REVIEW DESC", null);
            ReviewCursorAdapter adapter = new ReviewCursorAdapter(this, c);
            ListView listview = (ListView) findViewById(R.id.listView);
            listview.setAdapter(adapter);
        }
    }

    public void returnToAdd(View view) {
        Intent intent = new Intent(this, AddRecord.class);
        startActivity(intent);
    }


}
