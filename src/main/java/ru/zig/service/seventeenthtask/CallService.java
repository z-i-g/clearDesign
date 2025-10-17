package ru.zig.service.seventeenthtask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallService {
    public void call(HttpPostProcessing request) {
        log.debug("{}, body - {}, uri - {}", request.actionDescription(), request.body(), request.uri());
    }
}