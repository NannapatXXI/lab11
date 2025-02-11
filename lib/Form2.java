package lib;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Form2 extends JFrame implements ActionListener{

    Container cp ;
    JButton left,right,up,down,box ;
       int y ;
        int x ;
    public Form2(){
       
        Initial();
        setComponent();
        Finally();
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
    }
    public void setComponent(){

        left = new JButton("A");
        right = new JButton("D");
        up = new JButton("W");
        down = new JButton("S");
        box = new JButton();
        box.setBackground(Color.black);
        box.setOpaque(true);
        box.setBorderPainted(false);
        box.setBounds(0, 0, 50, 50);

        left.setBounds(25, 230, 47, 30);
        down.setBounds(70, 230, 47, 30);
        right.setBounds(115, 230, 47, 30);
        up.setBounds(70, 200, 47, 30);


        left.addActionListener(this);
        down.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        cp.add(left);cp.add(right);
        cp.add(up);cp.add(down);
        cp.add(box);
    }
    public void Finally(){
        this.setSize(200, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == left) {
             if (x != 0 ) {
                x += -5;
                box.setBounds(x, y, 50, 50);
            }
        } else if (e.getSource() == right) {
            if (x != 150) {
                x += 5;
                box.setBounds(x, y, 50, 50);
            }        
        }else if (e.getSource() == up) {
            if (y != 0) {
                y += -5;
                box.setBounds(x, y, 50, 50);
            }      
        }else if (e.getSource() == down) {
            if (y != 150) {
                y += 5;
            box.setBounds(x, y, 50, 50);
            }
            
        }
       
    }
   
}
