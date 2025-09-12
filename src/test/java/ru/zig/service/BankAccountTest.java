package ru.zig.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(50);
    }

    @Test
    public void depositTest_whenPositiveValue() {
        assertDoesNotThrow(() -> bankAccount.deposit(20));

        assertEquals(70, bankAccount.getBalance());
    }

    @Test
    public void depositTest_whenNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-20));

        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void withdrawTest_whenPositiveValue() {
        assertDoesNotThrow(() -> bankAccount.withdraw(20));

        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    public void withdrawTest_whenNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-20));

        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void getBalanceTest_whenPositiveValue() {
        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void getBalanceTest_whenNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount = new BankAccount(-20));
    }
}