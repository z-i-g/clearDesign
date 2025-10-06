package ru.zig.service.tenthtask;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;

public class Basket {
    private final List<Item> items;
    @Getter
    private final BigDecimal cost;

    public Basket(List<Item> items) {
        if (Objects.isNull(items))
            throw new IllegalArgumentException("List<Item> не может быть null");
        this.items = new ArrayList<>(items);
        cost = items.stream().map(Item::getPrice).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Basket addItem(Item item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Item не может быть null");
        List<Item> newItems = new ArrayList<>(Arrays.stream(Arrays.copyOf(items.toArray(), items.size()))
                .map(obj -> (Item) obj)
                .toList());
        newItems.add(item);
        return new Basket(newItems);
    }

    public Basket removeItem(Item item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Item не может быть null");
        List<Item> newItems = new ArrayList<>(Arrays.stream(Arrays.copyOf(items.toArray(), items.size()))
                .map(obj -> (Item) obj)
                .toList());
        newItems.remove(item);
        return new Basket(newItems);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(items, basket.items) && Objects.equals(cost, basket.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, cost);
    }
}