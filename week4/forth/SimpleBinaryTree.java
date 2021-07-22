package week4.forth;

public class SimpleBinaryTree {
    private Node<Integer> root;


    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();
        Node<Integer> root = tree.new Node<Integer>(5);
        tree.setRoot(root);

        tree.addNode(0);
        tree.addNode(7);
        tree.addNode(-3);
        tree.addNode(4);
        tree.addNode(9);
        tree.addNode(6);
        tree.addNode(-1);
        tree.addNode(2);
        tree.addNode(8);
        tree.addNode(12);



        System.out.println("----------------PRE------------------");
        tree.preorder(root);
        System.out.println();
        System.out.println("----------------IN------------------");
        tree.inorder(root);
        System.out.println();
        System.out.println("----------------POST------------------");
        tree.postorder(root);
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("Высота дерева = " + tree.getHeight(root));
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    class Node<T>{
        private Node<T> leftChild = null;
        private Node<T> rightChild = null;
        private T data;

        public Node(T data){
            this.data = data;
        }

        @Override
        public String toString() {
            return " ( " + data + " ) ";
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeaf(){
            return leftChild == null && rightChild == null;
        }
    }

    public void addNode(int data){
        Node<Integer> start = root;
        Node<Integer> pred = null;
        while (start != null){
            if(data <= start.data){
                pred = start;
                start = start.leftChild;
            }else {
                pred = start;
                start = start.rightChild;
            }
        }
        Node<Integer> node = new Node<>(data);
        if(data <= pred.data){
            pred.setLeftChild(node);
        }else {
            pred.setRightChild(node);
        }
    }

    public int getHeight(Node node){
        if(node == null)
            return 0;
        return Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    public void preorder(Node node){
        if(node == null)
            return;
        System.out.println(node);
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public void inorder(Node node){
        if(node == null)
            return;
        inorder(node.leftChild);
        System.out.println(node);
        inorder(node.rightChild);
    }

    public void postorder(Node node){
        if(node == null)
            return;
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.println(node);
    }
}
