package guipractice;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class RectangleImage {

    private Image img = null;
    private Rectangle rect = null;

    public RectangleImage(Image img, int x, int y) {
        this.img = img;
        this.rect = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));

    }

    public Rectangle getRect() {
        return this.rect;
    }

    public Image getImg() {
        return this.img;
    }

    public void move(int x, int y) {
        this.rect.setBounds(x, y, rect.width, rect.height);
        
    }
    public void draw(Graphics2D g2){
        g2.drawImage(this.img,this.rect.x,this.rect.y,this.rect.width,this.rect.height, null);
       // g2.draw(rect);
    }
    public boolean intersects(Rectangle r){
        return this.rect.intersects(r);
    }
    public Rectangle intersection(Rectangle r){
        return this.rect.intersection(r);
    }
}
