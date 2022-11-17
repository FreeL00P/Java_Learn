package tankegame05;

import java.io.Serializable;
import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 19:59    since 1.0.0      敌方坦克类
 */
public class EnemyTank extends Tank implements Runnable, Serializable {//实现Serializable接口 使其可序列化
    public boolean isLive = true;
    Shot shot = null;
    //在敌人坦克类中，使用vector 保存多个shot
    Vector<Shot> enemyShots = new Vector<>();
    //增加成员 EnemyTank可以得到敌人坦克的Vector
    //Vector<EnemyTank>
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //让敌人坦克能够随机移动
    //这里通过一个方法可以将MyPanel 成员Vector<EnemyTank> 设置到EnemyTank
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //判断当前坦克是否碰撞其他敌人坦克
    public boolean isTouchEnemyTank() {
        //判断自己的方向
        switch (this.getDirect()) {
            case 0://上
                //遍历敌人坦克集合
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //获取EnemyTank对象
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //跳过自己
                    if (this == enemyTank) {
                        continue;
                    }
                    //判断是否碰撞对方
                    //首先判断对方的方向 上和下
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 1) {
                        //当前坦克的左上角坐标 [this.getX(),this.getY()]  in EnemyTank的左上角坐标[]
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        //当前坦克的右上角坐标 [this.getX()+40,this.getY()] in EnemyTank的到范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    //判断敌人方向 左和右
                    if (enemyTank.getDirect() == 2 || enemyTank.getDirect() == 3) {
                        //当前坦克的左上角坐标 [this.getX(),this.getY()]  in EnemyTank的到范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        //当前坦克的左上角坐标 [this.getX()+40,this.getY()] not in EnemyTank的到范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 1://下
                //遍历敌人坦克集合
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //获取EnemyTank对象
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //跳过自己
                    if (this == enemyTank) {
                        continue;
                    }
                    //判断是否碰撞对方
                    //首先判断对方的方向 上和下
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 1) {
                        //当前坦克的左下角坐标 [this.getX(),this.getY()+60] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() + 60) {
                            return true;
                        }
                        //当前坦克的右上角坐标 [this.getX()+40,this.getY()+60] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY() +60<= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    //判断敌人方向 左和右
                    if (enemyTank.getDirect() == 2 || enemyTank.getDirect() == 3) {
                        //当前坦克的左下角坐标 [this.getX(),this.getY()+60]  in EnemyTank的到范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() + 40) {
                            return true;
                        }
                        //当前坦克的右下角坐标 [this.getX()+40,this.getY()+60]  in EnemyTank的到范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 2://左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //获取EnemyTank对象
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //跳过自己
                    if (this == enemyTank) {
                        continue;
                    }
                    //判断是否碰撞对方
                    //首先判断对方的方向 上和下
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 1) {
                        //当前坦克的 左上角 坐标 [this.getX(),this.getY()] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        //当前坦克的 左下角 坐标 [this.getX(),this.getY()+ 40 ]  in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY()+ 40>= enemyTank.getY()
                                && this.getY()+ 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    //判断敌人方向 左和右
                    if (enemyTank.getDirect() == 2 || enemyTank.getDirect() == 3) {
                        //当前坦克的 左下角 坐标 [this.getX(),this.getY()] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        //当前坦克的 左下角 坐标 [this.getX(),this.getY()+40]  in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX()  <= enemyTank.getX() + 60
                                && this.getY()+40>= enemyTank.getY()
                                && this.getY()+40<= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 3://右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //获取EnemyTank对象
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //跳过自己
                    if (this == enemyTank) {
                        continue;
                    }
                    //判断是否碰撞对方
                    //首先判断对方的方向 上和下
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 1) {
                        //当前坦克的 右上角 坐标 [this.getX()+60,this.getY()] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        //当前坦克的 右下角 坐标 [this.getX()+60,this.getY()+40]  in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY()+40>= enemyTank.getY()
                                && this.getY()+40<= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    //判断敌人方向 左和右
                    if (enemyTank.getDirect() == 2 || enemyTank.getDirect() == 3) {
                        //当前坦克的 右上角 坐标 [this.getX()+60,this.getY()] in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+60]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+40]
                        if (this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        //当前坦克的 右下角 坐标 [this.getX()+60,this.getY()+40]  in EnemyTank的范围
                        // x的范围应在[enemyTank.getX(),enemyTank.getX()+40]
                        // Y的范围应在[enemyTank.getY(),enemyTank.getY()+60]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY()+40>= enemyTank.getY()
                                && this.getY()+40<= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
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
                        if (getY()>0&&!isTouchEnemyTank()){
                            moveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:   for (int i = 0; i <30 ; i++) {
                    if (getY()<1000&&!isTouchEnemyTank()){
                        moveDown();
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    break;
                case 2:  for (int i = 0; i <30 ; i++) {
                    //如果敌方坦克超出边界或碰撞到其他敌方坦克则不能移动
                    if (getX()>750&&!isTouchEnemyTank()){
                        moveLeft();
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    break;
                case 3:   for (int i = 0; i <30 ; i++) {
                    if (getX()>750&&!isTouchEnemyTank()){
                        moveRight();
                    }

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
