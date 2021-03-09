package com.zhen.maptocanada.utility;

import android.app.Activity;

import androidx.annotation.WorkerThread;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkerPool {
    private static WorkerPool instance;
    private final ExecutorService workingQueue1;
    private final ExecutorService workingQueue2;


    private WorkerPool() {
        workingQueue1 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        workingQueue2 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
    }

    public static WorkerPool getInstance() {
        if (instance == null) {
            synchronized (WorkerPool.class) {
                if (instance == null) {
                    instance = new WorkerPool();
                }
            }
        }
        return instance;
    }

    public void execute1(Runnable r) {
        workingQueue1.execute(r);
    }

    public void execute1(Activity c, Runnable r, Runnable rMain) {
        workingQueue1.execute(() -> {
            r.run();
            c.runOnUiThread(rMain);
        });
    }

    public void execute2(Runnable r) {
        workingQueue2.execute(r);
    }


    public <V> Future<V> submit1(Callable<V> c) {
        return workingQueue1.submit(c);
    }

    public <V> void submit1(Activity a, Callable<V> c1, Callable<V> c2) {
        Future<V> result = workingQueue1.submit(c1);
        a.runOnUiThread(()->{
            workingQueue1.submit(c2);
        });
    }

    public <V> Future<V> submit2(Callable<V> c) {
        return workingQueue2.submit(c);
    }

}
