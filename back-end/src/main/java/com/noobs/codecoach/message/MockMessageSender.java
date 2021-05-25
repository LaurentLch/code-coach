package com.noobs.codecoach.message;

import com.noobs.codecoach.domain.Event;
import org.springframework.stereotype.Component;

@Component
public class MockMessageSender implements MessageSender {

    @Override
    public void handle(Event event) {
        System.out.println("Sending event: " + event);
    }
}
