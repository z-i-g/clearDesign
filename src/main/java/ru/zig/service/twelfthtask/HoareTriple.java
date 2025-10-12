package ru.zig.service.twelfthtask;

public class HoareTriple {
    // предусловие: a и b - целые числа
    // постусловие: результат - максимальный модуль a и b
    public static int maxAbs(int a, int b) {
        return max(abs(a), abs(b));
    }

    // предусловие: a и b - целые числа
    // постусловие: результат - максимальный из a и b
    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // предусловие: a - целое число
    // постусловие: результат - модуль a
    private static int abs(int a) {
        return a > 0 ? a : -a;
    }
}
