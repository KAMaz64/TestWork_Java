package Toys;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушек в магазин
        toyStore.addToy(1, "Мяч", 10, 20);
        toyStore.addToy(2, "Кукла", 5, 30);
        toyStore.addToy(3, "Машинка", 8, 15);

        // Изменение веса игрушки (частоты выпадения)
        toyStore.updateToyWeight(1, 10.0);

        // Выбор призовой игрушки
        Toy prizeToy = toyStore.choosePrizeToy();
        if (prizeToy != null) {
            System.out.println("Поздравляем! Вы выиграли: " + prizeToy.getName());
            toyStore.decreaseToyQuantity(prizeToy);
            toyStore.writePrizeToFile(prizeToy, "prize.txt");
        } else {
            System.out.println("Все игрушки закончились.");
        }
    }
}