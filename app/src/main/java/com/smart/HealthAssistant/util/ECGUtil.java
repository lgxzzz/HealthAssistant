package com.smart.HealthAssistant.util;

import android.widget.TextView;

import com.smart.HealthAssistant.view.ECGView;
import com.smart.HealthAssistant.view.TempView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ECGUtil {
    private Timer timer;
    private TimerTask timerTask;
    /**
     * 模拟ECG数据源
     */
    public void showECGData(final ECGView view){
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
     * 模拟体温数据源
     */
    public void showTempData(final TempView view){
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                float value = new Random().nextFloat()*(6)+35f;
                view.showLine(value);//取得是35-41间的浮点数
                if (listner!=null){
                    listner.onTempChange(value);
                }
            }
        };
        //500表示调用schedule方法后等待500ms后调用run方法，50表示以后调用run方法的时间间隔
        timer.schedule(timerTask,500,1000);
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

    IDataChangeListner listner;

    public IDataChangeListner getListner() {
        return listner;
    }

    public void setListner(IDataChangeListner listner) {
        this.listner = listner;
    }

    public interface IDataChangeListner{
        public void onTempChange(float value);
    }
}


