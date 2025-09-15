package ru.zig.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class AverageCalculator {
    public static final int AVERAGE_STATUS_NONE = 0;
    public static final int AVERAGE_STATUS_SUCCESS = 1;
    public static final int AVERAGE_STATUS_ERROR = -1;

    private int averageStatus = AVERAGE_STATUS_NONE;

    public BigDecimal calculateAverage(int[] numbers) {
        if (Objects.isNull(numbers)) {
            averageStatus = AVERAGE_STATUS_ERROR;
            return BigDecimal.ZERO;
        }

        BigDecimal elementsSum = BigDecimal.ZERO;
        int arrayLength = numbers.length;

        for (int number : numbers)
            elementsSum = BigDecimal.valueOf(number).add(elementsSum);

        averageStatus = AVERAGE_STATUS_SUCCESS;
        return elementsSum.divide(BigDecimal.valueOf(arrayLength), 2, RoundingMode.DOWN);
    }

    public int getAverageStatus() {
        return averageStatus;
    }
}