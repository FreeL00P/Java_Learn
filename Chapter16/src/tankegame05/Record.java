package tankegame05;

import java.io.*;
import java.util.Vector;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/21 12:31    since 1.0.0
 * 用于记录成绩
 */
public class Record {
    private static String filePath="D:\\Java\\Chapter16\\src\\tankegame05\\score.txt";//成绩记录地址
    private static String filePath1="D:\\Java\\Chapter16\\src\\tankegame05\\enemyTankLocation.txt";
    private static BufferedWriter bw=null;
    private static FileReader fr=null;
    private static FileWriter fw=null;
    private static BufferedReader br=null;
    private static int wreckEnemyTankNum=0;//击毁敌人坦克的数量
    //定义一个vector 将MyPanel的EnemyTank集合放入到本类
    private static Vector<EnemyTank> enemyTanks=null;
    //private static ObjectOutputStream oos=null;
    //定义一个Node的Vector 用于保存敌人信息·
    private static Vector<Node> nodes=new Vector<>();
    public static int getWreckEnemyTankNum() {
        return wreckEnemyTankNum;
    }
    public static void setWreckEnemyTankNum(int wreckEnemyTankNum) {
        Record.wreckEnemyTankNum = wreckEnemyTankNum;
    }
    public static void SetEnemyTanks(Vector<EnemyTank> enemyTanks){
        Record.enemyTanks=enemyTanks;
    }
    public static void addWreckEnemyTankNum(){
        wreckEnemyTankNum++;
    }
    //记录成绩（一共击毁了多少敌方坦克）
    //保存当前敌人坦克位置
    public static void recordScore(){
        try {
            bw = new BufferedWriter(fw=new FileWriter(filePath));
            bw.write(wreckEnemyTankNum+"\r\n");
            //获取当前所有敌人坦克位置
            for (int i = 0; i < enemyTanks.size(); i++) {
                //获取一个EnemyTank对象
                EnemyTank enemyTank=enemyTanks.get(i);
                if (enemyTank.isLive){//判断是否存活
                    String record=enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect()+"\n";
                    bw.write(record);//写入到文件
                    //oos.writeObject(enemyTank);//写入对象
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bw!=null) {
                    bw.close();
                }
                /* if (oos!=null){
                    oos.close();
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读取历史击毁数量
    public static int recordNum() throws IOException {
        BufferedReader br = new BufferedReader(fr=new FileReader(filePath));
        wreckEnemyTankNum= Integer.parseInt(br.readLine());
        return wreckEnemyTankNum;
    }
    //这里通过一个方法可以将MyPanel 成员Vector<EnemyTank> 设置到EnemyTank
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
    //读取文件 恢复相关信息
    public static Vector<Node> getInfo(){
        try {
            br=new BufferedReader(new FileReader(filePath));
            wreckEnemyTankNum= Integer.parseInt(br.readLine());//读取击毁敌人坦克数量信息
            String readLen="";
            while ((readLen= br.readLine())!=null){
                String[] info=readLen.split(" ");//分隔信息 X Y 方向
                //新建一个node
                Node node= new Node(Integer.parseInt(info[0]),Integer.parseInt(info[1]),Integer.parseInt(info[2]));
                nodes.add(node);//加入vector集合
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }



}
