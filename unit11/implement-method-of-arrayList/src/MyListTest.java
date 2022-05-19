public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(8);
        myList.add(0, 0);
        myList.add(1, 1);
        myList.add(2, 2);
        myList.add(3, 3);
        System.out.println(myList.get(1));
        myList.remove(1);
        System.out.println(myList.get(1));
        System.out.println(myList.size());
        System.out.println(myList.contains(1));
        System.out.println(myList.indexOf(3));
        System.out.println(myList.add(0));
        System.out.println(myList);
        System.out.println(myList.clone());
        myList.clear();
        System.out.println(myList.size());
        myList.clone();
    }
}
