package ru.job4j.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = "create table if not exists " + tableName + "();";
        sendSQLCommand(sql, tableName);
    }

    public void dropTable(String tableName) {
        String sql = "drop table if exists " + tableName + ";";
        sendSQLCommand(sql, tableName);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = "alter table "
                + tableName + " add column "
                + columnName + " " + type + ";";
        sendSQLCommand(sql, tableName);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = "alter table " + tableName + " drop column " + columnName + ";";
        sendSQLCommand(sql, tableName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = "alter table " + tableName + " rename column " + columnName + " to " + newColumnName + ";";
        sendSQLCommand(sql, tableName);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void sendSQLCommand(String command, String tableName) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(command);
            System.out.println(command);
            System.out.println(getScheme(tableName));
            System.out.println("----------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Properties props = new Properties();
        File propsFile = new File("src/main/java/ru/job4j/jdbc/app.properties");
        try {
            props.load(new FileReader(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        TableEditor tableEditor = new TableEditor(props);

        tableEditor.createTable("table_editors_table");
        tableEditor.addColumn("table_editors_table", "column1", "varchar(255)");
        tableEditor.addColumn("table_editors_table", "column2", "varchar(255)");
        tableEditor.dropColumn("table_editors_table", "column1");
        tableEditor.renameColumn("table_editors_table",
                "column2", "column_renamed");
        tableEditor.dropTable("table_editors_table");
    }
}