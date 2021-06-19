//package fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    public Main() {
        super("von Koch snowflake");
        JButton draw  = new JButton("draw");
        lvl = new TextField("4",3);
        len = new TextField("200",3);
        lvl.addActionListener(this);
        len.addActionListener(this);
        draw.addActionListener(this);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JLabel("level"));
        cp.add(lvl);
        cp.add(new JLabel("side"));
        cp.add(len);
        cp.add(draw);
        panel.setBackground(Color.pink);
        panel.setForeground(Color.white);
        panel.setPreferredSize(new Dimension(600,400));
        cp.add(panel);
        setSize(700,500);
        cp.setBackground(Color.red);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static final long serialVersionUID = 123;
    private TextField lvl, len;
    private MyPanel panel = new MyPanel();
    private double angle;
    private Point currPt, pt = new Point();
    private void right(double x) {
        angle += x;
    }
    private void left (double x) {
        angle -= x;
    }
    private void drawFourLines(double side, int level, Graphics g) {
        if (level == 0) {
             // arguments to sin() and cos() must be angles given in radians,
             // thus, the angles given in degrees must be multiplied by PI/180;
             pt.x = ((int)(Math.cos(angle*Math.PI/180)*side)) + currPt.x;
             pt.y = ((int)(Math.sin(angle*Math.PI/180)*side)) + currPt.y;
             g.drawLine(currPt.x, currPt.y, pt.x, pt.y);
             currPt.x = pt.x;
             currPt.y = pt.y;
        }
       else {                                   
             drawFourLines(side/3.0,level-1,g);
             left (60);
             drawFourLines(side/3.0,level-1,g);
             right(120);
             drawFourLines(side/3.0,level-1,g);
             left (60);
             drawFourLines(side/3.0,level-1,g);
        }
    }
    public void actionPerformed(ActionEvent e) { 
        panel.repaint();
    }
    class MyPanel extends JPanel {
        static final long serialVersionUID = 124;
        public void paintComponent(Graphics g) { 
      	  	super.paintComponent(g);
          	int level = Integer.parseInt(lvl.getText().trim());
          	double side = Double.parseDouble(len.getText().trim());
          	currPt = new Point(200,150);
          	angle = 0;
          	for (int i = 1; i <= 3; i++) {
              	drawFourLines(side,level,g);
              	right(120);
            }
        }
    }
    static public void main(String[] a) {
        new Main();
    }
}
