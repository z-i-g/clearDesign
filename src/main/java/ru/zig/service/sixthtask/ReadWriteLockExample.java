package ru.zig.service.sixthtask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class ReadWriteLockExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private String data;

    public void read() {
        readLock.lock();
        try {
            log.debug("Читаем данные..." + data);
            Thread.sleep(3_000);
            log.debug("Считали данные...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        try {
            log.debug("Записываем данные..." + Thread.currentThread().getName());
            Thread.sleep(3_000);
            data = Thread.currentThread().getName();
            log.debug("Записали данные...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }
}
