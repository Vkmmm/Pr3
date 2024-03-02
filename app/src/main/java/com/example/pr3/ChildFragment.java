package com.example.pr3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ChildFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        TextView textView = view.findViewById(R.id.ch_text);
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_ch, Fragment_2.class, null).commit();
        getChildFragmentManager().setFragmentResultListener("reqKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                textView.setText(bundle.getString("bundKey"));
            }
        });
        return view;
    }

}