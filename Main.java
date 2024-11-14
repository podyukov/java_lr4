import java.util.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.print("\n> Введите номер задания (1.1 это 11) (0 для выхода): ");
            int num = intInputer();
            if (num == 0) break;
            switch (num) {
                case 11: { // обобщённая коробка
                    Box<Integer> integerBox = new Box<>();
                    while (true) {
                        System.out.println();
                        System.out.println("Введите что вы хотите сделать:");
                        System.out.println("1. Поместить объект в коробку");
                        System.out.println("2. Извлечь объект из коробки");
                        System.out.println("3. Проверить заполненность");
                        System.out.println("Другое число: Выйти из программы");

                        int want = intInputer();
                        if (want < 1 || want > 3) { System.out.println("bye!"); break; }
                        System.out.println();
                        switch (want) {
                            case 1: { one(integerBox); break; }
                            case 2: { two(integerBox); break; }
                            case 3: { three(integerBox); break; }
                        }
                    }
                    break;
                }
                case 12: {
                    // задание 1
                    System.out.println("Задание 1: Хранилище чисел со значением null, альтернатива - число 0.");
                    System.out.println("Альтернативное число: null");
                    Storage<Integer> Storage1 = new Storage<>(null);
                    System.out.println("Вывод на экран: " + Storage1.getLink(0));
                    // задание 2
                    System.out.println("Задание 2: Хранилище чисел со значением 99, альтернатива - число -1.");
                    System.out.println("Альтернативное число: null");
                    Storage<Integer> Storage2 = new Storage<>(99);
                    System.out.println("Вывод на экран: " + Storage2.getLink(-1));
                    // задание 3
                    System.out.println("Задание 3: Хранилище чисел со значением null, альтернатива - строка default.");
                    System.out.println("Альтернативное число: null");
                    Storage<String> Storage3 = new Storage<>(null);
                    System.out.println("Вывод на экран: " + Storage3.getLink("default"));
                    // задание 4
                    System.out.println("Задание 4: Хранилище чисел со значением null, альтернатива - строка hello world.");
                    System.out.println("Альтернативное число: null");
                    Storage<String> Storage4 = new Storage<>("hello");
                    System.out.println("Вывод на экран: " + Storage4.getLink("hello world"));
                    break;
                }
                case 23: {
                    Point point = new Point();
                    Box<Point> box = new Box<>();
                    System.out.println("Коробка пуста: " + box.isEmpty());
                    pointToBox(point, box);
                    System.out.println("Коробка пуста: " + box.isEmpty());
                    System.out.println("Содержимое коробки: " + box.get());
                    System.out.println("Коробка пуста: " + box.isEmpty());
                    break;
                }
                default: { System.out.println("Неверный номер задачи!"); }
            }
        }
    }

    private static void pointToBox(Point point, Box box) {
        System.out.println("Точка упакована в коробку");
        box.put(point);
    }

    private static int intInputer() {
        int i;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\n>>> ");
                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное целое число.");
                scanner.next();
                continue;
            }
            return i;
        }
    }

    private static void one(Box box) { // поместить объект в коробку
        Integer value = null;
        while (value == null) {
            System.out.print("Введите целое число для помещения в коробку: ");
            value = intInputer();
        }
        try {
            box.put(value);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static <T> void two(Box<T> box) { // извлечь объект из коробки
        System.out.println("Извлеченное значение: " + box.get());
    }

    private static <T> void three(Box<T> box) { // проверить заполненность
        System.out.println("Коробка пуста: " + box.isEmpty());
    }
}