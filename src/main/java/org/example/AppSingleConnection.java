package org.example;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class AppSingleConnection {
    public static void singleConnection() throws Exception {
        DataSource ds = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/testdb", "user", "password");

        int threadCount = 5;
        List<Thread> threads = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            Thread t = new WorkerThread(ds, i + 1);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + "ms");
    }
}
