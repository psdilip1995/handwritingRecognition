import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
class demo {
   BufferedImage  image,output;
   int width;
   int height;
   public demo() {
      try {
         File input = new File("demo.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
		 output=new BufferedImage(200,200,image.getType());
		 Graphics2D g2d = output.createGraphics();
		 g2d.drawImage(image,0,0,200,200,null);
		 g2d.dispose();
		 ImageIO.write(output,"jpg",new File("demo1.jpg"));
         /*int count = 0;
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               count++;
               //Color c = new Color(image.getRGB(j, i));
               //System.out.println("S.No: " + count + " Red: " + c.getRed() +" Green: " + c.getGreen() + " Blue: " + c.getBlue());
               }
            }*/
      } catch (Exception e) {}
   }
   static public void main(String args[]) throws Exception 
   {
      demo obj = new demo();
   }
}