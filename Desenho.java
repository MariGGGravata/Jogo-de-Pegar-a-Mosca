import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Desenho {
	
	private int x;
	private int y;
	private BufferedImage img;
	
	public Desenho() {}
	
	public Desenho(int x,int y, String path) {
		
		this.setX(x);
		this.setY(y);
		this.setImg(path);
		
	}
	
	public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImg() {
        return img;
    }
	
    public void setImg(String path) {
        try {
            img = ImageIO.read(getClass().getResource(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void desenhar(Graphics g) {
        //Desenhando a imagem na tela
        g.drawImage(this.getImg(), this.getX(), this.getY(), null);
    }
    
    public Rectangle bounds() {
  	  
     	  return (new Rectangle(x, y, 80, 80));
    }
    
    public static Rectangle bounds1() {
    	  
   	  return (new Rectangle(0, 825, 1000000000, 1000000000));
  }
}
