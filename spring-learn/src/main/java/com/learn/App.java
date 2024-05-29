package com.learn;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Logger logger = Logger.getLogger("日志");
        logger.log(Level.INFO,"info");

        System.out.println(1);
        Object o = new Object();
        try {
            synchronized (o) {
                o.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
