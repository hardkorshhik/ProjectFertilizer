package ru.p11505.edu35.practice2024.course3.view;

import ru.p11505.edu35.practice2024.course3.model.Fertilizer;
import ru.p11505.edu35.practice2024.course3.model.FertilizerStats;
import ru.p11505.edu35.practice2024.course3.model.Field;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleView {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество полей: ");
        int fieldCount = scanner.nextInt();

        List<Field> fields = new ArrayList<>();

        for (int i = 0; i < fieldCount; i++) {
            System.out.print("Введите площадь для поля №"+(i+1) + ": ");
            double fieldArea = scanner.nextDouble();
            fields.add(
                    new Field(fieldArea)
            );
        }

        System.out.print("Введите количество записей о внесении удобрений: ");
        int applicationCount = scanner.nextInt();
        scanner.nextLine();

        Map<String, Fertilizer> fertilizers = new HashMap<>();

        // Переделать на сокращённую форму цикл фор
        for (int i = 0; i < applicationCount; i++) {
            System.out.print("Введите название удобрения, количество (в кг) и дату внесения (в формате ГГГГ-ММ-ДД), разделенные запятыми: ");
            String[] input = scanner.nextLine().split(",");

            String fertilizerName = input[0].trim();
            double quantity = Double.parseDouble(input[1].trim());
            LocalDate applicationDate = LocalDate.parse(input[2].trim(), formatter);
            if (fertilizers.containsKey(fertilizerName)) {
                fertilizers.get(fertilizerName).addQuantity(quantity, applicationDate);
            } else{
                fertilizers.put(fertilizerName, new Fertilizer(fertilizerName, quantity, applicationDate));
            }
        }
        // Ввод удобрений для каждого поля
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            System.out.println("Настройка удобрений для поля №" + (i + 1));

            System.out.print("Введите количество типов удобрений для этого поля: ");
            int fertilizerCount = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < fertilizerCount; j++) {
                System.out.print("Введите название удобрения и расход на 1 м² (разделены запятой): ");
                String[] input = scanner.nextLine().split(",");

                String fertilizerName = input[0].trim();
                double consumptionPerSquareMeter = Double.parseDouble(input[1].trim());

                Fertilizer fertilizer = fertilizers.get(fertilizerName);
                if (fertilizer != null) {
                    field.addFertilizerConsumption(fertilizer, consumptionPerSquareMeter);
                } else {
                    System.out.println("Удобрение \"" + fertilizerName + "\" не найдено в списке.");
                }
            }
        }

        // Расчет и вывод результатов
        System.out.println("\nРезультаты расчета потребностей в удобрениях:");

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            System.out.println("\nПоле №" + (i + 1) + " (площадь: " + field.getArea() + " м²):");

            for (Fertilizer fertilizer : fertilizers.values()) {
                if (field.containsFertilizer(fertilizer)) {
                    FertilizerStats stats = field.getTotal(fertilizer);
                    System.out.println("  - Удобрение \"" + fertilizer.getFertilizerName() + "\": " + stats);
                }
            }
        }
    }
}