import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
//import java.awt.image.CreateImage;
class crop 
{
 BufferedImage input,output;
 crop()
 {
  try{
  File ip=new File("demo.jpg");
  input=ImageIO.read(ip);
  ImageFilter imf=new CropImageFilter(30,30,50,50);
  Image temp=Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(input.getSource(),imf));
  output=new BufferedImage(100,100,input.getType());
  Graphics2D b=output.createGraphics();
  b.drawImage(temp,0,0,null);
  b.dispose();
  File op=new File("crop.jpg");
  ImageIO.write(output,"jpg",op);}catch(Exception e){System.out.println(""+e);}
 }
 public static void main(String args[])
 {
  crop c=new crop();
 }
}
