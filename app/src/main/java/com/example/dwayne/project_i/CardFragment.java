package com.example.dwayne.project_i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dwayne.project_i.R;

public class CardFragment extends Fragment{

    public static final String ARG_PAGE = "page";
    public static final String ARG_HELPER = "helper";

    private CardDbHelper mDbHelper;
    private int mPageNumber;

    private String word;
    private String subword;
    private String pos;
    private String trans;

    SQLiteDatabase db = mDbHelper.getReadableDatabase();

    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
    String[] projection = {
            BaseColumns._ID,
            CardContract.cardEntry.WORD,
            CardContract.cardEntry.SUB_WORD,
            CardContract.cardEntry.POS,
            CardContract.cardEntry.TRANS
    };

    // Filter results WHERE "title" = 'My Title'
    String selection = CardContract.cardEntry.WORD + " = ?";
    String[] selectionArgs = { "My Title" };

    // How you want the results sorted in the resulting Cursor
    String sortOrder =
            CardContract.cardEntry._ID + " DESC";

    Cursor cursor = db.query(
            CardContract.cardEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            selection,              // The columns for the WHERE clause
            selectionArgs,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
    );

    public static CardFragment create(int pageNumber, CardDbHelper mDbHelper) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putSerializable(ARG_HELPER, mDbHelper);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        mDbHelper = (CardDbHelper) getArguments().getSerializable(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_layout1, container, false);

        int i = 0;
        while(i != mPageNumber){
            cursor.moveToNext();
        }
        word = cursor.getString(
                cursor.getColumnIndex(CardContract.cardEntry.WORD));
        subword = cursor.getString(
                cursor.getColumnIndex(CardContract.cardEntry.SUB_WORD));
        trans = cursor.getString(
                cursor.getColumnIndex(CardContract.cardEntry.TRANS));
        pos = cursor.getString(
                cursor.getColumnIndex(CardContract.cardEntry.POS));
        cursor.close();

        // Set the title view to show the page number.
        ((TextView) rootView.findViewById(R.id.textView)).setText(word);
        ((TextView) rootView.findViewById(R.id.textView2)).setText(subword);
        ((TextView) rootView.findViewById(R.id.textView3)).setText(trans);
        ((TextView) rootView.findViewById(R.id.textView4)).setText(pos);
        //((ImageView) rootView.findViewById(R.id.imageView)).setImageResource();

        return rootView;
    }
}
