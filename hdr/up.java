import java.awt.*;
import java.awt.event.*;
class up extends Frame implements ActionListener
{
 Button b;
 int x=200,y=200;
 up()
 {
  //Graphics g=getGraphics();
  //g.drawLine(50,50,200,200);
  b=new Button("update");
  b.addActionListener(this);
  add(b);
  setLayout(new FlowLayout());
  setSize(500,500);
  setVisible(true);
 }
 public static void main(String args[])
 {
  up u=new up();
 }
 public void paint(Graphics g)
 {
  g.drawLine(x,y,400,100);
 }
 /*public void update(Graphics g)
 {
  repaint();
  g.drawLine(50,50,200,200);
 }*/
 public void actionPerformed(ActionEvent e)
 {
  x+=20;
  y+=20;
  //update(g);
  repaint();
 }
}