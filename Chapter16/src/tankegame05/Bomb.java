package tankegame05;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/16 21:47    since 1.0.0      爆炸效果
 */
public class Bomb {
    private int x,y;//炸弹的坐标
    private int life=9;//生命周期
    boolean isLive=true;//是否存活

    public Bomb(int x, int y) {
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    //减少生命值
    public void lifeDown(){
        if (life>0){
            life--;
        }else {
            isLive=false;
        }
    }

}
