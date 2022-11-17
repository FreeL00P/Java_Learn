package tankgame04;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:22    since 1.0.0      坦克类
 */
public class Tank {
    public boolean isLive=true;
    private int x; //坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//表示坦克方向 上下左右 0123
    private int speed=1;//坦克的速度

    // 上下左右 移动方法
    public void moveUp(){
        if(!(y>=0)){//判断坦克是否超出画框 超出则无法继续移动
            return;
        }
        y-=speed;
    }
    public void moveDown(){
        if(!(y<=750-60)){//需要减去一个坦克的长度
            return;
        }
        y+=speed;
    }
    public void moveLeft(){
        if( !(x>=0)){
            return;
        }
        x-=speed;
    }
    public void moveRight(){
        if( !(x<=1000-60)){//需要减去一个坦克的长度
            return;
        }
        x+=speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
