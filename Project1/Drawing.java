
/** PROJECT 1 -- BUSINESS CARD
 * 
 *
 * @author Elijah Anderson
 * @version 11 May 2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class Drawing extends JPanel{

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(600, 400);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g){
        Point contactInfoPosition = new Point(140, 230); // base position for contact info block
        Point logoPosition = new Point(10, 10); // base position for logo block
        
        // this statement required
        super.paintComponent(g);
         
        // optional: paint the background color (default is white)
        setBackground(Color.WHITE);

        // border
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 515, 315); // creates the border
        g.setColor(new Color(2, 15, 50));
        g.fillRect(5, 5, 505, 305); // draws background over
        g.setColor(Color.WHITE);

        Random numGenerator = new Random();
        for (int i=0; i<30; i++) {
        	g.fillOval(5 + numGenerator.nextInt(495), 5 + numGenerator.nextInt(295), 3, 3); // creates stars at random points within
        																					// the background (5-500, 5-300)
        }
        
        // title
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lucida Fax", Font.BOLD, 32));
        g.drawString("Til Dusk Development", 130, 42);

        // business info
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Lucida Sans", Font.PLAIN, 16)); 
        g.drawString("Make your dream game a reality", 180, 100);
        g.setColor(new Color(220, 200, 100));
        g.drawString("We work through the night", 80, 160);
        g.drawString("to develop your projects", 140, 180);

        // contact info
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lucida Fax", Font.PLAIN, 14)); 
        g.drawString("Elijah Anderson", (int) contactInfoPosition.getX(), (int) contactInfoPosition.getY());
        g.setFont(new Font("Lucida Sans", Font.PLAIN, 12)); 
        g.drawString("Programmer Extraordinaire", (int) contactInfoPosition.getX() - 28, (int) contactInfoPosition.getY() + 20);
        g.setFont(new Font("Lucida Sans", Font.PLAIN, 14)); 
        g.drawString("555-1823-192", (int) contactInfoPosition.getX() + 2, (int) contactInfoPosition.getY() + 40);
        g.setFont(new Font("Lucida Fax", Font.PLAIN, 10)); 
        g.drawString("27184 Rainbow Road", (int) contactInfoPosition.getX() + 2, (int) contactInfoPosition.getY() + 60);
        g.drawString("Redmond, WA 98052.", (int) contactInfoPosition.getX() + 3, (int) contactInfoPosition.getY() + 70);
        
        // logo
        g.setColor(Color.BLACK);
        g.fillRect((int) logoPosition.getX(), (int) logoPosition.getY(), 110, 110); // border

        g.setColor(new Color(2, 15, 50));
        g.fillRect((int) logoPosition.getX() + 5, (int) logoPosition.getY() + 5, 100, 100); // background
        
        g.setColor(new Color(190, 190, 190));
        g.fillOval((int) logoPosition.getX() + 5, (int) logoPosition.getY() + 5, 100, 100); // moon border
        g.setColor(new Color(230, 230, 230));
        g.fillOval((int) logoPosition.getX() + 8, (int) logoPosition.getY() + 8, 94, 94); // moon

        g.setColor(new Color(215, 215, 215));
        g.fillOval((int) logoPosition.getX() + 25, (int) logoPosition.getY() + 35, 18, 20); // craters
        g.fillOval((int) logoPosition.getX() + 75, (int) logoPosition.getY() + 50, 24, 21);
        g.fillOval((int) logoPosition.getX() + 65, (int) logoPosition.getY() + 18, 17, 15);
        
		g.setColor(new Color(30, 30, 30));
        g.fillOval((int) logoPosition.getX() + 0, (int) logoPosition.getY() + 75, 65, 40); // clouds
        g.fillOval((int) logoPosition.getX() + 20, (int) logoPosition.getY() + 60, 85, 55);
        g.fillOval((int) logoPosition.getX() + 55, (int) logoPosition.getY() + 75, 65, 40);
    	
        // photo
        BufferedImage photo = null;
        try {
	        File file = new File("MyPhoto.jpg");
	        photo = ImageIO.read(file);
        } catch (IOException e){
         	g.drawString("Problem reading the file", 10, 260);
        }
        g.drawImage(photo, 410, 150, 95, 155, null);
    }
}

