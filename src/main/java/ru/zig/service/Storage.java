package ru.zig.service;

public interface Storage {
    void save(String data);
    String retrieve(int id);
}