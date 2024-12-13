package ru.p11505.edu35.practice2024.course3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fertilizer {
    private final String fertilizerName;
    private double quantity;
    private final List<FertilizerAdditionHistory> additionHistories = new ArrayList<>();

    public Fertilizer(String fertilizerName, double quantity, LocalDate applicationDate) {
        this.fertilizerName = fertilizerName;
        this.quantity = quantity;
        this.additionHistories.add(new FertilizerAdditionHistory(quantity, applicationDate));
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void addQuantity(double quantity, LocalDate applicationDate) {
        additionHistories.add(new FertilizerAdditionHistory(quantity, applicationDate));
        this.quantity += quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public List<FertilizerAdditionHistory> getAdditionHistories() {
        return additionHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fertilizer that = (Fertilizer) o;
        return Objects.equals(fertilizerName, that.fertilizerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fertilizerName);
    }

    @Override
    public String toString() {
        return "Удобрение: " + fertilizerName + ", Количество: " + quantity + " кг";
    }
}
