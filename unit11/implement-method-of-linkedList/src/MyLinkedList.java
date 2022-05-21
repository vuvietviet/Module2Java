public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    private  static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }


    public void add(int index, E element) {
        if (index <= 0) {
            addFirst(element);
        } else if (index >= numNodes) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
        }
        numNodes++;
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            newNode.next = head;
            head = newNode;
            numNodes++;
        } else {
            Node current = head;
            for (int i = 1; i < numNodes; i++) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            return null;
        } else if (index == 0) {
            removeFirst();
        } else if (index > numNodes - 1) {
            removeLast();
        } else {
            Node previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.getData();
        }
        return null;
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        }
    }

    public E removeLast() {
        if (numNodes == 0) {
            return null;
        } else if (numNodes == 1) {
            Node current = head;
            head = null;
            numNodes = 0;
            return (E) current.getData();
        } else {
            Node current = head;
            for (int i = 1; i < numNodes - 2; i++) {
                current = current.next;
            }
            current.next = null;
            numNodes--;
            return (E) current.getData();
        }
    }

    public boolean remove(Object e) {
        boolean check = false;
        if ((head.getData()).equals(e)) {
            head = head.next;
            numNodes--;
            check = true;
        } else {
            Node temp = head;
            for (int i = 1; i < numNodes; i++) {
                temp = temp.next;
                if ((temp.getData()).equals(e)) {
                    Node temp1 = head;
                    for (int j = 1; j < i - 1; j++) {
                        temp1 = temp1.next;
                    }
                    temp1 = temp.next;
                    numNodes--;
                    check = true;
                }
            }
        }
        return check;
    }

    public int size() {
        return numNodes;
    }

    //Null Pointer Exception
    public MyLinkedList<E> clone() {
        MyLinkedList<E> clone = new MyLinkedList<>(head.data);
        Node temp = head;
        Node tempClone = clone.head;
       while (temp != null) {
           tempClone.data = temp.data;
           clone.numNodes++;
           temp = temp.next;
           tempClone = tempClone.next;
       }
       return clone;
    }

    public boolean contains(E o) {
        boolean check = false;
        if ((head.getData()).equals(o)) {
            check = true;
        } else {
            Node current = head;
            for (int i = 1; i < numNodes; i++) {
                current = current.next;
                if ((current.getData()).equals(o)) {
                    check = true;
                }
            }
        }
        return check;
    }

    public int indexOf(E o) {
        int index = -1;
        if ((head.getData()).equals(o)) {
            index = 0;
        } else {
            Node current = head;
            for (int i = 1; i < numNodes; i++) {
                current = current.next;
                if ((current.getData()).equals(o)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public boolean add(E e) {
        boolean check = true;
        if ((head.getData()).equals(e)) {
            check = false;
        } else {
            Node current = head;
            for (int i = 1; i < numNodes; i++) {
                current = current.next;
                if ((current.getData()).equals(e)) {
                    check = false;
                }
            }
        }
        return check;
    }


    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            return null;
        } else if (i == 0) {
            getFirst();
        } else {
            Node current = head;
            for (int j = 1; j < i; j++) {
                current = current.next;
            }
            return (E) current.getData();
        }
        return null;
    }

    public E getFirst() {
        return (E) head.getData();
    }

    public E getLast() {
        Node temp = head;
        for (int i = 1; i < numNodes; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }
}
