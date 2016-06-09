package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        assert conn != null;
        try {
            int result;
            result = dropTable(conn, "persons");
            assert result == 1;
            result = createPersonsTable(conn);
            assert result == 1;
            result = insertPerson(conn, "George", 30, "Football");
            result = insertPerson(conn, "George", 30, "Football");
            getAndPrintAllPersons(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    private static int dropTable(Connection conn, String table) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int result = stmt.executeUpdate("DROP TABLE " + table);
            System.out.println("Executed drop table " + table + ".");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return 0;
    }

    private static void getAndPrintAllPersons(Connection conn) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, age, hobby FROM persons");
            System.out.println("Executed select all from persons.");
            System.out.printf("|%5s|%20s|%5s|%20s|\n", "id", "name", "age", "hobby");
            System.out.println("--------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%5d|%20s|%5d|%20s|\n",
                    rs.getInt("id"), rs.getString(2), rs.getInt(3), rs.getString("hobby"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    private static int insertPerson(Connection conn, String name, int age, String hobby) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO persons(name, age, hobby) values(?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, hobby);
            int result = stmt.executeUpdate();
            System.out.println("Executed insert into persons.");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return 0;
    }

    private static int createPersonsTable(Connection conn) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int result = stmt.executeUpdate("CREATE TABLE persons("
                + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                + "name VARCHAR(100) NOT NULL,"
                + "age INT,"
                + "hobby VARCHAR(100) NOT NULL,"
                + "PRIMARY KEY(id)"
                + ")");
            System.out.println("Executed create table persons.");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return 0;
    }

    private static Connection getConnection() {
        // connect via embedded driver
        Connection conn = null;
        String dbURL = "jdbc:derby:G:/ministry/digit/JDBCExample/mydb;create=true";
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected to database.");
        return conn;
    }

}
