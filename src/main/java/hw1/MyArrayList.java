package hw1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


public class MyArrayList<E> implements MyList<E> {

    private Object[] arrayOfObjects;
    private static final Object[] EMPTY_ARRAY_OF_OBJECTS = {};

    public MyArrayList() {
        this.arrayOfObjects = EMPTY_ARRAY_OF_OBJECTS;
    }

    public MyArrayList(int size) {
        if (size == 0) {
            this.arrayOfObjects = EMPTY_ARRAY_OF_OBJECTS;
        } else if (size > 0) {
            this.arrayOfObjects = new Object[size];
        } else {
            throw new IllegalArgumentException("Wrong size: " + size);
        }
    }

    public MyArrayList(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            this.arrayOfObjects = EMPTY_ARRAY_OF_OBJECTS;
        } else {
            this.arrayOfObjects = Arrays.copyOf(collection.toArray(), collection.size());
        }
    }

    @Override
    public void add(E e) {
        if (this.arrayOfObjects.length == 0) {
            this.arrayOfObjects = new Object[]{e};
        } else {
            this.arrayOfObjects = Arrays.copyOf(arrayOfObjects, arrayOfObjects.length + 1);
            this.arrayOfObjects[this.arrayOfObjects.length - 1] = e;
        }
    }

    @Override
    public void add(int index, E e) {
        if (this.arrayOfObjects.length > index) {
            if (index == this.arrayOfObjects.length - 1) {
                add(e);
            } else {
                Object[] firstHalfPlusElement =
                        Arrays.copyOf(this.arrayOfObjects,
                                createFirstHalfOfArray(this.arrayOfObjects, index).length + 1);
                firstHalfPlusElement[firstHalfPlusElement.length - 1] = e;

                this.arrayOfObjects = concatTwoArrays(firstHalfPlusElement,
                        createSecondHalfOfArray(this.arrayOfObjects, index));
            }
        } else {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + " > " + " then list size: " + this.arrayOfObjects.length);
        }
    }

    private Object[] concatTwoArrays(Object[] firstArray, Object[] secondArray) {
        Object[] result = new Object[firstArray.length + secondArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            result[i] = firstArray[i];
        }
        int indexOfResult = firstArray.length;
        for (int i = 0; i < secondArray.length; i++) {
            result[indexOfResult] = secondArray[i];
            indexOfResult++;
        }

        return result;
    }

    private Object[] createFirstHalfOfArray(Object[] objects, int index) {
        return Arrays.copyOf(objects, index);
    }

    private Object[] createSecondHalfOfArray(Object[] objects, int index) {
        return Arrays.copyOfRange
                (objects, index, objects.length);
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        this.arrayOfObjects = concatTwoArrays(this.arrayOfObjects, collection.toArray());
    }

    @Override
    public void addAll(int index, Collection<? extends E> collection) {
        if (this.arrayOfObjects.length > index) {
            if (index == this.arrayOfObjects.length - 1) {
                addAll(collection);
            } else {
                Object[] firstHalfPlusCollection = concatTwoArrays(createFirstHalfOfArray(this.arrayOfObjects, index),
                        collection.toArray());

                this.arrayOfObjects = concatTwoArrays(firstHalfPlusCollection,
                        createSecondHalfOfArray(this.arrayOfObjects, index));
            }
        } else {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + " > " + " then list size: " + this.arrayOfObjects.length);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.arrayOfObjects.length; i++) {
            arrayOfObjects[i] = null;
        }
    }

    @Override
    public E get(int index) {
        if (this.arrayOfObjects.length > index) {
            return (E) this.arrayOfObjects[index];
        } else {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + " > " + " then list size: " + this.arrayOfObjects.length);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.arrayOfObjects.length == 0;
    }

    @Override
    public void remove(int index) {
        if (this.arrayOfObjects.length > index) {
            if (index == 0) {
                this.arrayOfObjects = createSecondHalfOfArray(this.arrayOfObjects, 1);
            } else if (index == this.arrayOfObjects.length - 1) {
                this.arrayOfObjects = createFirstHalfOfArray(this.arrayOfObjects, index);
            } else {
                Object[] firstHalfOfArray = createFirstHalfOfArray(this.arrayOfObjects, index + 1);

                Object[] firstHalfMinusElement =
                        createFirstHalfOfArray(firstHalfOfArray, firstHalfOfArray.length - 1);

                this.arrayOfObjects = concatTwoArrays(firstHalfMinusElement,
                        createSecondHalfOfArray(this.arrayOfObjects, index + 1));
            }
        } else {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + " > " + " then list size: " + this.arrayOfObjects.length);
        }
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < this.arrayOfObjects.length; i++) {
            if (this.arrayOfObjects[i].equals(o)) {
                remove(i);
            }
        }
    }

    @Override
    public void sort(Comparator<? super E> c) {
        quickSort(this.arrayOfObjects, 0, this.arrayOfObjects.length - 1, c);
    }

    private void quickSort(Object[] sortArr, int low, int high, Comparator comparator) {
        if (sortArr.length == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        Object border = sortArr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(sortArr[i], border) < 0) i++;
            while (comparator.compare(sortArr[j], border) > 0) j--;
            if (i <= j) {
                Object swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(sortArr, low, j, comparator);
        if (high > i) quickSort(sortArr, i, high, comparator);
    }

    @Override
    public String toString() {

        return Arrays.toString(this.arrayOfObjects);
    }
}
