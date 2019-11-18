import java.awt.*;
import java.util.LinkedList;


public class AlgoVisualizer {
    private int N;
    private LinkedList<Point> points;
    private Circle circle;       //数据 TODO:
    private AlgoFrame frame;    //视图
    private int insid=0;



    public AlgoVisualizer(int sceneWidth,int sceneHeight,int N){
        this.N = N;

        //初始化数据
        //TODO 初始化数据
        if(sceneWidth!=sceneHeight){
            throw   new IllegalArgumentException("x=y!!!");
        }
        circle = new Circle(sceneWidth/2,sceneHeight/2,sceneHeight/2);
        points = new LinkedList<Point>();

        //初始化视图
        EventQueue.invokeLater(() ->{
            frame = new AlgoFrame("ALGO",sceneWidth,sceneHeight);
            new Thread(()->{
                //动画逻辑
                run();
            }).start();


        });

    }
    //动画逻辑
    //TODO 动画逻辑
    private void run(){
        for(int i=0;i<N;i++){
            if(i%100==0){
                frame.render(circle,points);
                AlgoVisHelper.pause(20);

                if(points.size()!=0){
                    int circleArea = insid;
                    int squareArea = points.size();
                    double pi = (double) (4*circleArea)/squareArea;
                    System.out.println(pi);
                }
            }


            int x = (int) (Math.random()*frame.getCanvasWidth());
            int y = (int) (Math.random()*frame.getCanvasHeight());
            Point p = new  Point(x,y);
            if(circle.contain(p)){
                insid++;
            }
            points.add(p);
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 600;
        int sceneHeight = 600;

        //TODO:
        int N = 1000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth,sceneHeight,N);

    }

}
