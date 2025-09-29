package ru.zig.service.sixthtask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicTypeExample {
    private final int threadCount = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    private int unsafeCounter = 0;
    private final AtomicInteger safeCounter = new AtomicInteger(0);

    public void execute() {
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    unsafeCounter++;
                }
            });
        }

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    safeCounter.incrementAndGet();  // атомарная операция
                }
            });
        }

        executor.shutdown();

        log.debug("Обычный int счетчик: {}", unsafeCounter);
        log.debug("AtomicInteger счетчик: {}", safeCounter.get());
    }
}