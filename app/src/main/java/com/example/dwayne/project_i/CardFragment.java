package com.example.dwayne.project_i;

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

    private int mPageNumber;

    public static CardFragment create(int pageNumber) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_layout1, container, false);

        // Set the title view to show the page number.
        ((TextView) rootView.findViewById(R.id.textView)).setText("");
        ((TextView) rootView.findViewById(R.id.textView2)).setText("");
        ((TextView) rootView.findViewById(R.id.textView3)).setText("");
        ((TextView) rootView.findViewById(R.id.textView4)).setText("");
        //((ImageView) rootView.findViewById(R.id.imageView)).setImageResource();
        return rootView;
    }
}
