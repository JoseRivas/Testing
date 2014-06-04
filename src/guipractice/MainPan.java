package guipractice;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class MainPan extends JPanel {

    //private Image road;
    private final RectangleImage car;
    private final RectangleImage obs;
    int xPos = 1200, direction = -1;
    int yPos = (int) (Math.random()*700)+1;
    public MainPan() {
        
        car = new RectangleImage(getImage("bluecar.png"), 0, 350);
        obs = new RectangleImage(getImage("greycar.png"), xPos, yPos);
        final Timer timer = new Timer(4, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPos += direction;
                if (xPos<-120) {
                    xPos = 1200;
                    yPos = (int) (Math.random()*700)+1;
                }
                repaint();

            }

        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        
        //road = getImage("road.jpg");
        Graphics2D g2 = (Graphics2D) g;
        //g2.drawImage(road, 0,0,getWidth(),getHeight(), this);
        super.paint(g2);
        obs.move(xPos,yPos);
        car.draw(g2);
        obs.draw(g2);

    }

    public Image getImage(String path) {
        Image tempImage = null;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return tempImage;
    }

}
