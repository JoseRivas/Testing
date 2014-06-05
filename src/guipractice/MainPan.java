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

    private Image road;
    private final RectangleImage car;
    private RectangleImage obs;
    int xPos = 1200, direction = -1;
    int yPos = (int) (Math.random()*700)+1;
    public MainPan() {
        road = getImage("road.jpg");
        car = new RectangleImage(getImage("bluecar.png"), 0, 350);
        obs = new RectangleImage(getRand(), xPos, yPos);
        final Timer timer = new Timer(1, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPos += direction;
                if (xPos<-120) {
                    xPos = getWidth()+120;
                    yPos = (int) (Math.random()*getHeight())+1;
                    obs = new RectangleImage(getRand(), xPos, yPos);
                }
                if(obs.intersects(car.getRect())){
                    timer.stop();
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
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        g2.drawImage(road, 0,0,getWidth(),getHeight(), this);
        obs.move(xPos,yPos);
        car.draw(g2);
        obs.draw(g2);
        if(obs.intersects(car.getRect())){
                    System.out.println("CRASH!");
                }
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
    public Image getRand(){
        Image img = null;
        int nRand;
        String sFilename;
        nRand = (int) (Math.random() * 5) + 1;
        if (nRand == 1) {
            sFilename = "yellowcar.png";
        } else if (nRand == 2) {
            sFilename = "greycar.png";
        } else if (nRand == 3) {
            sFilename = "police.png";
        } else if (nRand == 4) {
            sFilename = "bluecar.png";
        } else {
            sFilename = "whitecar.png";
        }
        try {
            img = ImageIO.read(new File(sFilename));
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return img;
    }
    public int Rand(){
        return (int)(Math.random()*5)+1;
    }
}
