package com.smart.HealthAssistant.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.HealthAssistant.R;
import com.smart.HealthAssistant.util.ECGUtil;
import com.smart.HealthAssistant.view.ECGView;


public class MonitorFragment extends Fragment{

    public ECGView mECGView;
    public ECGUtil mEcgUtil = new ECGUtil();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_monitor, container, false);
        initView(view);

        return view;
    }

    public static MonitorFragment getInstance() {
        return new MonitorFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initView(View view){
        mECGView = view.findViewById(R.id.ecg_view);
        start();
    };

    //开始绘制波形
    public void start() {
        mEcgUtil.showWaveData(mECGView);

    }
    //停止绘制波形
    public void stop() {
        mEcgUtil.stop();
    }



    public void initData() {

    }




}
