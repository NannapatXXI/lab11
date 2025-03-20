
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Regesters_page extends JFrame implements ActionListener{

    Container cp ;
    JLabel name , id ;
    JTextField t1 ,t2,t3 ;
    JButton b1,b2 ;
    String Check1;
    String Check2;
    public Regesters_page(){
        Initial();
        setComponent();
        Finally();
       
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
        
    }
    public void setComponent(){
        id = new JLabel("ID : ");
        name = new JLabel("Name : ");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b1 = new JButton("Add");
        b2 = new JButton("Close");  
        
        id.setBounds(32, 10, 60, 25);
        name.setBounds(10, 40, 60, 25);
        t1.setBounds(60, 10, 120, 25);
        t2.setBounds(60, 40, 120, 25);
        b1.setBounds(30, 80, 70, 25);
        b2.setBounds(120, 80, 70, 25);
        b1.addActionListener(this);
        b2.addActionListener(this);
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
   
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
      if (e.getSource() == b1) {
          Check1 = t1.getText();
          Check2 = t2.getText();
        String error = " ";
        boolean CheckIDName = false;
        for (int i = 0; i < Check1.length(); i++) {
            if (!Character.isDigit(Check1.charAt(i))){
                CheckIDName = true;
                error +="Error Because  letter in the ID field";
                break;
            }
        }
        for (int i = 0; i < Check2.length(); i++) {
            if (!((Character.isAlphabetic(Check2.charAt(i)) ) || (Check2.charAt(i) == ' '))){
                CheckIDName = true;
                error +="Error Because  number in the Name field";
                break;
            }
        }
        if (CheckIDName) {
            Popup(error);
        }else{
            write(Check1, Check2);
         //   Popup("Complete");
            this.setVisible(false);
        }
       
      }else if (e.getSource() == b2) {
        this.setVisible(false);
        t1.setText("");
        t2.setText("");
      }
    }
    public void write(String id , String name){
        File fo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fo = new File("./file/User.csv");
            fw = new FileWriter(fo,true);
            bw = new BufferedWriter(fw);
            bw.write(id + "," + name+ "\n");
            System.out.println("InCheckfiled");
            
        } catch (Exception a) {
            System.out.println(a);
        }finally{
            try {
                bw.close();fw.close();
            } catch (Exception a) {
                System.out.println(a);
            }
        }
    }
    public void Popup(String s){
        JDialog d = new JDialog();
        JLabel i = new JLabel(s);
        i.setBounds(0, 30, 270,  50);
        d.getContentPane().setLayout(null);
        d.getContentPane().add(i);
        d.pack();      
        d.setSize(270, 160);
        d.setVisible(true);
        d.setLocationRelativeTo(null);   
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    }
    