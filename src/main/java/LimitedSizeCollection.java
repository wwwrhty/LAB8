import java.util.LinkedList;

public class LimitedSizeCollection<T> {
    private int maxSize;
    private LinkedList<T> collection = new LinkedList<>();

    public LimitedSizeCollection(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        if (collection.size() >= maxSize) {
            collection.removeFirst();
        }
        collection.addLast(item);
    }

    public LinkedList<T> getCollection() {
        return collection;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        while (collection.size() > maxSize) {
            collection.removeFirst();
        }
    }

    public static void main(String[] args) {
        LimitedSizeCollection<Integer> collection = new LimitedSizeCollection<>(5);

        for (int i = 1; i <= 10; i++) {
            collection.add(i);
            System.out.println("Added: " + i);
            System.out.println("Collection: " + collection.getCollection());
        }
    }
}
