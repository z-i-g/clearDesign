package ru.zig.service.ninth;

import java.util.Arrays;
import java.util.Random;

public class UpgradedComplexMultiThreadProcessing {
    private static final int SIZE = 1000000;
    private static final int[] data = new int[SIZE];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(100);
        }

        System.out.println(Arrays.stream(data).parallel().sum());
    }

//    private static final int SIZE = 1000000;
//    private static final int[] data = new int[SIZE];
//
//    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < SIZE; i++) {
//            data[i] = random.nextInt(100);
//        }
//
//        ForkJoinPool pool = new ForkJoinPool();
//
//        int sum = pool.submit(() -> Arrays.stream(data).parallel().sum()).join();
//
//        System.out.println("Sum of all elements: " + sum);
//    }
}