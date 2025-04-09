package org.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkerThread extends Thread {
    private final DataSource dataSource;
    private final int id;

    public WorkerThread(DataSource dataSource, int id) {
        this.dataSource = dataSource;
        this.id = id;
    }

    @Override
    public void run() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT pg_sleep(2)")) {
            stmt.execute();
            System.out.println("Thread" + id + "finished.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
