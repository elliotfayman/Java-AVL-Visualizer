import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Graphics2D;

public class TreePanel<T> extends JPanel{
    int size = 0;
    Node<T> node = null;

    public void setSize(int s){
        size = s;
    }

    public void setNode(Node<T> n){
        node = n;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(node!=null){
            recurPaint(node, g, 250, 200, 40*log2(size));
        }
    }
    public void recurPaint(Node n, Graphics g, int curx, int cury, int recurs){
        Graphics2D g2 = (Graphics2D)g;
        if(n!=null){
            if(n.left == null && n.right == null){
                g.drawOval(curx, cury, 20, 20);
                g2.drawString(n.data.toString(), curx+5, cury+15);
            }
            else if(n.left != null && n.right == null){
                recurPaint(n.left,  g, curx- recurs/2, cury+30, recurs/2);
                g.drawOval(curx, cury, 20, 20);
                g2.drawString(n.data.toString(), curx+5, cury+15);
            }
            else if(n.left == null && n.right != null){
                recurPaint(n.right,  g, curx + recurs/2, cury+30, recurs/2);
                g.drawOval(curx, cury, 20, 20);
                g2.drawString(n.data.toString(), curx+5, cury+15);
            }
            else{
                recurPaint(n.left,  g, curx-recurs/2, cury+20, recurs/2);
                recurPaint(n.right,  g, curx+recurs/2, cury+20, recurs/2);
                g.drawOval(curx, cury, 20, 20);
                g2.drawString(n.data.toString(), curx+5, cury+15);
            }
        }
    }

    
    private static int log2(int num){
        return (int) (Math.log10(num)/Math.log10(2));
    }
}
