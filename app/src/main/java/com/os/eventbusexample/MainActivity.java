package com.os.eventbusexample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.os.eventbusexample.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayout, new MyFragment());
        ft.commit();

        binding.btnSendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new Message(binding.etName.getText().toString()));
            }
        });
    }
}