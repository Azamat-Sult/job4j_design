package ru.job4j.ood.dip;

import java.sql.Connection;

public class Example1 {

    // класс Application жестко зависит от класса PostgreSQL

    public class PostgreSQL {
        Connection connection;

        public PostgreSQL(Connection connection) {
            this.connection = connection;
        }
    }

    public class Application {
        Connection conn;

        public Application(PostgreSQL db) {
            this.conn = db.connection;
        }
    }
}
