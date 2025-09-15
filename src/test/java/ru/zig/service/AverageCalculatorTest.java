package ru.zig.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static ru.zig.service.AverageCalculator.AVERAGE_STATUS_ERROR;
import static ru.zig.service.AverageCalculator.AVERAGE_STATUS_SUCCESS;

class AverageCalculatorTest {
    AverageCalculator averageCalculator = new AverageCalculator();

    @Test
    public void calculateAverage_whenArrayIsNull() {
        BigDecimal result = averageCalculator.calculateAverage(null);

        assertEquals(BigDecimal.ZERO, result);
        assertEquals(AVERAGE_STATUS_ERROR, averageCalculator.getAverageStatus());
    }

    @Test
    public void calculateAverage_whenArrayHasPositiveElements() {
        BigDecimal result = averageCalculator.calculateAverage(new int[]{1, 2, 3});

        assertEquals(BigDecimal.valueOf(2).setScale(2), result);
        assertEquals(AVERAGE_STATUS_SUCCESS, averageCalculator.getAverageStatus());
    }

    @Test
    public void calculateAverage_whenArrayHasNegativeElements() {
        BigDecimal result = averageCalculator.calculateAverage(new int[]{1, -2, 7});

        assertEquals(BigDecimal.valueOf(2).setScale(2), result);
        assertEquals(AVERAGE_STATUS_SUCCESS, averageCalculator.getAverageStatus());
    }

    // Нет теста на длину массива = 0
//    @Test
//    public void calculateAverage_whenArrayIsEmpty() {
//        BigDecimal result = averageCalculator.calculateAverage(new int[]{});
//
//        assertEquals(BigDecimal.valueOf(2).setScale(2), result);
//        assertEquals(AVERAGE_STATUS_SUCCESS, averageCalculator.getAverageStatus());
//    }
}