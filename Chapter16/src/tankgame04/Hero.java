package tankgame04;

import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:27    since 1.0.0      主角坦克
 */
public class Hero extends Tank {
    //创建一个shot对象
    Shot shot = null;
    Vector<Shot> shots=new Vector<>();//可以发射多颗子弹
    public Hero(int x, int y) {
        super(x, y);
    }
    public void fire(){
        //根据坦克方向 发射对应方向的子弹
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
        //同一时间只能发射五颗子弹
        if (shots.size()<5){
            shots.add(shot);//把新创建的shot放入shots
        }
        new Thread(shot).start();//启用shot射击线程
    }
}
