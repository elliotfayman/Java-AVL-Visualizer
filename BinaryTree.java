import java.util.*;

public class BinaryTree<T extends Comparable<T>> extends Tree<Comparable<T>> implements IMeasurable<T>, IRotatable<T>, ITraversable<T> { 
    Node<T> root = null;
    private final Comparator<T> cmp;

    //Two Different Constructors for BST
    public BinaryTree(T data, Comparator<T> c){
        root = new Node<T>(data, null, null, null);
        cmp = c;
    }

    public BinaryTree( Comparator<T> c){
        root = null;
        cmp = c;
    }

    //Retrieves Item in BST
    public T getItem(T item)
    {
        Node<T> current = this.root;
        while(current != null) {
            //Item has been found
            if(this.cmp.compare(item, current.data)== 0) {
                return current.data;
            } 
            //Item is to the left
            else if(this.cmp.compare(item, current.data) < 0) {
                current = current.left;
            } 
            //Item is to the right
            else if(this.cmp.compare(item, current.data) > 0) {
                current = current.right;
            }
        }
        return null;
    }

    //Another find method except this one retrieves the node itself
    public Node<T> find(T item){
        Node<T> current = this.root;
        while(current != null) {
            //Item Found
            if(this.cmp.compare(item, current.data)== 0) {
                return current;
            } 
            //Item is left
            else if(this.cmp.compare(item, current.data) < 0) {
                current = current.left;
            }
            //Item is right 
            else if(this.cmp.compare(item, current.data) > 0) {
                current = current.right;
            }
        }
        return null;
    }
    
    //Inserts Node recursivly
    public Node<T> insert(T item, Node<T> p){
        //Base case BST root is null
        if(root==null){
            root = new Node<T>(item, null, null, null);
        }
        //Another Base case: current node is null
        if(p==null){
            System.out.println("Testing new parrent addition: " + getParentOf(item, root, new Node<T>(null, null, null, null)));
            return new Node<T>(item, null, null, p);
        }
        //Go right if node should be to the right
        if(this.cmp.compare(item, p.data) > 0){
            if(p.right!=null){
                p.right.parant = p;
            }
            p.right= insert(item, p.right);
        }
        //Go left if node should be left
        else if(this.cmp.compare(item, p.data) < 0){
            if(p.left!=null){
                p.left.parant = p;
            }
            p.left = insert(item, p.left);
        }

        return p;
    }
    

    //Recursive Preorder
    public ArrayList<Node<T>> nlr(Node<T> node, ArrayList<Node<T>> nodes){
        //Add current
        nodes.add(node);
        //Go left
        if(node.left!=null){
            nlr(node.left, nodes);
            
        }
        //Go right
        if(node.right!=null){
            nlr(node.right, nodes);
        }
        //Return List
        return nodes;
    }

    //Recursive InOrder
    public ArrayList<Node<T>> lnr(Node<T> node, ArrayList<Node<T>> nodes){
        //Base Case
        if(node==null){
            return nodes;
        }
        //Go left
        lnr(node.left, nodes);
        //Add current node
        nodes.add(node);
        //Go right
        lnr(node.right, nodes);
        //Return List
        return nodes;
    } 
    
    //PostOrder recursive
    public ArrayList<Node<T>> lrn(Node<T> node, ArrayList<Node<T>> nodes){
        //Base case
        if(node==null){
            return nodes;
        }
        //Go left
        lrn(node.left, nodes);
        //Go right
        lrn(node.right, nodes);
        //add current
        nodes.add(node);
        //return list
        return nodes;
    } 

