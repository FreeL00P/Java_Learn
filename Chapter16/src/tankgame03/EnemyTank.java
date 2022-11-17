package tankgame03;

import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 19:59    since 1.0.0      敌方坦克类
 */
public class EnemyTank extends Tank {
    public boolean isLive=true;
    Shot shot=null;
    //在敌人坦克类中，使用vector 保存多个shot
    Vector<Shot> enemyShots=new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
   /* public void fire(){
        //根据坦克方向 发射对应方向的子弹
        shot=new Shot(getX()+80,getY()+60,1);
        enemyShots.add(shot);
       *//* switch (getDirect()){
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
        }*//*
       new Thread(shot).start();
    }*/
}
