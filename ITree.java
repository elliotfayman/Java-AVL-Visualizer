public interface ITree<T> { 
    public T getItem(T item); 
    public Node<T> find(T item); 
    public ITree<T> insert(T item, Node<T> p); 
    } 

