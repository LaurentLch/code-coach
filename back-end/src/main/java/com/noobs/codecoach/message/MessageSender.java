package com.noobs.codecoach.message;

import com.noobs.codecoach.domain.Event;

public interface MessageSender {
    void handle(Event event);
}
