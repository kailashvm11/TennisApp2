package com.tennis;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTest {

    @Test
    void shouldStartGame() {
        Logger gameLogger = (Logger) LoggerFactory.getLogger(Game.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        gameLogger.addAppender(listAppender);
        Game game = new Game();
        game.startGame();
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Starting Tennis Game between A and B", logsList.get(0)
                .getMessage());

    }

}