    //Iterative BFS
    public ArrayList<Node<T>> bfs(Node<T> node, ArrayList<Node<T>> nodes){
        //Corner Case check
        if(node==null){
            return null;
        }
        //Create BFS Queue
        Deque<Node<T>> queue = new LinkedList<Node<T>>();
        //Adds first node to queue
        queue.offer(node);
        //Main BFS loop
        while(!queue.isEmpty()){
            Node<T> temp = queue.poll();
            nodes.add(temp);
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        //Returns BFS list
        return nodes;
    }

    //Recursive Size method, returns total number of nodes
    public int size(int s, Node<T> nd){
        //Corner Case
        if(root==null){
            return 0;
        }
        //Add to counter if the current node is not null
        if(nd!=null){
            s++;
        }
        //Go left if left node exists
        if(nd.left!=null){
            s = size(s, nd.left);
        }
        //Go right if right node exists
        if(nd.right!=null){
            s = size(s, nd.right);
        }
        return s;
    }

    //Recursive height method
    public int height(Node<T> nd, boolean zero){
        //Corner Case check
        if(nd==null && zero){
            return 0;
        }
        //Base Case check
        if(nd==null){
            return -1;
        }
        int l = height(nd.left, false);
        int r = height(nd.right, false);
        //Find heaviest height
        if(l<r){
            return r+1;
        }
        return l+1;
    } 
    
    //Balance Factor finder
    public int balancefactor(Node<T> nd){
        //Left node doesnt exist but right does
        if (nd.left == null && nd.right!=null){
            return -(this.height(nd.right,true)+1);
        }
        //Left exists but right does not
        else if (nd.left != null && nd.right==null){
            return height(nd.left,true)+1;
        }
        //Both left and right nodes dont exist
        else if (nd.left == null && nd.right==null){
            return 0;
        }
        //Both left and right exist so largest heights must be found and substracted
        else {
            return height(nd.left, true)-height(nd.right, true);
        }
    }

    //Rotate Left and Right are bellow. Note that RL, LR, LL, and RR are all implimented in the 
    //AVLify method in Gui.java
    public void rotateLeft(Node<T> node){
        Node<T> temp = node.right;
        node.right=temp.left;
        if(temp.left != null){
            temp.left.parant = node;
        }
        temp.parant = node.parant;
        if(node.parant == null){
            root = temp;
        }
        else if(node == node.parant.left){
            node.parant.left = temp;
        }
        else{
            node.parant.right = temp;
        }
        temp.left = node;
        node.parant = temp;
    }

    public void rotateRight(Node<T> node){
        Node<T> temp = node.left;
        node.left=temp.right;
        if(temp.right != null){
            temp.right.parant = node;
        }
        temp.parant = node.parant;
        if(node.parant == null){
            root = temp;
        }
        else if(node == node.parant.right){
            node.parant.right = temp;
        }
        else{
            node.parant.left = temp;
        }
        temp.right = node;
        node.parant = temp;
    }

    //Returns Parent of node for use in other methods
    public Node<T> getParentOf (T needle, Node<T> n, Node<T> p) {
        if(n==null){
            return n;
        }
        if(n.data==needle){
            return p;
        }
        else{
            p = getParentOf(needle, n.left, n);
            if(p==null){
                p = getParentOf(needle, n.right, n);
            }
        }
        return p;
        }

        //Custome recursive delete
        public Node<T> deleteN(T element, Node<T> node) {
            //Corner Case
            if(node == null){
                return node;
            }
            //Go left
            if(this.cmp.compare(element, node.data) < 0){
                node.left = deleteN(element, node.left);
            }
            //Go right
            else if(this.cmp.compare(element, node.data) > 0){
                node.right = deleteN(element, node.right);
            }
            //Node to delete is current
            else {
                //If there is no left node, go right
                if(node.left == null){
                    return node.right;
                }
                //No right node, go left
                else if(node.right == null){
                    return node.left;
                }
                //Both nodes exist
                else {
                    //Get succesor
                    Node<T> t = node.left;
                    while(t.right!=null){
                        t = t.right;
                    }
                    System.out.println("hello" + node.data);
                    node.data = t.data;
                    node.left = deleteN(node.data, node.left);
                }
            }
            return node;
        }

        //Delete accesor method
        public void delete(T item){
            root = deleteN(item, root);
        }

    //Axilory sleep method to pause program at run time
    private static void sleep(int milis){
        try {
            Thread.sleep(milis);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
    }

    //Main method 1, run to launch GUI
    public static void main(String args[]){
        //Creates new BST and assignes Integer comparitor
        BinaryTree<Integer> BST = new BinaryTree<Integer>( 7, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        BST.insert(1, BST.root);
        BST.insert(4, BST.root);
        BST.insert(3, BST.root);
        BST.insert(6, BST.root);
        BST.insert(3, BST.root);
        //BST.insert(6, BST.root);
        BST.insert(8, BST.root);
        System.out.println(BST.height(BST.root, false));
        System.out.println(BST.size(0, BST.root));
        System.out.println(BST.balancefactor(BST.root));
        System.out.println(BST.find(1)==null);
        ArrayList<Node<Integer>> list1 = BST.nlr(BST.root, new ArrayList<Node<Integer>>());
        System.out.println(list1);
        for(int x = 0; x<list1.size(); x++){
            System.out.print(list1.get(x).data.toString() + " ");
        }
        System.out.println("");

        ArrayList<Node<Integer>> list2 = BST.lnr(BST.root, new ArrayList<Node<Integer>>());
        System.out.println(list2);
        for(int x = 0; x<list2.size(); x++){
            System.out.print(list2.get(x).data.toString() + " ");
        }
       System.out.println("");

       ArrayList<Node<Integer>> list3 = BST.lrn(BST.root, new ArrayList<Node<Integer>>());
        System.out.println(list3);
        for(int x = 0; x<list3.size(); x++){
            System.out.print(list3.get(x).data.toString() + " ");
        }
       System.out.println("");

       ArrayList<Node<Integer>> list4 = BST.bfs(BST.root, new ArrayList<Node<Integer>>());
        System.out.println(list4);
        for(int x = 0; x<list4.size(); x++){
            System.out.print(list4. get(x).data.toString() + " ");
        }
       System.out.println("....");

       //System.out.println(BST.getParentOf(5, BST.root, new Node<Integer>(null, null, null, null)).data);
       System.out.println(BST.getParentOf(1, BST.root, new Node<Integer>(null, null, null, null)).data);
       //System.out.println(BST.getParentOf(4, BST.root, new Node<Integer>(null, null, null, null)).data);
       //System.out.println(BST.getParentOf(6, BST.root, new Node<Integer>(null, null, null, null)).data);

       System.out.println("BF" + BST.balancefactor(BST.root));
       BST.delete(7);
       System.out.println(BST.root.data);

        //Testing
        //Insert tested: Passed
        //Simple Rotate Right/Left tested: Passed
        //Height Tested: Passed
        //Size Tested: Passed
        //BalanceFactor Tested: Passed
        //Find Tested: Passed
        //Preorder(nlr) Tested: Passed
        //Inorder(lnr) Tested: Passed
        //PostOrder(lrn) Tested: Passed
        //Bredth First Search(BFS) Tested: Passed
        //GetParent Tested: Passed
        //Delete Tested: Passed


        sleep(500);
        Gui gui = new Gui();
        gui.create();
        //Gui.setTextofNodeInput(BST.root.data.toString());
    }
}