package ru.aikamsoft.connection;

import ru.aikamsoft.exception.NoDataBaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/aikamsoft";
    private String username = "postgres";
    private String password = "postgres";

    private DatabaseConnection(){}

    public void createConnection() throws NoDataBaseConnectionException{
        try{
            this.connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException exception){
            throw new NoDataBaseConnectionException(exception.getMessage());
        }
    }

    public void closeConnection() throws SQLException {
        if (connection!= null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

}
