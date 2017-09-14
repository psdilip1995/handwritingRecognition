import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class hd extends Frame implements ActionListener
{
 BufferedImage input;
 String s1="enter file name along with extension(Eg:demo.jpg)";
 Label l1;
 TextField t1;
 Button b1;
 can1 c1;
 hd()
 {
  l1=new Label("enter the file name");
  t1=new TextField(20);
  b1=new Button("ok");
  b1.addActionListener(this);
  c1=new can1();
  add(l1);
  add(t1);
  add(b1);
  add(c1);
  setLayout(new FlowLayout());
  setSize(400,400);
  setVisible(true);
 }
 public static void main(String args[])
 {
  hd h=new hd();
 }
 public void actionPerformed(ActionEvent e)
 {
  try{
  File ip=new File(t1.getText());
  input=ImageIO.read(ip);}catch(Exception eee){}
  bw();
  nol();
  s1="done";
  c1.repaint();
 }
 class can1 extends Canvas
 {
  can1(){setSize(400,400);setBackground(Color.white);}
  public void paint(Graphics g)
  {
   g.drawString(s1,50,50);
  }
 }
 public void bw()
 {
          int t=0;
          try{
           for(int i=0; i<input.getHeight(); i++){
            for(int j=0; j<input.getWidth(); j++){
               Color c = new Color(input.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
	if(red+green+blue > 100)
		t=255;
	else
		t=0;
               Color newColor = new Color(t,t,t);
               input.setRGB(j,i,newColor.getRGB());
               }
          }
         File ouptut = new File("bw.jpg");
         ImageIO.write(input, "jpg", ouptut);
          }catch(Exception e){System.out.println(""+e);}
 }
 public void nol()
 {
  int t=0,tt=0,n=0,i,j,start=0,end=0;
  for(i=0;i<input.getHeight();i++)
  {
       for(j=0;j<input.getWidth();j++)
       {
        Color c=new Color(input.getRGB(j,i));
        if(c.getRed()==0)
	t++;
       }
       if(t>3 && tt==0)
       {
	if(n>0 && end-start < 10)
		n--;
	tt++;
	n++;
	System.out.println("strating of line "+n+" = "+i);
	start=i;
	if(start > (input.getHeight() - 100))
		n--;
       }
       else if(t<=3 && tt==1)
       {
	tt--;
	System.out.println("ending of line "+n+" = "+i);
	end=i;
       }
       t=0;
  }
  System.out.println("no. of lines : "+n);
 }
}