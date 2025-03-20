import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class EvnetMenu  extends JFrame implements MouseListener{
    Container cp ;
    JLabel l;
    JTextField t;
    JButton b;
    JButton b1;
    JButton b2;
    int i = 0;
    int count = 0,  min = 0,max = 0,stat = 0;boolean bool = true;
    public EvnetMenu(){
        gui();
        setComponent();
        finalygui();
    }
    
    public void gui(){
      cp = getContentPane();
      cp.setLayout(new GridBagLayout());
    }
    public void setComponent(){
        t  = new JTextField(2);
         b = new JButton("Click");
         b1 = new JButton("Change background");
         b2 = new JButton("Back");
        l = new JLabel("Max = " + max + "  Min = " + min);
        l.setBackground(Color.white);
        l.setOpaque(true);
       
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.ipady = 20;
        cp.add(l,c);


        c.gridx =0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 10;
        cp.add(t,c);
        c.gridx =0;
        c.gridy = 2;
        c.ipadx = 10;
        c.ipady = 10;
        b.addMouseListener(this);
        cp.add(b,c);
        c.gridx =0;
        c.gridy = 3;
        c.ipadx = 10;
        c.ipady = 10;
        b1.addMouseListener(this);
        cp.add(b1,c);
        c.gridx =0;
        c.gridy = 4;
        c.ipadx = 10;
        c.ipady = 10;
        b2.addMouseListener(this);
        cp.add(b2,c);
    }
    public void finalygui(){
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == b) {
            System.out.println("Comee!!");
            count = Integer.parseInt(t.getText());
            System.out.println("Count " + count);
            
            if (bool) {
             min = count;
             bool = false;
          }
          if (count == -1) {
             System.exit(0);
          }
           if (count >=  max){
             max = count;
        } else{
         if (stat < min) {
           min = stat;
         }else if (min > count) {
           min = count;
         }
         
        }
        stat = count;
            l.setText("Max = " + max + "  Min = " + min);
         }
         
         if (e.getSource() == b1) {
            i++;
            switch (i) {
                case 1:
                l.setBackground(Color.red);
                l.setOpaque(true);
                this.setBackground(Color.red);
                
               
                    break;
                case 2:
                    l.setBackground(Color.pink);
                    l.setOpaque(true);
                   
                        break;
                case 3:
                    l.setBackground(Color.yellow);
                    l.setOpaque(true);
                   
                        break; 
                case 4:
                    l.setBackground(Color.green);
                    l.setOpaque(true);
                   
                    i = 0;
                        break;                
                default:
                    break;
             }

         }
         if (e.getSource() == b2) {
            this.setVisible(false);
            new Menu();
         }
     }
    public void mousePressed(MouseEvent e) {
       }
    public void mouseReleased(MouseEvent e) {
     }
    public void mouseEntered(MouseEvent e) {
     } 
    public void mouseExited(MouseEvent e) {
     }
    
}
