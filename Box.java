public class Box<T> {
    private T item;

    public void put(T item) { // помещение объекта в коробку
        if (this.item != null) {
            throw new IllegalStateException("Исключение: Коробка уже заполнена!");
        }
        else this.item = item;
    }

    public T get() { // извлечение объекта из коробки
        T temp = item;
        item = null;
        return temp;
    }

    public boolean isEmpty() { // проверка коробки на заполненность
        return item == null;
    }

    @Override
    public String toString() {
        if (item != null) {
            return "Коробка содержит: " + item;
        } else {
            return "Коробка пуста";
        }
    }
}