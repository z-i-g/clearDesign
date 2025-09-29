package ru.zig.service.sixthtask;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierExample {
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public void execute() {
        Thread threadFirst = new Thread(() -> {
            log.debug("threadOne ждет... {}", LocalTime.now());
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.debug("threadOne дождался... {}", LocalTime.now());
        });

        Thread threadSecond = new Thread(() -> {
            log.debug("threadSecond ждет... {}", LocalTime.now());
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.debug("threadSecond дождался... {}", LocalTime.now());
        });

        threadFirst.start();
        threadSecond.start();
    }
}