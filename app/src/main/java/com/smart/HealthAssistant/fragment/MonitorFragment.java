package com.smart.HealthAssistant.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smart.HealthAssistant.R;
import com.smart.HealthAssistant.util.ECGUtil;
import com.smart.HealthAssistant.view.ECGView;
import com.smart.HealthAssistant.view.TempView;


public class MonitorFragment extends Fragment{
    public Button mECGBtn;
    public Button mTempBtn;
    public ECGView mECGView;
    public TempView mTempView;
    public TextView mECGTv;
    public TextView mTempTv;
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
        mTempView = view.findViewById(R.id.temp_view);
        mECGBtn = view.findViewById(R.id.ecg_btn);
        mTempBtn = view.findViewById(R.id.temp_btn);
        mECGTv = view.findViewById(R.id.ecg_tv);
        mTempTv = view.findViewById(R.id.temp_tv);

        mECGBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mECGBtn.setBackgroundColor(Color.RED);
                mTempBtn.setBackgroundColor(Color.BLACK);
                mECGView.setVisibility(View.VISIBLE);
                mTempView.setVisibility(View.GONE);
                mECGTv.setVisibility(View.VISIBLE);
                mTempTv.setVisibility(View.GONE);
                stop();
                startECG();
            }
        });
        mTempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTempBtn.setBackgroundColor(Color.RED);
                mECGBtn.setBackgroundColor(Color.BLACK);
                mECGView.setVisibility(View.GONE);
                mTempView.setVisibility(View.VISIBLE);
                mECGTv.setVisibility(View.GONE);
                mTempTv.setVisibility(View.VISIBLE);
                stop();
                startTemp();
            }
        });

        mEcgUtil.setListner(new ECGUtil.IDataChangeListner() {
            @Override
            public void onTempChange(final float value) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTempTv.setText("体温："+value+"C");
                    }
                });
            }
        });

        startECG();
    };

    //开始绘制波形
    public void startECG() {
        mEcgUtil.showECGData(mECGView);

    }

    //开始绘制波形
    public void startTemp() {
        mEcgUtil.showTempData(mTempView);
    }

    //停止绘制波形
    public void stop() {
        mEcgUtil.stop();
    }



    public void initData() {

    }


    public Handler mHandler = new Handler();


}
