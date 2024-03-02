package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        super(R.layout.activity_main);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("some_int", 0);
        /*    getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view,
                            Fragment_1.class, bundle)
                    .commit();*/
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, Fragment_1.class, null).commit();
        }
        getSupportFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
        @Override
        public void onFragmentResult(@NonNull String
        requestKey, @NonNull Bundle bundle) {
            String result = bundle.getString("bundleKey");
            // Do something with the result
        }
    });
    }
}
