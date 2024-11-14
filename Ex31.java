import java.util.ArrayList;
import java.util.List;

public class Ex31 {

    // интерфейс, который принимает значение типа T и возвращает значение типа P
    public interface MyFunction<T, P> {
        P apply(T value);
    }
    /**
     * Обобщенный метод, который применяет переданную функцию к каждому элементу списка
     * и возвращает новый список с результатами.
     *
     * list     список значений типа T
     * function функция для применения к каждому элементу
     * <T>      тип входных значений
     * <P>      тип выходных значений
     * return   новый список значений после применения функции
     */
    public static <T, P> List<P> applyToEach(List<T> list, MyFunction<T, P> function) {
        List<P> result = new ArrayList<>(); // создаем новый список для результата
        for (T element : list) { // для каждого элемента из списка
            result.add(function.apply(element)); // применяем функцию и добавляем результат в новый список
        }
        return result; // возвращаем список результатов
    }

    public void start() {
        // Пример 1: Преобразуем список строк в список их длин
        List<String> strings = List.of("qwerty", "asdfg", "zx"); // исходный список строк
        List<Integer> lengths = applyToEach(strings, str -> str.length()); // функция длины строки
        System.out.println("Длины: " + lengths); // Ожидаемый вывод: [6, 5, 2]

        // Пример 2: Преобразуем список чисел в их абсолютные значения
        List<Integer> numbers = List.of(1, -3, 7); // исходный список чисел
        List<Integer> absNumbers = applyToEach(numbers, num -> Math.abs(num)); // функция абсолютного значения
        System.out.println("Положительные числа: " + absNumbers); // Ожидаемый вывод: [1, 3, 7]

        // Пример 3: Находим максимумы в массивах
        List<int[]> arrays = List.of(new int[]{1, 3, 5}, new int[]{-1, -3, -5}, new int[]{2, 8, 1}); // исходный список массивов
        List<Integer> maxValues = applyToEach(arrays, arr -> {
            int max = arr[0]; // берем первый элемент как начальный максимум
            for (int num : arr) { // проходим по каждому числу в массиве
                if (num > max) max = num; // если нашли большее значение, обновляем максимум
            }
            return max; // возвращаем максимальное значение
        });
        System.out.println("Максимальные значения: " + maxValues); // Ожидаемый вывод: [5, -1, 8]
    }
}
