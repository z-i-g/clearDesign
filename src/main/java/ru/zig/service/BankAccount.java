package ru.zig.service;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        this.balance = balance;
    }

    public void deposit(double value) {
        if (value < 0)
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной");
        this.balance += value;
    }

    public void withdraw(double value) {
        if (value < 0 || balance < value)
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной или больше баланса");
        this.balance -= value;
    }

    public double getBalance() {
        return balance;
    }
}