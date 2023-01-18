//import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Dimension;

//Main GUI creation class
public class Gui {

    static JFrame frame = new JFrame("Binary Tree Tester");

    static UserInputPanel UI = new UserInputPanel();
    static TreePanel<Integer> tree = new TreePanel<Integer>();
    static BinaryTree<Integer> BST = new BinaryTree<Integer>( new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    static BinaryTree<Integer> AVL = new BinaryTree<Integer>( new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    static boolean treeType = false;
    


    public void create(){
        JFrame frame = new JFrame("Binary Tree Tester");
        //Initilizing frame params
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000 ,1000);
        UI.setLayout(new BoxLayout(UI, BoxLayout.Y_AXIS));
        UI.setMaximumSize(new Dimension(60, 500));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        UI.create();
        mainPanel.add(UI);
        mainPanel.add(tree);
        frame.add(mainPanel);

        //Listener methods 
        UI.getNodeInputSubmit().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                Integer i = Integer.valueOf(UI.getNewNodeInput().getText());
                if(!treeType){
                    BST.insert(i, BST.root);
                    tree.setNode(BST.root);
                    tree.setSize(BST.size(0, BST.root));
                }
                else{
                    AVL.insert(i, AVL.root);
                    AVLify(i, i);
                    System.out.println(AVL.getParentOf(i, AVL.root, new Node<Integer>(null, null, null, null)));
                    tree.setNode(AVL.root);
                    tree.setSize(AVL.size(0, AVL.root));
                }
            }
        });

        UI.getFindNodeSubmit().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                Integer i = Integer.valueOf(UI.getFindNodeInput().getText());
                if(!treeType){
                    UI.getFindNodeOutput().setText(String.valueOf(BST.find(i)!=null));
                }
                else{
                    UI.getFindNodeOutput().setText(String.valueOf(AVL.find(i)!=null));
                }
                
            }
  
        });

        UI.getPreOrderButton().addActionListener(new ActionListener()
        {
            ArrayList<Node<Integer>> array;
            public void actionPerformed(ActionEvent e){
                if(!treeType){
                    array = BST.nlr(BST.root, new ArrayList<Node<Integer>>());
                }
                else{
                    array = AVL.nlr(AVL.root, new ArrayList<Node<Integer>>());
                }
                UI.getPreOrderLabel().setText(Gui.printArray(array));
            }
  
        });

        UI.getInOrderButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                ArrayList<Node<Integer>> array;
                if(!treeType){
                    array = BST.lnr(BST.root, new ArrayList<Node<Integer>>());
                }
                else{
                    array = AVL.lnr(AVL.root, new ArrayList<Node<Integer>>());
                }
                UI.getInOrderLabel().setText(Gui.printArray(array));
            }
  
        });

        UI.getPostOrderButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                ArrayList<Node<Integer>> array;
                if(!treeType){
                    array = BST.lrn(BST.root, new ArrayList<Node<Integer>>());
                }
                else{
                    array = AVL.lrn(AVL.root, new ArrayList<Node<Integer>>());
                }
                UI.getPostOrderLabel().setText(Gui.printArray(array));
            }
  
        });

        UI.getBredthOrderButton().addActionListener(new ActionListener()
        {
            ArrayList<Node<Integer>> array;
            public void actionPerformed(ActionEvent e){
                if(!treeType){
                    array = BST.bfs(BST.root, new ArrayList<Node<Integer>>());
                }
                else{
                    array = AVL.bfs(AVL.root, new ArrayList<Node<Integer>>());
                }
                UI.getBredthOrderLabel().setText(Gui.printArray(array));
            }
  
        });

        UI.getSizeButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(!treeType){
                    UI.getSizeLabel().setText(BST.size(0, BST.root) + "");
                }
                else{
                    UI.getSizeLabel().setText(AVL.size(0, AVL.root) + "");
                }
            }
  
        });

        UI.getheightButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(!treeType){
                    UI.getheightLabel().setText(BST.height(BST.root, false) + "");
                }
                else{
                    UI.getheightLabel().setText(AVL.height(AVL.root, false) + "");
                }
            }
  
        });

        UI.getAVL().addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) { 
                if(e.getStateChange()==1){
                    treeType = true;
                    tree.setNode(AVL.root);
                    if(AVL.root!=null){
                        tree.setSize(AVL.size(0, AVL.root));
                    }
                    else{
                        tree.setSize(0);
                    }

                }              
                else{
                    treeType = false;
                    tree.setNode(BST.root);

                    if(BST.root!=null){
                        tree.setSize(BST.size(0, BST.root));
                    }
                    else{
                        tree.setSize(0);
                    }
                }

                UI.getFindNodeOutput().setText("None");
                UI.getFindNodeOutput().setText("None");
                UI.getPreOrderLabel().setText("None");
                UI.getInOrderLabel().setText("None");
                UI.getPostOrderLabel().setText("None");
                UI.getBredthOrderLabel().setText("None");
                UI.getSizeLabel().setText("None");
                UI.getheightLabel().setText("None");
            }    
         });
         
         UI.getDeleteNodeSubmit().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                Integer i = Integer.valueOf(UI.getDeleteInputText().getText());
                if(!treeType){
                    BST.delete(i);
                    tree.setNode(BST.root);
                    tree.setSize(BST.size(0, BST.root));
                }
                else{
                    AVL.delete(i);
                    AVLify(heaviest(AVL.root), heaviest(AVL.root));
                    tree.setNode(AVL.root);
                    tree.setSize(AVL.size(0, AVL.root));
                }
            }
        });

    }


    
    private static String printArray(ArrayList<Node<Integer>> array){
        String s = "";
        for(Node<Integer> n : array){
            s+=n.data + " ";
        }
        return s;
    }

    //Turns BST into AVL tree
    private void AVLify(Integer i, Integer original){
        Node<Integer> n = AVL.getParentOf(i, AVL.root, new Node<Integer>(null, null, null, null));
        if(n==null){
            if(AVL.balancefactor(AVL.root)>1){
                if(AVL.root.left.data<i){
                    AVL.rotateLeft(AVL.root.left);
                }
                AVL.rotateRight(AVL.root);
                return;
            }
            else if(AVL.balancefactor(AVL.root)<-1){
                if(AVL.root.right.data>original){
                    AVL.rotateRight(AVL.root.right);
                    System.out.print("ddddd");
                }
                AVL.rotateLeft(AVL.root);
                return;
            }
        }
        else if(AVL.balancefactor(n)>1){
            if(n.left.data<original){
                AVL.rotateLeft(n.left);
                System.out.print("////");
            }
            AVL.rotateRight(n);
            return;
        }
        else if(AVL.balancefactor(n)<-1){
            if(n.right.data>original){
                System.out.println(n.right.data);
                AVL.rotateRight(n.right);
            }
            AVL.rotateLeft(n);
            return;
        }
        else{
            AVLify(n.data, i);
        }
        
    }

    private Integer heaviest(Node<Integer> node){
        if(node.left == null && node.right == null){
            return node.data;
        }
        else if (node.left != null && node.right == null){
            return heaviest(node.left);
        }
        else if(node.left == null && node.right != null){
            return heaviest(node.right);
        }
        else{
            if(AVL.balancefactor(node)>0){
                return heaviest(node.left);
            }
            else {
                return heaviest(node.right);
            }
        }
    }
    
}
