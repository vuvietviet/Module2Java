public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedLists = new MyLinkedList<>(1);
        myLinkedLists.addFirst(0);
        myLinkedLists.addLast(5);
        myLinkedLists.add(2,2);
        myLinkedLists.add(3,3);
        myLinkedLists.add(4,4);
        myLinkedLists.add(5,6);
        myLinkedLists.remove(3);
        System.out.println(myLinkedLists.size());
        System.out.println(myLinkedLists.contains(6));
        System.out.println(myLinkedLists.indexOf(4));
        System.out.println(myLinkedLists.getFirst());
        System.out.println(myLinkedLists.getLast());
        System.out.println(myLinkedLists.get(5));
        myLinkedLists.add(3,3);
        //Null Pointer Exception
        (myLinkedLists.clone()).printList();
        myLinkedLists.printList();
        myLinkedLists.clear();
        myLinkedLists.printList();
    }

}
