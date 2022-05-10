package com.duongvh19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.duongvh19.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.TEXT_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.TEXT_CYAN);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.TEXT_PURPLE);

       executorService.execute(producer);
       executorService.execute(consumer1);
       executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.TEXT_RED + "I'm being printed for the Callable class");
                return "This is callable results";
            }
        });

        try{
            System.out.println(future.get());
        } catch (ExecutionException e){
            System.out.println("Some thing went wrong");
        } catch (InterruptedException e){
            System.out.println("Thread running the task was interrupted.");
        }

       executorService.shutdown();

    }
}

class MyProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");

        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {

            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Remove" + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}