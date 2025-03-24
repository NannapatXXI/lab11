
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Firstpage extends JFrame{

    Container cp ;
    JLabel name , id ;
    JTextField t1 ,t2 ;
    JButton b1,b2 ;
    public Firstpage(){
        Initial();
        setComponent();
        Finally();
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
       
    }
   public void Closewin(){
    this.setVisible(false);
   }
    public void setComponent(){
        id = new JLabel("ID : ");
        name = new JLabel("Name : ");
        t1 = new JTextField("Please input",20);
        t2 = new JTextField("Please input",20);
        b1 = new JButton("Regesters");
        b2 = new JButton("Sign");  

        t1.addFocusListener(new Fo(){
             
            public void focusLost(FocusEvent e) {
                if (!t1.getText().equals("Please input")) {
                    t1.setText("พิมไรหน่อยน้อง");
                    System.out.println("Test in fo");
                }
            }
        });

        t1.addKeyListener(new tmp(){
            public void keyTyped(KeyEvent e) {
                  if (!Character.isDigit(e.getKeyChar())){
                    e.consume();         
                  }
            }
        });
        t2.addKeyListener(new tmp(){
            public void keyTyped(KeyEvent e) {
                    if (!((Character.isAlphabetic(e.getKeyChar()) ) || (e.getKeyChar()) == ' ')){
                      e.consume(); 
                    }    
            }
        });
        b1.addActionListener(new but(){
            public void actionPerformed(ActionEvent e) {
                new Regesters_page();
            }
        });
        b2.addActionListener(new but(){
            public void actionPerformed(ActionEvent e) {
                 File fi = null;
                 FileReader fr = null;
                BufferedReader br = null;
                Boolean status = true;
        try {
            fi = new File("./file/User.csv");
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {      
               String name =  t1.getText();
               String password = t2.getText();     
               String Full = name + ","+password; 
               if (d.equals(Full)) {// 1,p == Full ไหม ไม่ -> 111,Peak == Full
                    new Menu();
                    System.out.println("มาแล้วลูกจ้า");
                    status = false;
                   Closewin();
                    break;
               } 
               

            }    
            if (status) {
                Popup("Password and username are incorrect.");
                status = false;
               }
   
            
        } catch (Exception a) {
           System.out.println(a);
        }
        finally{
            try {
                br.close();fr.close();
            } catch (Exception b) {
                System.out.println(b);
            }
        }
            }
        });

        id.setBounds(32, 10, 60, 25);
        name.setBounds(10, 40, 60, 25);
        t1.setBounds(60, 10, 120, 25);
        t2.setBounds(60, 40, 120, 25);
        b1.setBounds(30, 80, 90, 25);
        b2.setBounds(120, 80, 70, 25);
        
        cp.add(id); cp.add(t1);
        cp.add(name); cp.add(t2);
        cp.add(b1) ; cp.add(b2);
    }
    public void Finally(){
        this.setSize(270, 160);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void Popup(String s){
        JDialog d = new JDialog();
        JLabel i = new JLabel(s);
        i.setBounds(10, 30, 270,  50);
        d.getContentPane().setLayout(null);
        d.getContentPane().add(i);
        d.pack();      
        d.setSize(270, 160);
        d.setVisible(true);
        d.setLocationRelativeTo(null);   
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
   
}
class tmp implements KeyListener{
    public void keyTyped(KeyEvent e) {  }


    public void keyPressed(KeyEvent e) { }

   
    public void keyReleased(KeyEvent e) {  }
    
}
class but implements ActionListener{

   
    public void actionPerformed(ActionEvent e) {
        }
    
}
class win implements WindowListener{

    
    public void windowOpened(WindowEvent e) {
     }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
     }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
  }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
     }
    
}
class Fo implements FocusListener{
    @Override
public void focusGained(FocusEvent e) {
   }

@Override
public void focusLost(FocusEvent e) {
}
}

