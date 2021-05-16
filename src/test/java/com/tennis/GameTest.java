package com.tennis;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private InputHandler mockInputHandler;

    @BeforeEach
    public void setup() {
        setupInput();
    }

    @Test
    void shouldStartGame() {
        Logger gameLogger = (Logger) LoggerFactory.getLogger(Game.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        gameLogger.addAppender(listAppender);
        Game game = new Game(mockInputHandler);
        game.start();
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Starting Tennis Game between A and B", logsList.get(0)
                .getMessage());
    }

    private void setupInput() {
        mockInputHandler = mock(InputHandler.class);
        when(mockInputHandler.getPointWinner())
                .thenReturn("A");
    }

}
