import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GuiAnimation extends JFrame { 
    public GuiAnimation (){
       // getContentPane().setLayout(null);
        Draw1 a = new Draw1();
        getContentPane().add(a);
        
        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
}

class Draw1 extends JPanel implements ActionListener{
    int x = 10,y = 10,A=0;
    Color box[] = {Color.yellow,Color.red , Color.pink,Color.green,Color.black,Color.BLUE,Color.LIGHT_GRAY};
    public Draw1 (){
        Timer timer1 = new Timer(10,this);
        timer1.start();
    }
    
    public void paintComponent(Graphics g){
        Polygon xy = new Polygon();
        xy.addPoint(getWidth()/2-20,getHeight()/2+10);
        xy.addPoint(getWidth()/2,getHeight()/2-40);
        xy.addPoint(getWidth()/2+20,getHeight()/2+10);
        xy.addPoint(getWidth()/2-30,getHeight()/2-20);
        xy.addPoint(getWidth()/2+30,getHeight()/2-20);
        g.drawPolygon(xy);
        g.setColor(box[A]);
        g.fillPolygon(xy);
        
        super.paintComponent(g);
        g.fillOval(x, y, 100, 100);
    }
   
    public void actionPerformed(ActionEvent e) {
        x+= 5;
       System.out.println("X = "+ x);
        if (x == 300 ) {
            System.out.println("reset");
            x = -30;
            y += 30;
            A +=1;
            if (A == 7) {
                A = 0 ;
                y = 10;
            }
        }
        repaint();
    }

}

