package com.smart.HealthAssistant.util;

import com.smart.HealthAssistant.view.ECGView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ECGUtil {
    private Timer timer;
    private TimerTask timerTask;
    /**
     * 模拟源源不断的数据源
     */
    public void showWaveData(final ECGView view){
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                view.showLine(new Random().nextFloat()*(40f)-20f);//取得是-20到20间的浮点数
            }
        };
        //500表示调用schedule方法后等待500ms后调用run方法，50表示以后调用run方法的时间间隔
        timer.schedule(timerTask,500,100);
    }

    /**
     * 停止绘制波形
     */
    public void stop(){
        if(timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
        if(null != timerTask) {
            timerTask.cancel();
            timerTask = null;
        }
    }
}


