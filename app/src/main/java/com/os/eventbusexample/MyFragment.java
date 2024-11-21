package com.os.eventbusexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.os.eventbusexample.databinding.FragmentMyBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MyFragment extends Fragment {
    FragmentMyBinding binding;
    View view;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMyBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(Message message){
        binding.tvName.setText(""+message.mes);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

}