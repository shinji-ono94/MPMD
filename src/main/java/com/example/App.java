package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App{

    public static void main(String[] args) {
        final List<String> query1List = new ArrayList<String>();
        final List<String> res1 = new ArrayList<String>();
        final List<String> query2List = new ArrayList<String>();
        final List<String> res2 = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            query1List.add(Integer.toString(i));
            query2List.add(Integer.toString(i+10));
        }
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                query1List.stream().forEach(x -> {res1.add(x + "a");});
                System.out.println(query1List);
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                query2List.stream().forEach(x ->{res2.add(x + "b");});
                System.out.println(query2List);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
