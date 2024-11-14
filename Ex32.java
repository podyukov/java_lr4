import java.util.ArrayList;
import java.util.List;

public class Ex32 {

    // Объявляем интерфейс для функции фильтрации
    public interface MyPredicate<T> {
        boolean test(T value);
    }

    /**
     * Метод фильтрации списка, который оставляет только те элементы,
     * которые удовлетворяют условию из переданной функции.
     *
     * list      исходный список значений типа T
     * predicate функция проверки условия для каждого элемента
     * <T>       тип значений в списке
     * return    новый список с отфильтрованными элементами
     */
    public static <T> List<T> filter(List<T> list, MyPredicate<T> predicate) {
        List<T> result = new ArrayList<>(); // создаем новый список для результата
        for (T element : list) { // проходим по каждому элементу
            if (predicate.test(element)) { // проверяем элемент с помощью predicate
                result.add(element); // если прошел фильтрацию, добавляем в результат
            }
        }
        return result; // возвращаем отфильтрованный список
    }

    public void start() {
        // Пример 1: Фильтруем строки, оставляем только те, которые имеют длину 3 или больше
        List<String> strings = List.of("qwerty", "asdfg", "zx", "qw");
        List<String> filteredStrings = filter(strings, str -> str.length() >= 3); // строка должна быть длиной >= 3
        System.out.println("Отфильтрованные строки: " + filteredStrings); // Ожидаемый вывод: [qwerty, asdfg]

        // Пример 2: Фильтруем числа, оставляем только отрицательные числа
        List<Integer> numbers = List.of(1, -3, 7, -5);
        List<Integer> filteredNumbers = filter(numbers, num -> num < 0); // оставляем только отрицательные числа
        System.out.println("Отфильтрованные числа " + filteredNumbers); // Ожидаемый вывод: [-3, -5]

        // Пример 3: Фильтруем массивы целых чисел, оставляем только те, в которых нет положительных чисел
        List<int[]> arrays = List.of(new int[]{1, 3, 5}, new int[]{-1, -3, -5}, new int[]{2, 8, 1});
        List<int[]> filteredArrays = filter(arrays, arr -> {
            for (int num : arr) {
                if (num > 0) { // если найдено положительное число, не добавляем этот массив
                    return false;
                }
            }
            return true; // если массив не содержит положительных чисел, добавляем его
        });
        System.out.println("Отфильтрованные массивы: ");
        for (int[] array : filteredArrays) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        // Ожидаемый вывод:
        // -1 -3 -5
    }
}
