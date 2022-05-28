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
    // Trả vê nút nhỏ nhất trong toàn bộ cây con
    // bắt nguồn từ nút gốc hiện tại
    static Node minNode(Node root)
    {
        Node temp1 = root;
        while(temp1 != null && temp1.left != null)
            temp1 = temp1.left;
        return temp1;
    }

    // Xóa nút chứa data trong cây hiện tại (từ nút gốc hiện tại)
    static Node deleteNode(Node root, int data)
    {
        // Nếu nút hiện tại trống trả về Null
        if(root == null) return root;
        // Nút bị xóa nằm trong cây con bên trái
        if (data < root.data)
            root.left = deleteNode(root.left, data);
            // Nút bị xóa nằm trong cây con bên phải
        else if (data > root.data)
            root.right = deleteNode(root.right, data);
            // Nút hiện tại là nút bị xóa
        else
        {
            // Case 1: Nút hiện tại không có nút con bên trái:
            // nút con bên phải trở thành nút tổ tiên của cây mới
            if (root.left == null)
            {
                return root.right;
            }
            // Case 2: Nút hiện tại không có nút con bên phải:
            // nút con bên trái trở thành nút tổ tiên của cây mới
            else if (root.right == null)
            {
                return root.left;
            }
            // Case 3
            // Trước tiên hãy tìm nút kế nhiệm nút hiện tại:
            // là nút nhỏ nhất trong cây con bên phải của nút hiện tại
            Node successor = minNode(root.right);
            // Gán data của nút hiện tại bằng data của nút kế nhiệm
            root.data = successor.data;
            // Bây giờ chỉ cần xóa nút kế nhiệm (nút chứa data)
            // khỏi cây con bên phải của root
            root.right = deleteNode(root.right, successor.data);
        }
        return root;

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
        root = deleteNode(root, 5);
        System.out.println("inorder traversal after deleting node with value 5");
        inorder(root);
        System.out.println();
    }
}
