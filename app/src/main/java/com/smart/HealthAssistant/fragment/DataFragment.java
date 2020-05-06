package com.smart.HealthAssistant.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smart.HealthAssistant.R;
import com.smart.HealthAssistant.util.FileHelper;


public class DataFragment extends Fragment{

    TextView mSavePathTv;
    Button mSaveDataBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_data, container, false);
        initView(view);

        return view;
    }

    public static DataFragment getInstance() {
        return new DataFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initView(View view){
        mSavePathTv = view.findViewById(R.id.data_save_path_tv);
        mSaveDataBtn = view.findViewById(R.id.data_save_btn);
        mSaveDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileHelper.saveFile();
            }
        });
    };

    public void initData() {

    }




}
