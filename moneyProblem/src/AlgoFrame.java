
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title,int canvasWidth,int canvasHeight){

        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        //canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight)); //画板的长宽 在画板里设置吧
        setContentPane(canvas); //设置内容面板为canvas
        pack();//自动调整窗口大小

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public AlgoFrame(String title){
        this(title,1024,768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }
    public int getCanvasHeight() {
        return canvasHeight;
    }

    //:----设置自己的数据----
    //TODO:----设置自己的数据----
    private int[] moneys;
    public void render(int[] moneys){
        this.moneys = moneys;
        repaint();
    }



    //内部类  画板
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            super(true);
        }

        //用于绘制
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            //TODO:具体绘制
            AlgoVisHelper.setColor(g2d,Color.BLUE);
            int w = canvasWidth/moneys.length;
            for(int i=0;i<moneys.length;i++){
                if(moneys[i]>0){
                    AlgoVisHelper.fillRectangle(g2d,i*w+1,canvasHeight/2-moneys[i],
                            w-1,moneys[i]);
                }else if(moneys[i]<0) {
                    AlgoVisHelper.fillRectangle(g2d,i*w+1,canvasHeight/2,
                            w-1,-moneys[i]);
                }

            }

        }
        //画板的长宽
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
