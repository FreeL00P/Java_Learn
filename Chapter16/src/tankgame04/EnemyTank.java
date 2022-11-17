package tankgame04;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 19:59    since 1.0.0      敌方坦克类
 */
public class EnemyTank extends Tank implements Runnable{
    public boolean isLive=true;
    Shot shot=null;
    //在敌人坦克类中，使用vector 保存多个shot
    Vector<Shot> enemyShots=new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true){
            //根据坦克方法继续移动
            // 然后随机改变坦克方向
            switch (getDirect()){
                //让坦克保持一个方向走30步
                case 0:
                    for (int i = 0; i <30 ; i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:   for (int i = 0; i <30 ; i++) {
                    moveDown();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    break;
                case 2:  for (int i = 0; i <30 ; i++) {
                    moveLeft();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    break;
                case 3:   for (int i = 0; i <30 ; i++) {
                    moveRight();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    break;
            }

            setDirect((int)(Math.random()*4));//随机生成方向
            //
            if (!isLive){
                break;
            }
            //判断敌人发射的子弹是否消亡 (集合里没有子弹) 且坦克没有被销毁
            if (isLive&&enemyShots.isEmpty()){
                //判断坦克的方向 创建对应的坦克
                switch (getDirect()){
                    case 0: //up表示向上
                        shot=new Shot(getX()+20,getY(),0);
                        break;
                    case 1: //下
                        shot=new Shot(getX()+20,getY()+60,1);
                        break;
                    case 2: //左
                        shot=new Shot(getX(),getY()+20,2);
                        break;
                    case 3: //右
                        shot=new Shot(getX()+60,getY()+20,3);
                        break;
                }
                //将shot子弹对象加入到集合
                enemyShots.add(shot);
                new Thread(shot).start();
            }
        }

    }
    //在创建敌人坦克位置时 启用线程


}
