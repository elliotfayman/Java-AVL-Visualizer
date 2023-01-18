public class Node<T> {
    protected T data;
    protected Node<T> parant; 
    protected Node<T> left;
    protected Node<T> right;
    public Node (T d, Node<T> l, Node<T> r, Node<T> p) {
        data = d;
        left = l;
        right = r;
        parant = p; 
    }

}
