package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_1 extends Fragment {
    private static final String TAG = "MyApp";
    private int defaultValue = 0;
    private ActivityResultLauncher<Intent> mStartForResult;
    private TextView textView;

    public Fragment_1() {
       super(R.layout.relative_layout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, (requestKey, bundle) -> {
                    String result = bundle.getString("bundleKey");
                    Log.d(TAG, "Получены новые данные: " + result);
                });
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("some_int", defaultValue);
        }
        Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Button buttonClick = view.findViewById(R.id.c_button2);
        TextView mt = view.findViewById(R.id.textView8);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                mt.setText(result);
                Log.d(TAG, "Получены новые данные: " + result);
            }
        });
       buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.fragment_container_view, ChildFragment.class, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                Log.d(TAG, "Кнопка нажата (программно)");
            }
        });
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView");
        return view;
    }
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(),"onViewCreated", Toast.LENGTH_LONG).show();
    }

    public void onViewStateRestored (View view, Bundle savedInstanceState)
    {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(),"onViewStateRestored", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

   /* public void onButtonClick(View view)
    {
        Intent intent = new Intent(requireActivity(), SecondActivity.class);
        intent.putExtra("userName", "Mosina Viktoriia");
        startActivity(intent);
        Log.d(TAG, "Кнопка нажата (декларативно)");
        mStartForResult.launch(intent);
    }
*/

}