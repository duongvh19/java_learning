package com.duongvh19;

public class ThreadJoin extends Thread{
    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
    }
}
