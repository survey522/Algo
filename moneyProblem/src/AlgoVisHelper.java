import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
//TODO------------
//判断鼠标点的地方 是哪个人的money[i]
public class AlgoVisHelper {


    private AlgoVisHelper(){}

    //颜色
    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    //线条粗细
    public static void setStrokeWidth(Graphics2D g2d,int w){
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));

    }

    //空心圆
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){

        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }

    //实心圆
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){

        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }
    //空心矩形
    public static void strokeRectangle(Graphics2D g,int x,int y,int w,int h){
        Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,w,h);
        g.draw(rectangle2D);
    }
    //实心矩形
    public static void fillRectangle(Graphics2D g,int x,int y,int w,int h){
        Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,w,h);
        g.fill(rectangle2D);
    }

    //暂停
    public static void pause(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //放图像
    public static void putImage(Graphics2D g,int x,int y,String imageURL){
        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();
        g.drawImage(image,x,y,null);
    }
    //写字
    public static void drawText(Graphics2D g,String text,int centerx,int centery){
        if(null == text){
            throw new IllegalArgumentException("text is null in drawText");
        }
        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text,centerx - w/2,centery + h);

    }

    //TODO------------
    //判断鼠标点的地方 是哪个人的money[i]
    public Integer contain(Point p){


        return null;
    }

}
