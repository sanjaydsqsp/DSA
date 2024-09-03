package com.example.recording;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class WebSocketClientService {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketClientService.class);

    private WebSocketSession session;

    public CompletableFuture connect(String uri) {
        StandardWebSocketClient client = new StandardWebSocketClient();
        return client.doHandshake(new TextWebSocketHandler() {

            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                WebSocketClientService.this.session = session;
                logger.info("Connected to WebSocket server: " + session.getUri());
            }

            @Override
            protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                logger.info("Received message: " + message.getPayload());
            }

            @Override
            public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
                logger.error("WebSocket transport error: ", exception);
            }

            @Override
            public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
                logger.info("WebSocket connection closed: " + status);
            }

        }, String.valueOf(URI.create(uri))).completable();
    }

    public void disconnect() {
        if (session != null && session.isOpen()) {
            try {
                session.close();
            } catch (Exception e) {
                logger.error("Error closing WebSocket session", e);
            }
        }
    }
}

