package ru.zig.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class GradeCalculator {
    private int calculateAverageStatus;
    private final Set<Integer> validGrades = Set.of(1, 2, 3, 4, 5);

    public static final int NILL_STATUS = 0;
    public static final int SUCCESS_STATUS = 1;
    public static final int ERROR_STATUS = -1;

    public GradeCalculator() {
        this.calculateAverageStatus = NILL_STATUS;
    }

    public Double calculateAverage(List<Integer> grades) {
        double result = 0.0;
        if (Objects.isNull(grades) || grades.isEmpty()) {
            calculateAverageStatus = ERROR_STATUS;
            return result;
        }

        boolean isValidGrades = grades.stream().noneMatch(gradeIsNull.or(isInvalidGrade));
        if (!isValidGrades) {
            calculateAverageStatus = ERROR_STATUS;
            return result;
        }

        if (isValidGrades) {
            result = grades.stream().mapToInt(Integer::intValue).average().getAsDouble();
            calculateAverageStatus = SUCCESS_STATUS;
        }
        return result;

    }

    public int getCalculateAverageStatus() {
        return calculateAverageStatus;
    }

    private final Predicate<Integer> gradeIsNull = Objects::isNull;
    private final Predicate<Integer> isInvalidGrade = grade -> !validGrades.contains(grade);
}