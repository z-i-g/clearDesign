package ru.zig.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();

    @Test
    void calculateAverage_whenNotCallMethod() {
        assertEquals(GradeCalculator.NILL_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsNull_thenErrorStatus() {
        double result = gradeCalculator.calculateAverage(null);

        assertEquals(0.0, result);
        assertEquals(GradeCalculator.ERROR_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsEpty_thenErrorStatus() {
        double result = gradeCalculator.calculateAverage(Collections.emptyList());

        assertEquals(0.0, result);
        assertEquals(GradeCalculator.ERROR_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsExistsNullValue_thenErrorStatus() {
        List<Integer> testGrades = new ArrayList<>();
        testGrades.add(2);
        testGrades.add(null);

        double result = gradeCalculator.calculateAverage(testGrades);

        assertEquals(0.0, result);
        assertEquals(GradeCalculator.ERROR_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsExistsNegativeValue_thenErrorStatus() {
        List<Integer> testGrades = new ArrayList<>();
        testGrades.add(2);
        testGrades.add(-1);

        double result = gradeCalculator.calculateAverage(testGrades);

        assertEquals(0.0, result);
        assertEquals(GradeCalculator.ERROR_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsExistsZeroValue_thenErrorStatus() {
        List<Integer> testGrades = new ArrayList<>();
        testGrades.add(2);
        testGrades.add(0);

        double result = gradeCalculator.calculateAverage(testGrades);

        assertEquals(0.0, result);
        assertEquals(GradeCalculator.ERROR_STATUS, gradeCalculator.getCalculateAverageStatus());
    }

    @Test
    void calculateAverage_whenGradesIsValid_thenSuccessStatus() {
        List<Integer> testGrades = List.of(2, 3, 2, 4, 5);

        double result = gradeCalculator.calculateAverage(testGrades);

        assertEquals(3.2, result);
        assertEquals(GradeCalculator.SUCCESS_STATUS, gradeCalculator.getCalculateAverageStatus());
    }
}