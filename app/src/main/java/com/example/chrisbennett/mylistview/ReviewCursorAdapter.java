package com.example.chrisbennett.mylistview;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by chris.bennett on 9/27/16.
 */


public class ReviewCursorAdapter extends CursorAdapter {
    public ReviewCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView reviewer = (TextView) view.findViewById(R.id.txtReviewer);
        TextView title = (TextView) view.findViewById(R.id.txtTitle);
        TextView rating = (TextView) view.findViewById(R.id.txtRating);

        // Extract properties from cursor
        String rev = cursor.getString(cursor.getColumnIndexOrThrow(ReviewSchema.Review.COLUMN_NAME_REVIEWER));
        String t = cursor.getString(cursor.getColumnIndexOrThrow(ReviewSchema.Review.COLUMN_NAME_TITLE));
        String rat = cursor.getString(cursor.getColumnIndexOrThrow(ReviewSchema.Review.COLUMN_NAME_RATING));

        // Populate fields with extracted properties
        reviewer.setText(rev);
        title.setText(t);
        rating.setText(rat);

    }
}
