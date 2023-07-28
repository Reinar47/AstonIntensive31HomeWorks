package hw1;

import java.util.Collection;
import java.util.Comparator;

//public interface List<E> extends Collection<E>
public interface MyList<E> {
    void add(E e);

    void add(int index, E e);

    void addAll(Collection<? extends E> c);

    void addAll(int index, Collection<? extends E> c);

    void clear();

    E get(int index);

    boolean isEmpty();

    void remove(int index);

    void remove(Object o);

    void sort(Comparator<? super E> c);

}
