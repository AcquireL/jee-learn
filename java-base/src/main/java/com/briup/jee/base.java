package com.briup.jee;


public class base {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("yield cpu time");
//                try {
//                    Thread.sleep(0);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
//        t1.setDaemon(true);
        t1.start();

    }
}
