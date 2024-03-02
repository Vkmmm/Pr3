package com.example.pr3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment_2 extends Fragment {
    private int defaultValue = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("some_int", defaultValue);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        EditText editText = view.findViewById(R.id.editTextText4);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();
                Bundle result = new Bundle();
                result.putString("bundleKey", enteredText);
                getParentFragmentManager().setFragmentResult(
                        "requestKey", result);
                getParentFragment().getParentFragmentManager().beginTransaction().replace(
                        R.id.fragment_container_view, Fragment_1.class, null).commit();
            }
        });

        Button button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            String enteredText = editText.getText().toString();
            Bundle result = new Bundle();
            result.putString("bundKey", enteredText);
            getParentFragmentManager().setFragmentResult(
                    "reqKey", result);
            Bundle bundle = new Bundle();
            bundle.putString("bundleKey", editText.getText().toString());
            requireActivity().getSupportFragmentManager().setFragmentResult("requestKey", bundle);
        });
        return view;
    }

}