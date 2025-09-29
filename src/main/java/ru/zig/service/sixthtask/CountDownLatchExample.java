package ru.zig.service.sixthtask;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class CountDownLatchExample {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    public void execute(List<String> words) throws InterruptedException {
        int size = words.size();
        CountDownLatch latch = new CountDownLatch(size);

        final int[] lengths = new int[size];

        int index = 0;
        for (String word : words) {
            final int currentIndex = index;
            executor.submit(() -> {
                lengths[currentIndex] = word.length();
                log.debug("Длина слова \"" + word + "\": " + lengths[currentIndex]);
                latch.countDown();
            });
            index++;
        }

        latch.await();
        executor.shutdown();

        int totalLength = 0;
        for (int length : lengths) {
            totalLength += length;
        }
        log.debug("Общая длина слов: {}", totalLength);
    }
}
