package com.duongvh19;

import static com.duongvh19.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();


        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join(3000);
                    System.out.println(ANSI_RED + "Another thread interrupted, so I am running again.");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+"Hello again from the main thread.");

        ThreadJoin t1 = new ThreadJoin();
        ThreadJoin t2 = new ThreadJoin();
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
