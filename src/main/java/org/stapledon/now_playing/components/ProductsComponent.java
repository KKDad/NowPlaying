package org.stapledon.now_playing.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@Slf4j
public class ProductsComponent extends LiteComponent {

    public ProductsComponent() {
        this.dbURL = "jdbc:sqlite:./data/product.db";
        open();
    }
}