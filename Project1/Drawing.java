
/**
 * Write a description of class BusinessCard here.
 *
 * @author Elijah Anderson
 * @version 11 May 2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Drawing extends JPanel{

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(600, 400);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g){
        Point contactInfoPosition = new Point(370, 230);
        Point logoPosition = new Point(10, 10);
        
        
        // this statement required
        super.paintComponent(g);
         
        // optional: paint the background color (default is white)
        setBackground(Color.WHITE);

        // border
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 515, 315);
        g.setColor(Color.GRAY);
        g.fillRect(5, 5, 505, 305);
        

        // title
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lucida Fax", Font.BOLD, 32));
        g.drawString("Til Dusk Development", 130, 42);

        // business info
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lucida Sans", Font.PLAIN, 16)); 
        g.drawString("Make your dream game a reality", 180, 100);
        g.drawString("We work through the night to develop your projects", 60, 180);

        // contact info
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lucida Fax", Font.PLAIN, 14)); 
        g.drawString("Elijah Anderson", (int) contactInfoPosition.getX(), (int) contactInfoPosition.getY());
        g.setFont(new Font("Lucida Sans", Font.PLAIN, 12)); 
        g.drawString("Programmer Extraordinaire", (int) contactInfoPosition.getX() - 27, (int) contactInfoPosition.getY() + 20);
        g.setFont(new Font("Arial", Font.PLAIN, 14)); 
        g.drawString("555-1823-192", (int) contactInfoPosition.getX() + 8, (int) contactInfoPosition.getY() + 40);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
        g.drawString("27184 Rainbow Road", (int) contactInfoPosition.getX() + 8, (int) contactInfoPosition.getY() + 60);
        g.drawString("Redmond, WA 98052.", (int) contactInfoPosition.getX() + 8, (int) contactInfoPosition.getY() + 70);
        
        // logo
        g.setColor(Color.BLACK);
        g.fillRect((int) logoPosition.getX(), (int) logoPosition.getY(), 110, 110); // border
        g.setColor(new Color(2, 15, 50));
        g.fillRect((int) logoPosition.getX() + 5, (int) logoPosition.getY() + 5, 100, 100); // background
        g.setColor(Color.ORANGE);
        g.fillOval((int) logoPosition.getX() + 5, (int) logoPosition.getY() + 5, 100, 100); // sun
        g.setColor(new Color(30, 30, 30));

        g.fillOval((int) logoPosition.getX() + 0, (int) logoPosition.getY() + 75, 65, 40); // clouds
        g.fillOval((int) logoPosition.getX() + 20, (int) logoPosition.getY() + 60, 85, 55);
        g.fillOval((int) logoPosition.getX() + 55, (int) logoPosition.getY() + 75, 65, 40);
    

        BufferedImage photo = null;
        try {
	        File file = new File("MyPhoto.jpg");
	        photo = ImageIO.read(file);
        } catch (IOException e){
         	g.drawString("Problem reading the file", 100, 100);
        }
        g.drawImage(photo, 10, 10, 150, 225, null);
    }
}

