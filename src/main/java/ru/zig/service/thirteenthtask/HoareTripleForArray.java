package ru.zig.service.thirteenthtask;

import java.util.Objects;

public class HoareTripleForArray {
    public int findMax(int[] array) {
        if (Objects.isNull(array) || array.length == 0)
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        int maxElement = array[0];
        for (int elem: array)
            maxElement = Math.max(maxElement, elem);
        return maxElement;
    }
}