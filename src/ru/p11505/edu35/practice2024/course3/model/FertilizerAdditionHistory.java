package ru.p11505.edu35.practice2024.course3.model;

import java.time.LocalDate;

public class FertilizerAdditionHistory {
    private final double quantity;
    private final LocalDate applicationDate;

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public FertilizerAdditionHistory(double quantity, LocalDate applicationDate) {
        this.quantity = quantity;
        this.applicationDate = applicationDate;
    }
}
