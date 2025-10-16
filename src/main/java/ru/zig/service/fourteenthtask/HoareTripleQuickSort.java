package ru.zig.service.fourteenthtask;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class HoareTripleQuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        assert arr != null;
        assert low >= 0 && high < arr.length && low <= high;
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {19, 21, 15, 45, 0, 8, -88, 7, 33, 55};
        log.debug("До вызова quickSort: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        log.debug("После вызова quickSort: " + Arrays.toString(array));
    }
}
