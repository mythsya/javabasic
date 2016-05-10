package org.xgx.basic.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class ContextSwitchTest {

    static class CSThread extends Thread {
        Thread other = null;
        int nparks = 0;

        public CSThread(final String name) {
            super(name);
        }

        @Override
        public void run() {
            if (turn == null || other == null) {
                throw new NullPointerException();
            }

            int p = 0;
            for (int i = 0; i < ITERATES; i++) {
                while (!turn.compareAndSet(other, this)) {
                    ++p;
                    LockSupport.park();
                }
                LockSupport.unpark(other);
            }

            LockSupport.unpark(other);
            nparks = p;
            System.out.println(getName() + " -- parks : " + nparks);
        }
    }

    private final static int RUNS = 3;
    private final static int ITERATES = 200000;

    private final static AtomicReference<Thread> turn = new AtomicReference<>();

    public static void main(final String[] args) throws InterruptedException {
        for (int i = 1; i <= RUNS; i++) {
            System.out.println("==================== RUN " + i + " ====================");
            test();
            System.out.println();
        }
    }

    private final static void test() throws InterruptedException {
        CSThread ta = new CSThread("a");
        CSThread tb = new CSThread("b");
        ta.other = tb;
        ta.nparks = 0;
        tb.other = ta;
        tb.nparks = 0;
        turn.set(ta);

        long start = System.nanoTime();
        ta.start();
        tb.start();
        ta.join();
        tb.join();
        long end = System.nanoTime();

        long elapsed = end - start;
        System.out.println("total time : " + (elapsed / 1000000) + " ms, average time : " + (elapsed / (ta.nparks + tb.nparks)) + " ns per park.");
    }
}