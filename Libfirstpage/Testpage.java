import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Testpage extends JFrame implements MouseListener {
    Container cp;
    JTextArea T ;
    public  Testpage() {
        SetupContent();
        FinallyContent();
        
    }
    public void SetupContent(){
        cp = this.getContentPane();
        cp.setLayout(null);
        cp.add(Content_top());
        cp.add(Content_below());
    }
    public JPanel Content_top(){
        JPanel A = new JPanel();
        A.setLayout(new  GridBagLayout());
        JButton B1 = new JButton("BT1");
        JButton B2 = new JButton("BT2");
        JButton B3 = new JButton("BT3");
        A.add(B2); A.add(B3);
        B1.addMouseListener(this);
        B2.addMouseListener(this);
        B3.addMouseListener(this);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        A.add(new JTextField("Enter Text"));
        c.gridx = 0;
        c.gridy = -1;
        A.add(B1);
        A.setBounds(0, 0, 300, 150);
        A.setBackground(Color.black);
        return A;
    }
    public JPanel Content_below(){
        JPanel B = new JPanel();
        B.setLayout(new FlowLayout());
        JButton B1 = new JButton("Hello");
        B1.setBounds(0, 200, 50, 50);
        B1.addMouseListener(this);
       T = new JTextArea(5,30);
        T.setBounds(150, 150, 100, 50);
        B.add(T);B.add(B1);
        B.setBounds(0, 150, 300, 150);
        
        return B;
    }
    public void FinallyContent(){
        this.setSize(300,300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
           T.setText(T.getText() + "Mouse 1   ");
           System.out.println("1");
        }else if (e.getButton() == MouseEvent.BUTTON3) {
           T.setText(T.getText()+"Mouse 2   ");
           System.out.println("2");
        }
     }
   
    public void mousePressed(MouseEvent e) {
        T.setText(T.getText()+" In Pressed  ");
        System.out.println("In Pressed ");
    }
  
    public void mouseReleased(MouseEvent e) {
        T.setText(T.getText()+" In Released  ");
        System.out.println("In Released  ");
    }
   
    public void mouseEntered(MouseEvent e) {
        T.setText(T.getText()+" In Entered  ");
        System.out.println("In Entered  ");
     }
 
    public void mouseExited(MouseEvent e) {
        T.setText(T.getText()+" In Exited  ");
        System.out.println("In Enited  ");
    }
}

