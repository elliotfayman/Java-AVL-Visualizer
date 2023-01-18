import java.util.*; 
 
public interface ITraversable<T> { 
public ArrayList<Node<T>> nlr(Node<T> node, ArrayList<Node<T>> nodes); // Pre-order 
public ArrayList<Node<T>> lnr(Node<T> node, ArrayList<Node<T>> nodes); // In-order 
public ArrayList<Node<T>> lrn(Node<T> node, ArrayList<Node<T>> nodes); // Post-order 
public ArrayList<Node<T>> bfs(Node<T> node, ArrayList<Node<T>> nodes); // Breadth-first 
} 