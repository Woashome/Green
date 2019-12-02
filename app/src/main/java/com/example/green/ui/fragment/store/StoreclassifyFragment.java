package com.example.green.ui.fragment.store;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.green.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreclassifyFragment extends Fragment {
    static StoreclassifyFragment fragment;

    public StoreclassifyFragment() {
        // Required empty public constructor
    }

    public static StoreclassifyFragment newInstance() {
        if (fragment == null) fragment = new StoreclassifyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_storeclassify, container, false);
    }

}
