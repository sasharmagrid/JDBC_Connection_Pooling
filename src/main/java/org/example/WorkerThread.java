package org.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkerThread extends Thread {
    private final DataSource dataSource;
    private final int threadNumber;

    public WorkerThread(DataSource dataSource, int threadNumber) {
        this.dataSource = dataSource;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
//        synchronized (dataSource) {
            try {
                Connection conn = dataSource.getConnection(); // shared connection
                PreparedStatement stmt = conn.prepareStatement("SELECT pg_sleep(2)");

                stmt.execute(); // simulate long-running query
                System.out.println("Thread " + threadNumber + " finished.");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

}
