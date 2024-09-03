package com.example.recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/ws")
public class WebSocketController {

    @Autowired
    private WebSocketClientService webSocketClientService;

    @PostMapping("/connect")
    public ResponseEntity<String> connect(@RequestParam String uri) {
        try {
            webSocketClientService.connect(uri).get();
            return ResponseEntity.ok("Connected to WebSocket server");
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(500).body("Failed to connect to WebSocket server: " + e.getMessage());
        }
    }

    @PostMapping("/disconnect")
    public ResponseEntity<String> disconnect() {
        webSocketClientService.disconnect();
        return ResponseEntity.ok("Disconnected from WebSocket server");
    }
}
