import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class UserInputPanel extends JPanel{

    //Initilizing elements of Jpanel
    static JLabel NodeInputLabel = new JLabel("Add new Node:");
    static JTextField newNodeInput = new JTextField("Enter Integer");
    static JButton NodeInputSubmit = new JButton("Submit");

    static JLabel FindNodeLabel = new JLabel("Check if Node is in Tree:");
    static JTextField FindNodeInput = new JTextField("Enter Integer");
    static JButton FindNodeSubmit = new JButton("Submit");
    static JLabel FindNodeOutput = new JLabel("None");

    static JButton PreOrderButton = new JButton("Pre Order");
    static JLabel PreOrderLabel = new JLabel("None");
    static JButton InOrderButton = new JButton("In Order");
    static JLabel InOrderLabel = new JLabel("None");
    static JButton PostOrderButton = new JButton("Post Order");
    static JLabel PostOrderLabel = new JLabel("None");
    static JButton BredthOrderButton = new JButton("Bredth First Search");
    static JLabel BredthOrderLabel = new JLabel("None");

    static JButton SizeButton = new JButton("Size of Tree");
    static JLabel SizeLabel = new JLabel("None");
    static JButton heightButton = new JButton("Height of Tree");
    static JLabel heightLabel = new JLabel("None");

    static JCheckBox AVL = new JCheckBox("AVL"); 

    static JLabel DeleteInputLabel = new JLabel("Delete Node:");
    static JTextField DeleteInputText = new JTextField("Enter Integer");
    static JButton DeleteNodeSubmit = new JButton("Submit");

    public void create(){

        //Adding elements to JFRAME
        super.add(Box.createRigidArea(new Dimension(50, 0)));
        newNodeInput.setMargin(new Insets(0, 30, 0, 0));
        FindNodeInput.setMargin(new Insets(0, 30, 0, 0));
        DeleteInputText.setMargin(new Insets(0, 30, 0, 0));
        super.add(NodeInputLabel);
        super.add(newNodeInput);
        super.add(NodeInputSubmit);
        super.add(FindNodeLabel);
        super.add(FindNodeInput);
        super.add(FindNodeSubmit);
        super.add(FindNodeOutput);
        super.add(PreOrderButton);
        super.add(PreOrderLabel);
        super.add(InOrderButton);
        super.add(InOrderLabel);
        super.add(PostOrderButton);
        super.add(PostOrderLabel);
        super.add(BredthOrderButton);
        super.add(BredthOrderLabel);
        super.add(SizeButton);
        super.add(SizeLabel);
        super.add(heightButton);
        super.add(heightLabel);
        super.add(AVL);
        super.add(DeleteInputLabel);
        super.add(DeleteInputText);
        super.add(DeleteNodeSubmit);
    }



    public JTextField getNewNodeInput(){
        return newNodeInput;
    }

    public JButton getNodeInputSubmit(){
        return NodeInputSubmit;
    }

    public JTextField getFindNodeInput(){
        return FindNodeInput;
    }

    public JButton getFindNodeSubmit(){
        return FindNodeSubmit;
    }

    public JLabel getFindNodeOutput(){
        return FindNodeOutput;
    }

    public JButton getPreOrderButton(){
        return PreOrderButton;
    }

    public JLabel getPreOrderLabel(){
        return PreOrderLabel;
    }

    public JButton getInOrderButton(){
        return InOrderButton;
    }

    public JLabel getInOrderLabel(){
        return InOrderLabel;
    }

    public JButton getPostOrderButton(){
        return PostOrderButton;
    }

    public JLabel getPostOrderLabel(){
        return PostOrderLabel;
    }

    public JButton getBredthOrderButton(){
        return BredthOrderButton;
    }

    public JLabel getBredthOrderLabel(){
        return BredthOrderLabel;
    }

    public JButton getSizeButton(){
        return SizeButton;
    }

    public JLabel getSizeLabel(){
        return SizeLabel;
    }

    public JButton getheightButton(){
        return heightButton;
    }

    public JLabel getheightLabel(){
        return heightLabel;
    }

    public JCheckBox getAVL(){
        return AVL;
    }

    public JTextField getDeleteInputText(){
        return DeleteInputText;
    }

    public JButton getDeleteNodeSubmit(){
        return DeleteNodeSubmit;
    }
}
