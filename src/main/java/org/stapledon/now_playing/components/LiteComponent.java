package org.stapledon.now_playing.components;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@SuppressWarnings("java:S2095")
public class LiteComponent implements Closeable {

    protected Connection conn;
    protected String dbURL;

    /**
     * Open the History data_file
     */
    protected void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(dbURL);
            log.error("Connected to the database");
            var dm = conn.getMetaData();
            log.error("Driver name: {}", dm.getDriverName());
            log.error("Driver version: {}", dm.getDriverVersion());
            log.error("Product name: {}", dm.getDatabaseProductName());
            log.error("Product version: {}", dm.getDatabaseProductVersion());
        } catch (ClassNotFoundException | SQLException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public void tables() {
        try {
            var sql = "SELECT * FROM sqlite_schema WHERE type ='table' AND name NOT LIKE 'sqlite_%';";
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                log.info("{}", rs.getString("name"));
            }
            stmt.close();
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage());
        }
    }

    public void close() {
        try {
            if (this.conn != null)
                this.conn.close();
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage());
        } finally {
            this.conn = null;
        }
    }
}
