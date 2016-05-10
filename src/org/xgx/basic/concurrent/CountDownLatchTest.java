package org.xgx.basic.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private final static ThreadLocal<String> taskName = new ThreadLocal<>();

    public static void main(final String[] args) throws InterruptedException {
        final Runnable r = () -> {
            System.out.println("task[" + taskName.get() + "] running");
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("task[" + taskName.get() + "] end");
        };

        long elapsed = timeTasks(10, r);
        System.out.println("total time : " + (elapsed / 1000000) + "ms");
    }

    final static long timeTasks(final int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            final int seq = i;
            Thread t = new Thread() {
                @Override
                public void run() {
                    taskName.set("t" + (seq + 1));
                    System.out.println("task[" + taskName.get() + "] start");
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
