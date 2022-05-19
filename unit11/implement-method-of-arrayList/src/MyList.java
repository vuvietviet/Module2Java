public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index ; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
        E e = (E)elements[index];
        for (int i = index; i < size -1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public E clone() {
        E[] newElements = (E[]) (new Object[elements.length]);
        for (int i = 0; i < size; i++) {
            newElements[i] = (E) elements[i];
        }
        return (E) newElements;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity();
        for (int i = 0; i < size; i++) {
            if (elements[i] == e) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity() {
        if (size >= elements.length) {
            E[] newElements = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements,0,newElements,0,size);
            elements = newElements;
        }
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("index " + i + " out of bounds");
        }
        return (E) elements[i];
    }

    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
