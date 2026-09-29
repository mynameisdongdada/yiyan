package com.songguoliang.mybatis.service;

public class Demo {

    private static int num =1;

    private static final Object lock =new Object();

    private static final int MAX=20;

    public static void main(String[] args) {
        Thread oddThread=new Thread(()->{
           while (num<=MAX){
               synchronized (lock){
                   while (num %2==0){
                       try {
                           lock.wait();
                       }catch (InterruptedException e){
                           e.printStackTrace();
                       }
                   }
                   if(num >MAX)break;
                   System.out.println("奇数:"+num);
                   num++;
                   lock.notify();
               }
           }
        });

        Thread evenThread=new Thread(()->{
            while(num<=MAX){
                synchronized (lock){
                    while(num %2 != 0){
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    if(num>MAX)break;
                    System.out.println("偶数:"+num);
                    num++;
                    lock.notify();
                }
            }
        });
        oddThread.start();
        evenThread.start();
    }
}
