public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<String> tree = new BST<>();
        tree.insert("B");
        tree.insert("C");
        tree.insert("A");
        tree.insert("E");
        tree.insert("D");
        tree.insert("F");
        tree.insert("G");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
