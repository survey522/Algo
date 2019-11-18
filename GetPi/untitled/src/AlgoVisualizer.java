import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private Circle circle;
    private LinkedList<Point> points;     // 数据
    private AlgoFrame frame;    // 视图
    private int N; //打点数

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int n){

        // 初始化数据
        // TODO: 初始化数据
        if(sceneWidth!=sceneHeight){
            throw new IllegalArgumentException("这次请让宽等于高");
        }
        points = new LinkedList<Point>();
        circle = new Circle(sceneWidth/2,sceneWidth/2,sceneWidth/2);
        this.N = n;
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        for(int i=0;i<N;i++){
            int x = (int)(Math.random()*frame.getCanvasWidth());
            int y = (int)(Math.random()*frame.getCanvasHeight());
            Point p = new Point(x,y);
            points.add(p);
            frame.render(circle,points);
            AlgoVisHelper.pause(20);
        }

    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 10000;
        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,n);
    }
}
