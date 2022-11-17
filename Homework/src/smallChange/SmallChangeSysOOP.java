package smallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean loop=true;
    String key;
    Scanner scanner = new Scanner(System.in);
    String details="--------零钱通明细--------";
    double money=0;//收益
    double balance=0;//余额
    Date date=null;
    String note;
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化
    //主菜单
    public void mainMenu(){
        do{
            System.out.println("--------零钱通菜单--------");
            System.out.println("    1 零钱通明细");
            System.out.println("    2 收益入账");
            System.out.println("    3 消费");
            System.out.println("    4 退   出");
            System.out.println("请选择（1-4）");
            key=scanner.next();
            switch (key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                   this.pay();
                    break;
                case "4":
                   this.exit();
                   break;
                default:
                    System.out.println("输入有误");


            }
        }while (loop);
    }
    //明细
    public void detail(){
        System.out.println(details);
        return;
    }
    //收益入账
    public void income(){
        System.out.println("收益入账金额：");
        money=scanner.nextDouble();
        date=new Date();//获取当前日期
        if(money<=0){
            System.out.println("收益入账金额需要大于0");
            return;
        }

        balance+=money;//余额
        details+="\n收益入账\t"+money+"\t"+sdf.format(date)+"\t"+balance;
        // System.out.println(balance);
    }
    //消费
    public void pay(){
        System.out.println("收益消费金额：");
        money=scanner.nextDouble();
        if(money<=0||money>balance){
            System.out.println("消费金额应该在0-"+balance);
            return;
        }
        date=new Date();//获取当前日期
        System.out.println("消费说明");
        note=scanner.next();
        balance-=money;//余额
        details+="\n"+note+"\t"+money+"\t"+sdf.format(date)+"\t"+balance;
        System.out.println(balance);
    }
    //退出
    public void exit(){
        System.out.println("    4 退   出");
        String choice="";
        while (true){
            System.out.println("真的要退出吗 y/n");
            choice=scanner.next();
            if ("y".equals(choice)||"n".equals(choice )){
                break;
            }
        }
        if("y".equals(choice)){
            loop=false;
        }else if(choice.equals("n")){
            return;
        }
    }
}
