package ru.p11505.edu35.practice2024.course3.model;

public class FertilizerStats {
    private final double totalNeed; // Общая потребность в удобрениях
    private final double currentAmount; // В наличии удобрений

    public FertilizerStats(double totalNeed, double currentAmount) {
        this.totalNeed = totalNeed;
        this.currentAmount = currentAmount;
    }

    public double getTotalNeed() {
        return totalNeed;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    @Override
    public String toString() {
        return "Потребность в удобрении: " + totalNeed + " кг, в наличии: " + currentAmount + " кг";
    }
}
