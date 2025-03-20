import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class RandWFile implements ActionListener {
    JFrame f;
    JButton b1 ;
    public RandWFile (){
        f = new JFrame("Vehicle registration ");
        Container cp = f.getContentPane();
        cp.setLayout(null);
        JLabel I1 = new JLabel("Name  :");
        JLabel I2 = new JLabel("Car lincense :");
        JLabel I3 = new JLabel("Province :");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        I1.setBounds(50, 0, 100, 50);
        t1.setBounds(100, 10, 150, 25);
        I2.setBounds(15, 37, 100, 50);
        t2.setBounds(100, 50, 150, 25);
        I3.setBounds(35, 70, 100, 50);
        cp.add(I1);cp.add(t1); cp.add(I2);cp.add(t2);cp.add(I3);
        JComboBox<String> I = comboBox();
        I.setBounds(100, 85, 100, 20);
        cp.add(I);
        JLabel I4 = new JLabel("Car Type :");
         b1 = new JButton("Ok");
        JRadioButton rb1 = new JRadioButton("Car ",true);
        JRadioButton rb2 = new JRadioButton("Bike ");
        ButtonGroup group = new ButtonGroup();
        I4.setBounds(33, 100, 100, 50);
        cp.add(I4);group.add(rb1); group.add(rb2);
        rb1.setBounds(100, 110, 70, 30);
        rb2.setBounds(150, 110, 70, 30);
        b1.setBounds(100, 150, 100, 30);

        b1.addActionListener(this);

        cp.add(rb1);cp.add(rb2);cp.add(b1);
        f.setSize(300, 250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
     public JComboBox<String> comboBox(){
        JComboBox<String> tmp = new JComboBox<>();
        File fi = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fi = new File("./File/Thailand_PRV.csv");
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            String d;
            br.readLine();
            while ((d = br.readLine()) != null) {              
                String []s = d.split(",");   
                tmp.addItem(s[1]);                
            }       
            tmp.setSelectedIndex(1);
        } catch (Exception e) {
           System.out.println(e);
        }
        finally{
            try {
                br.close();fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return tmp;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            f.setVisible(false);
            new Menu();
        }
               
        }
}

