package dataModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import displayModel.CounterSprite;

public class Counter {



    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (currentSecond == 60) {
                refresh();
            }
            currentSecond++;
        }
    });
    private int currentSecond;
    private int currentMinute;
    private CounterSprite countSprite;

    public Counter() {

        currentMinute = -1;
        currentSecond = 1;
        this.countSprite = new CounterSprite()
    }

    public int getCurrentSecond() {
        return currentSecond;
    }

    public void setCurrentSecond(int currentSecond) {
        this.currentSecond = currentSecond;
    }

    public int getCurrentMinute() {
        return currentMinute;
    }

    public void setCurrentMinute(int currentMinute) {
        this.currentMinute = currentMinute;
    }

    public void refresh() {
        currentMinute++;
        currentSecond = 0;
    }

    public void start() {
        currentMinute++;
        timer.start();
    }

    public void reset() {
        currentMinute = -1;
        currentSecond = 0;
        timer.stop();
    }
    

}

