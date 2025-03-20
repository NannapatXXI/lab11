import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu  extends JFrame implements ActionListener{
     Container cp ;
    JLabel name , id ;
    JTextField t1 ,t2 ;
    JButton b1,b2 ;
    public Menu(){
        Initial();
        setComponent();
        Finally();
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
       
    }
    public void setComponent(){
        JButton b1 = new JButton("GUI + R/W File ");
        JButton b2 = new JButton("GUI + Event Handing");
        JButton b3 = new JButton("Graphic + Animation");
        JButton b4 = new JButton("back");

        b1.setActionCommand("but1");
        b1.addActionListener(this);
        b2.setActionCommand("but2");
        b2.addActionListener(this);
        b3.setActionCommand("but3");
        b3.addActionListener(this);
        b4.setActionCommand("but4");
        b4.addActionListener(this);


        b1.setBounds(40, 0, 150, 70);
        b2.setBounds(40, 80, 150, 70);
        b3.setBounds(40, 160, 150, 70);
        b4.setBounds(170, 260, 70, 30);


        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(b4);
        
    }
    public void Finally(){
        this.setSize(270, 330);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if (e.getActionCommand() == "but1") {
           
            this.setVisible(false);
            new RandWFile();
        
        }
        if (e.getActionCommand() == "but2") {
            
            this.setVisible(false);
            new EvnetMenu();
        
        }
        if (e.getActionCommand() == "but3") {
           
            this.setVisible(false);
            new GuiAnimation();
        
        }
        if (e.getActionCommand() == "but4") {
           
            this.setVisible(false);
            new Firstpage();
        
        }
           
       }
   
}
