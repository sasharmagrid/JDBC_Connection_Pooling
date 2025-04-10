package org.example;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class AppHikariCP {
    public static void hikariConnection() throws Exception {
        DataSource ds = HikariDataSourceFactory.create();

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
