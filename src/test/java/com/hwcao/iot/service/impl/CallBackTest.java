package com.hwcao.iot.service.impl;

import java.util.Scanner;

public class CallBackTest {


    //redisReceiverService
    static class Listenner{

        public void onMessage(String msg){
        }
    }
    static class MyThread extends Thread{
        private Listenner listenner;
        public void setListenner(Listenner listenner) {
            this.listenner = listenner;
        }
        @Override
        public void run() {
            System.out.println("ooooooooooooooooooooo");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                if (listenner!=null) {
                    listenner.onMessage(scanner.next());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        Listenner l = new Listenner() {
            @Override
            public void onMessage(String msg) {
                System.out.println(msg);
            }
        };
        Listenner l2 = new Listenner() {
            @Override
            public void onMessage(String msg) {
                System.out.println("msg is coming!");
                System.out.println(msg);
            }
        };
        t.setListenner(l2);
        t.join();
        t.start();
    }
}
