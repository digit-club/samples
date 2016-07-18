package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static final String DB_DIR = "mydb";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            removeDerbyFiles();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    static Connection getConnection() throws SQLException {
        // connect via embedded driver
        String dbURL = String.format("jdbc:derby:%s;create=true", DB_DIR);
        return DriverManager.getConnection(dbURL);
    }

    static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (NullPointerException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void removeDerbyFiles() throws IOException {
        File derbyDir = new File(DB_DIR);
        File derbyLog = new File("derby.log");
        try {
            delete(derbyDir);
            delete(derbyLog);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RemoveDerbyFilesException(e);
        }
    }

    static void delete(File f) throws FileNotFoundException {
        if (f.isDirectory()) {
            try {
                for (File c : f.listFiles())
                    delete(c);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete file: " + f);
        System.out.println(f.getName() + " deleted.");
    }
}