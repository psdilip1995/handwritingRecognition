import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
class findcount{
   BufferedImage  image;
   int width;
   int height;
   public findcount() {
      try {
         File input = new File("E.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         int count = 0;
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               Color c = new Color(image.getRGB(j, i));
	if(c.getRed()!=255 && c.getGreen()!=255 && c.getBlue()!=255)
	count++;
               }
            }
	System.out.println("count = "+count);
      } catch (Exception e) {}
   }
   static public void main(String args[]) throws Exception 
   {
      findcount obj = new findcount();
   }
}