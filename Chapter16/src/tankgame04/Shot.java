package tankgame04;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/16 12:27    since 1.0.0      子弹
 */
public class Shot implements Runnable{
    private int x;
    private int y;
    private int direct;
    private int speed=5;
    public boolean isLive=true;
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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     *
     * @param x 子弹发射位置横坐标
     * @param y 子弹发射位置纵坐标
     * @param direct 子弹发射方向
     */
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;

    }

    @Override
    public synchronized void run() {
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0: y-=speed;
                    break;
                case 1: y+=speed;
                    break;
                case 2: x-=speed;
                    break;
                case 3: x+=speed;
                    break;
            }
            // System.out.println("子弹坐标"+x+" "+y);
            //当子弹触碰到边界时 销毁线程
            if (!(x>=0&&x<=1000&&y>=0&&y<=750&&isLive)){
                System.out.println("子弹线程退出");
                isLive=false;
                break;
            }

        }
    }

}
