package ru.p11505.edu35.practice2024.course3.model;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private final double area;
    private final Map<Fertilizer, Double> consumptionPerSquareMeter = new HashMap<>();

    public Field(double area) {
        this.area = area;
    }

    public void addFertilizerConsumption(Fertilizer fertilizer, double consumption) {
        consumptionPerSquareMeter.put(fertilizer, consumption);
    }

    public double getArea() {
        return area;
    }

    public boolean containsFertilizer(Fertilizer fertilizer) {
        return consumptionPerSquareMeter.containsKey(fertilizer);
    }

    public Map<Fertilizer, Double> getConsumptionPerSquareMeter() {
        return consumptionPerSquareMeter;
    }

    public FertilizerStats getTotal(Fertilizer fertilizer) {
        // Проверяем, зарегистрировано ли удобрение для поля
        if (!consumptionPerSquareMeter.containsKey(fertilizer)) {
            throw new IllegalArgumentException("Удобрение не зарегистрировано для данного поля.");
        }

        // Общая потребность в удобрении
        double totalNeed = area * consumptionPerSquareMeter.get(fertilizer);

        // Актуальное количество удобрения, добавленного через FertilizerPlanner
        double currentAmount = Double.min(fertilizer.getQuantity(), totalNeed);

        return new FertilizerStats(totalNeed, currentAmount);
    }

}
