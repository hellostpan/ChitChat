package com.stpan.chitchat.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stpan.chitchat.R;


public class DynamicFragment extends Fragment {

    public static DynamicFragment newInstance() {
        DynamicFragment fragment = new DynamicFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

}
