package org.example;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        AppSingleConnection.singleConnection();
        System.out.println("-----Hikari Execution Begins-----");
        AppHikariCP.hikariConnection();
    }
}
