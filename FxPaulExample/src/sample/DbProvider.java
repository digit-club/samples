package sample;

import java.sql.*;

public class DbProvider {

    private Connection connection;

    public DbProvider() throws SQLException {
        initDb();
    }

    private void initDb() throws SQLException {
        initConnection();

        String createTable = "CREATE TABLE info(" +
                "name varchar(20) not null," +
                "phone  varchar(20) not null)";

        try {
            createStatement(createTable).execute();
        } catch (SQLException e) {
            if (!e.getMessage().contains("Table/View 'INFO'"))
            {
                throw e;
            }
        }
    }

    public PreparedStatement createStatement(String query) throws SQLException
    {
        return getConnection().prepareStatement(query);
    }

    private Connection getConnection() {
        if (connection != null)
        {
            return connection;
        }

        return initConnection();
    }

    private Connection initConnection()
    {
        String url = "jdbc:derby:E:\\work\\FxPaulExample\\db\\persons;create=true";
        try {
            connection= DriverManager
                    .getConnection(url, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
