package com.example.chrisbennett.mylistview;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {

    ReviewDBHelper mDbHelper;
    SQLiteDatabase db;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        mDbHelper = new ReviewDBHelper(this);
        db = mDbHelper.getWritableDatabase();


    }


    protected void insertRecord(View v) {
        ContentValues values = new ContentValues();
        String reviewer = ((TextView) findViewById(R.id.txtReviewer)).getText().toString();
        String title = ((TextView) findViewById(R.id.txtTitle)).getText().toString();
        String rating = ((TextView) findViewById(R.id.txtRating)).getText().toString();
        String review = ((TextView) findViewById(R.id.txtReview)).getText().toString();

        values.put(ReviewSchema.Review.COLUMN_NAME_REVIEWER, reviewer); //name
        values.put(ReviewSchema.Review.COLUMN_NAME_TITLE, title); //brand
        values.put(ReviewSchema.Review.COLUMN_NAME_RATING, rating);
        values.put(ReviewSchema.Review.COLUMN_NAME_REVIEW, review);


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ReviewSchema.Review.TABLE_NAME, null, values);


        if(newRowId > -1) {
            Toast.makeText(AddRecord.this, "Review Added!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SummaryView.class);
            startActivity(intent);
        }
        else {
            TextView success = (TextView) findViewById(R.id.txtSuccess);
            success.setText("something went horribly wrong");

        }

    }
}
