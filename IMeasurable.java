public interface IMeasurable<T> { 
    public int size(int s, Node<T> nd); 

    public int height(Node<T> nd, boolean zero); 

    public int balancefactor(Node<T> nd); 
} 