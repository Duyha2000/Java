package Review.Example2;

// interface ko can public - ko can abstract
public interface DataCollector<T> {
    void addItem(T item);

    T getItem(int index);

    int getSize();

}

