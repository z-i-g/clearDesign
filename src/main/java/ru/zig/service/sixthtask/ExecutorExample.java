package ru.zig.service.sixthtask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExecutorExample {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    public void execute() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int sum = 1 + 2;
            log.debug("Результат первого потока: {}", sum);
            return sum;
        }, executor);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int sum = 3 + 4;
            log.debug("Результат второго потока: {}", sum);
            return sum;
        }, executor);
        CompletableFuture<Integer> totalSum = future1.thenCombine(future2, Integer::sum);

        totalSum.thenAccept(sum -> log.debug("Общая сумма: {}", sum));

        totalSum.join();
        executor.shutdown();
    }
}