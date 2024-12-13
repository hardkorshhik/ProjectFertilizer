package ru.p11505.edu35.practice2024.course3.view;

import ru.p11505.edu35.practice2024.course3.model.Fertilizer;
import ru.p11505.edu35.practice2024.course3.model.FertilizerAdditionHistory;
import ru.p11505.edu35.practice2024.course3.model.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        //todo Вывести потребность отсоритваронную по дате внесения удобрения

        //todo создать новый класс для работы с историей внесения
        //todo Метод по получения отсортированной коллекции , метод по получению общего количество по каждому удобрению

        // Вывод потребности, отсортированной по дате внесения удобрения
        List<FertilizerAdditionHistory> allHistories = new ArrayList<>();
        allHistories.addAll(fertilizerA.getAdditionHistories());
        allHistories.addAll(fertilizerB.getAdditionHistories());
        allHistories.addAll(fertilizerC.getAdditionHistories());

        allHistories.sort(Comparator.comparing(FertilizerAdditionHistory::getApplicationDate));

        System.out.println("\nПотребности по дате внесения удобрения:");
        for (FertilizerAdditionHistory history : allHistories) {
            System.out.println("Дата: " + history.getApplicationDate() +
                    ", Количество: " + history.getQuantity() + " кг");
        }
    }
}
