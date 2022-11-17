package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:28    since 1.0.0      游戏的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero=null;
    public MyPanel(){
        hero=new Hero(100,100);//初始化主角坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形 默认黑色


        //画出坦克
        drawTank(hero.getX(),hero.getY(),g,0,0);//hero
        //  drawTank(hero.getX()+60,hero.getY(),g,0,1);//敌人坦克
    }
    //编写方法 画出坦克

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向 上下左右
     * @param type 坦克类型 主角敌人
     */
    public void  drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){//判断坦克类型
            case 0://主角的坦克
                //设置颜色区分敌我
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                //设置颜色区分敌我
                g.setColor(Color.yellow);
        }

        //根据坦克方向 绘制坦克
        switch (direct){
            case 0: //up表示向上
                g.fill3DRect(x,y,10,60,false);//左边轮子
                g.fill3DRect(x+30,y,10,60,false);//左边轮子
                g.fill3DRect(x+10,y+10,20,40,false);//中间矩形 坦克盖子
                g.fillOval(x+10,y+20,20,20);//坦克炮台 活动圆圈
                g.drawLine(x+20,y+30,x+20,y);//炮筒
                break;
            case 1: //下
                g.fill3DRect(x,y,10,60,false);//左边轮子
                g.fill3DRect(x+30,y,10,60,false);//左边轮子
                g.fill3DRect(x+10,y+10,20,40,false);//中间矩形 坦克盖子
                g.fillOval(x+10,y+20,20,20);//坦克炮台 活动圆圈
                g.drawLine(x+20,y+30,x+20,y+60);//炮筒
                break;
            case 2: //左
                g.fill3DRect(x,y,60,10,false);//左边轮子
                g.fill3DRect(x,y+30,60,10,false);//左边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//中间矩形 坦克盖子
                g.fillOval(x+20,y+10,20,20);//坦克炮台 活动圆圈
                g.drawLine(x+30,y+20,x,y+20);//炮筒
                break;
            case 3: //右
                g.fill3DRect(x,y,60,10,false);//左边轮子
                g.fill3DRect(x,y+30,60,10,false);//左边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//中间矩形 坦克盖子
                g.fillOval(x+20,y+10,20,20);//坦克炮台 活动圆圈
                g.drawLine(x+30,y+20,x+60,y+20);//炮筒
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
