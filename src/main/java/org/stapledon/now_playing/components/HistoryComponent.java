package org.stapledon.now_playing.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@Slf4j
@SuppressWarnings("java:S2095")

public class HistoryComponent extends LiteComponent {

    public HistoryComponent() {
        this.dbURL = "jdbc:sqlite:./data/history_db";
        open();
    }

    public void recognitionHistory() {
        try {
            var sql = "SELECT count(*) as cnt FROM recognition_history";
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                log.info("# of Songs in database: {}", rs.getInt(1));
            }
            stmt.close();

            sql = "SELECT * FROM recognition_history order by timestamp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var ts = LocalDateTime.ofEpochSecond((long)rs.getFloat("timestamp")/1000, 0, ZoneOffset.UTC);
                log.info("{}, {}, {}", ts, rs.getString("artist"), rs.getString("title"));
            }
            stmt.close();

            sql = "SELECT artist,COUNT(*) as cnt FROM recognition_history group by artist ORDER BY cnt DESC";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                log.info("{}, {}", rs.getString(1), rs.getString(2));
            }
            stmt.close();

        } catch (SQLException e) {
            log.error(e.getLocalizedMessage());
        }
    }


}