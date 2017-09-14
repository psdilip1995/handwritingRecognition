import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
class demorgb {
   String x,y,r;
   FileOutputStream fosx,fosy,fosr;
   File fx,fy,fr;
   BufferedImage  image;
   int width;
   int height;
   Integer tx,ty,tr;
   int xy[][]=new int[7061][3];
   public demorgb() {
      try {
         fx=new File("x.txt");
         fy=new File("y.txt");
         fr=new File("r.txt");
         File input = new File("E.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         int count = 0;
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               Color c = new Color(image.getRGB(j, i));
               if(c.getRed()!=255 && c.getGreen()!=255 && c.getBlue()!=255)
               {
                xy[count][0]=j;
                xy[count][1]=i;
                xy[count][2]=c.getRed();
                count++;
                //System.out.println("S.No: " + count + " Red: " + c.getRed()+" Green: " + c.getGreen() + " Blue: " + c.getBlue());
               }
               }
            }
	fosx=new FileOutputStream(fx);
	fosy=new FileOutputStream(fy);
	fosr=new FileOutputStream(fr);
	for(int k=0;k<7061;k++)
	{
	 tx=xy[k][0];
	 ty=xy[k][1];
	 tr=xy[k][2];
	 x=tx.toString();
	 y=ty.toString();
	 r=tr.toString();
	 for(int l=0;l<x.length();l++)
	 fosx.write(x.charAt(l));
	 fosx.write(',');
	 for(int l=0;l<y.length();l++)
	 fosy.write(y.charAt(l));
	 fosy.write(',');
	 for(int l=0;l<r.length();l++)
	 fosr.write(r.charAt(l));
	 fosr.write(',');
	}
	//System.out.println("x = "+xy[k][0]+" y = "+xy[k][1]);
	fosx.close();
	fosy.close();
	fosr.close();
	System.out.println("height = "+height+"\nwidth = "+width+"\ncount = "+count);
      } catch (Exception e) {}
   }
   static public void main(String args[]) throws Exception 
   {
      demorgb obj = new demorgb();
   }
}