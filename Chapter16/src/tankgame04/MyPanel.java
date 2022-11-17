package tankgame04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:28    since 1.0.0      游戏的绘图区域
 */

//为了监听键盘事件要实现 KeyListen
// 为了让Panel 不停的重绘子弹 要把MyPanel作为一个线程
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero=null;
    //ArrayList<EnemyTank> enemyTanks=new ArrayList<>(); //线程不安全
    Vector<EnemyTank> enemyTanks=new Vector<>();//存放敌人坦克
    //Vector<EnemyTank> heroTanks=new Vector<>();//存放我方坦克
    Vector<Bomb> bombs=new Vector<>();//当子弹击中坦克时 加入到bombs
    int enemyTankSize=3;//敌人坦克数量
    //定义三张图片 用于显示爆炸效果
    Image image1=null;
    Image image2=null;
    Image image3=null;
    public MyPanel(){
        hero=new Hero(100,100);//初始化主角坦克
        hero.setSpeed(3);//设置坦克速度
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向 默认下
            enemyTank.setDirect(1);
            //启动敌人坦克移动线程
            new Thread(enemyTank).start();
            //g给enemyTank对象加入一颗子弹
            Shot shot=new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
            //加入enemyTank 中的 vector--Shots
            enemyTank.enemyShots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);//加入到坦克Vector
        }
        //初始化图片
        image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
        image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2.png"));
        image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形 默认黑色


        //画出坦克
        if (hero!=null&&hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//hero
        }
        //敌人坦克 和子弹
        for (int j = 0; j <enemyTanks.size() ; j++) {
            EnemyTank enemyTank = enemyTanks.get(j);

            if (enemyTank.isLive) {
                drawTank(enemyTank.getX() , enemyTank.getY(), g, enemyTank.getDirect(), 1);//敌人坦克
                for (int i = 0; i < enemyTank.enemyShots.size(); i++) {
                    //取出敌人子弹
                    Shot shot = enemyTank.enemyShots.get(i);
                    if (shot != null && shot.isLive) {
                        //System.out.println("敌人子弹发射中  ");
                        g.draw3DRect(shot.getX() , shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.enemyShots.remove(shot);
                    }
                }
            }
        }
        //画出主角子弹
//        if(hero.shot != null && hero.shot.isLive){
//            //System.out.println("主角子弹发射中  ");
//            g.draw3DRect(hero.shot.getX(),hero.shot.getY(),2,2,false);
//        }
        //将hero的子弹集合遍历取出 绘制
        for (int i = 0; i <hero.shots.size() ; i++) {
            Shot shot= hero.shots.get(i);
            if(shot != null && shot.isLive){
                //System.out.println("主角子弹发射中  ");
                //防止敌人坦克死亡后  子弹变色
                g.setColor(Color.cyan);
                g.draw3DRect(shot.getX(),shot.getY(),2,2,false);
            }else {
                //shot对象无效 就从shots消除
                hero.shots.remove(shot);
            }
        }
        //画出爆炸效果
        for(int i=0;i<bombs.size();i++){
            //取出炸弹
            //第一个被击中坦克不爆炸 休眠10毫秒
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bomb bomb=bombs.get(i);
            //根据当前这个bomb对象的life值画出对应的图片
            if (bomb.getLife()>5){
                g.drawImage(image1,bomb.getX(),bomb.getY(),60,60,this);
            }else if (bomb.getLife()>3){
                g.drawImage(image2,bomb.getX(),bomb.getY(),60,60,this);
            }else {
                g.drawImage(image3,bomb.getX(),bomb.getY(),60,60,this);
            }
            bomb.lifeDown();//生命值减少
            if(bomb.getLife()==0){//生命值为0 删除
                bombs.remove(bomb);
            }
        }
    }

    //编写方法 子弹是否击中
    public void hitTank(Shot shot, Tank enemyTank){
        //先判断敌人坦克的方向
        switch (enemyTank.getDirect()){
            case 0:
            case 1:
                //判断子弹是否击中
                if(shot.getX()>enemyTank.getX()&&shot.getX()<enemyTank.getX()+40 &&shot.getY()>enemyTank.getY()&&shot.getY()<enemyTank.getY()+60
                ){
                    shot.isLive=false;//销毁子弹
                    enemyTank.isLive=false;//销毁坦克
                    enemyTanks.remove(enemyTank);//集合中删除对象
                    //创建bomb对象 放入bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);

                }
                break;
            case 2:
            case 3:
                //判断子弹是否击中
                if(shot.getX()>enemyTank.getX()&&shot.getX()<enemyTank.getX()+60 &&shot.getY()>enemyTank.getY()&&shot.getY()<enemyTank.getY()+40
                ){
                    shot.isLive=false;//销毁子弹
                    enemyTank.isLive=false;//销毁敌人坦克
                    enemyTanks.remove(enemyTank);//集合中删除对象
                    //创建bomb对象 放入bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }
    public void hitHeroTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出所有坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.enemyShots.size(); j++) {
                //取出所有敌人子弹
                Shot shot = enemyTank.enemyShots.get(j);
                if (hero.isLive&&shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }
    public void hitEnemyTank(){
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot= hero.shots.get(j);
            if (shot != null && shot.isLive){//子弹没有超出边界
                //遍历所有敌方坦克
                for (int i = 0; i <enemyTanks.size() ; i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //遍历shots判断是否有子弹击中
                    hitTank(shot,enemyTank);
                }
            }
        }
    }
    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向 0上 1下 2左 3右
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

        //根据坦克方向 绘制对应形状坦克
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
        if (e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }else if (e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirect(1);
            hero.moveDown();
        }else if (e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirect(2);
            hero.moveLeft();
        }else if (e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirect(3);
            hero.moveRight();
        }
        if (e.getKeyCode()==KeyEvent.VK_J){
            //System.out.println("开始射击");
            //判断主角坦克的子弹是否消亡 实现每次只能发射一颗子弹
//            if (hero.shot != null && hero.shot.isLive) {
//                return;
//            } else {
//                hero.fire();
//            }
            //因为我方坦克被击毁后 key-J还能发射子弹 所以需要进行判断
            if (hero.isLive){
                hero.fire();
            }

        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void run() {//每隔100毫秒 重绘
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //判断敌人坦克是否击中我们
            hitHeroTank();
            //判断子弹是否击中敌方坦克
            hitEnemyTank();
//            if (hero.shot != null && hero.shot.isLive){//子弹没有超出边界
//                //遍历所有敌方坦克
//                for (int i = 0; i <enemyTanks.size() ; i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    //遍历shots判断是否有子弹击中
//                    hitTank(hero.shot,enemyTank);
//                }
//            }
            //遍历shots子弹集合判断子弹是否击中敌方坦克


            this.repaint();
        }
    }
}
