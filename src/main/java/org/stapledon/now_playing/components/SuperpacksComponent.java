package org.stapledon.now_playing.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SuperpacksComponent extends LiteComponent {

    public SuperpacksComponent() {
        this.dbURL = "jdbc:sqlite:./data/superpacks.db";
        open();
    }
}