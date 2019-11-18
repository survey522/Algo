import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AlgoVisualizer {
    private int lazy=10;       //间隔刷新时间
    private int[] moneys;      //数据 TODO:
    private AlgoFrame frame;    //视图



    public AlgoVisualizer(int sceneWidth,int sceneHeight){

        //初始化数据
        //TODO 初始化数据
        moneys = new int[100];
        for(int i=0;i<moneys.length;i++){
            moneys[i]=100;
        }


        //初始化视图
        EventQueue.invokeLater(() ->{
            frame = new AlgoFrame("ALGO",sceneWidth,sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(()->{
                //动画逻辑
                run();
            }).start();


        });

    }
    //动画逻辑
    //TODO 动画逻辑
    private void run(){
        while (true){
            Arrays.sort(moneys);
            frame.render(moneys);
            AlgoVisHelper.pause(lazy);

            for(int k=0;k<20;k++){ //加快速度
                for(int i=0;i<moneys.length;i++){
                   // if(moneys[i]>0){
                        int j = (int)(Math.random()*moneys.length);
                        moneys[i] -=1;
                        moneys[j] +=1;
                 //   }

                }
            }

        }

    }
    //键盘事件
    private class AlgoKeyListener extends KeyAdapter{ }
    //鼠标事件
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,-(frame.getBounds().height-frame.getCanvasHeight()));
            Point point = e.getPoint();


        }
    }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth,sceneHeight);

    }

}
