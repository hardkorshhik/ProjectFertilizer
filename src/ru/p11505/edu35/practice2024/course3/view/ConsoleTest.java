package ru.p11505.edu35.practice2024.course3.view;

import ru.p11505.edu35.practice2024.course3.model.Fertilizer;
import ru.p11505.edu35.practice2024.course3.model.Field;

import java.time.LocalDate;

public class ConsoleTest {

    public static void main(String[] args) {
        // Инициализация данных напрямую
        double fieldArea = 1000.0;
        double consumptionPerSquareMeter = 0.2;

        Field field = new Field(fieldArea);

        // Добавление записей о внесении удобрений
        Fertilizer fertilizerA = new Fertilizer("Удобрение A", 200.0, LocalDate.of(2024, 3, 13));
        field.addFertilizerConsumption(fertilizerA, consumptionPerSquareMeter);

        Fertilizer fertilizerB = new Fertilizer("Удобрение B", 150.0, LocalDate.of(2024, 4, 15));
        field.addFertilizerConsumption(fertilizerB, consumptionPerSquareMeter);

        Fertilizer fertilizerC = new Fertilizer("Удобрение C", 100.0, LocalDate.of(2024, 5, 17));
        field.addFertilizerConsumption(fertilizerC, consumptionPerSquareMeter);

        // Выполнение расчетов
        System.out.println(field.getTotal(fertilizerA));
        System.out.println(field.getTotal(fertilizerB));
        System.out.println(field.getTotal(fertilizerC));
    }
}
