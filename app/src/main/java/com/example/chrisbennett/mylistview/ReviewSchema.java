package com.example.chrisbennett.mylistview;

import android.provider.BaseColumns;

/**
 * Created by chris.bennett on 9/27/16.
 */
public class ReviewSchema {


    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Review.TABLE_NAME + " (" +
                    Review._ID + " INTEGER PRIMARY KEY " + COMMA_SEP +
                    Review.COLUMN_NAME_REVIEWER + TEXT_TYPE + COMMA_SEP + //name
                    Review.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP + //brand
                    Review.COLUMN_NAME_RATING + TEXT_TYPE + COMMA_SEP +
                    Review.COLUMN_NAME_REVIEW + TEXT_TYPE + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Review.TABLE_NAME;


    //private ContactContract() {}


    public static class Review implements BaseColumns {
        public static final String TABLE_NAME = "review";
        public static final String COLUMN_NAME_REVIEWER = "reviewer";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_RATING = "rating";
        public static final String COLUMN_NAME_REVIEW = "review";
    }


}
