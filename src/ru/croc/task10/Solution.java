package ru.croc.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {
    private static final int passSize = 7;

    public static String calculatePassword(int countOfThreads, String passwordHash) throws ExecutionException, InterruptedException {
        String result = "";
        long[] points = createArrayOfThreadsPoints(countOfThreads);
        ExecutorService service = Executors.newFixedThreadPool(countOfThreads);

        List<Future<String>> tasks = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            tasks.add(service.submit(new PasswordHash(passwordHash, passSize, points[i], points[i + 1])));
        }
        for (Future<String> task : tasks) {
            if (task.get() != null) {
                service.shutdownNow();
                result = task.get();
                break;
            }
        }
        service.shutdown();
        return result;
    }
    public static long[] createArrayOfThreadsPoints(int countOfThreads) {
        long[] points = new long[countOfThreads + 1];
        long interval = (long) (Math.pow(26, passSize) / countOfThreads);
        for (int i = 1; i < points.length - 1; ++i) {
            points[i] = i*interval;
        }
        points[points.length - 1] = (long) (Math.pow(26, passSize) - 1);
        return points;
    }
}