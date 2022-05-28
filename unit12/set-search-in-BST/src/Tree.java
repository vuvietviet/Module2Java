public class Tree {
    static Node root;
    static Node create(int data) {
        Node temp = new Node(data);
        return temp;
    }
    static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static boolean search(int data) {
        if (root == null) {
            return false;
        } else {
            Node current = root;
            while (current != null) {
                if (data < current.data) {
                    current = current.left;
                } else if (data > current.data) {
                    current = current.right;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args)
    {
        root = create(7);
        root.left = create(5);
        root.right = create(8);
        root.left.left = create(3);
        root.left.left.right = create(4);
        root.left.right = create(6);
        System.out.println("current inorder traversal of tree");
        inorder(root);
        System.out.println();
        System.out.print("Have tree node with value 5? ");
        System.out.println(search(5));
    }
}
