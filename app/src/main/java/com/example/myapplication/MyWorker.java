package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        Log.d("RRR","Worker started!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Data data = new Data.Builder()
                .putString("key1","Hello")
                .putInt("key2", 10).build();
        return Worker.Result.success(data);
    }
}
