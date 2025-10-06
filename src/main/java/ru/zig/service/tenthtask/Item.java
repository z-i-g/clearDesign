package ru.zig.service.tenthtask;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class Item {
    private String name;
    private BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}