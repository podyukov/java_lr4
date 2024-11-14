public class Storage<T> {
    private T item;
    
    public Storage(T item) { // объект кладется в хранилище при его создании
        this.item = item;
    }

    public T getLink(T alternative) {
        if (item != null) return this.item; // хранилище может вернуть ссылку на объект
        else return alternative; // либо альтернативу, если хранится null
    }

    @Override
    public String toString() {
        if (item != null) return "Storage содержит: " + item;
        else return "Storage пуст (null)";
    }
}
