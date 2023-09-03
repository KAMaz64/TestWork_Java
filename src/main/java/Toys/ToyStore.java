package Toys;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    // Метод для добавления новой игрушки
    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    // Метод для изменения веса (частоты выпадения) игрушки
    public void updateToyWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Игрушка с указанным ID не найдена.");
    }

    // Метод для выбора призовой игрушки
    public Toy choosePrizeToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        Random random = new Random();
        double randomValue = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null; // Вернуть null, если не удалось выбрать игрушку
    }

    // Метод для записи призовой игрушки в файл
    public void writePrizeToFile(Toy prizeToy, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Призовая игрушка: " + prizeToy.getName());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    // Метод для уменьшения количества игрушек после розыгрыша
    public void decreaseToyQuantity(Toy prizeToy) {
        prizeToy.setQuantity(prizeToy.getQuantity() - 1);
    }
}
