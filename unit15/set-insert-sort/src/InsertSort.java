public class InsertSort {
    static int[] list = {3,2,5,7,7,6,1};

    public static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
           int x = list[i];
           int pos = i;
           while (pos > 0 && x < list[pos - 1]) {
               list[pos] = list[pos - 1];
               pos--;
           }
           list[pos] = x;
        }
    }

    public static void main(String[] args) {
        System.out.print("List not sort: ");
        for (int ele: list) {
            System.out.print(ele + " ");
        }
        System.out.println();
        insertSort(list);

        System.out.print("List sorted: ");
        for (int ele: list) {
            System.out.print(ele + " ");
        }
    }
}
