package Homework04;

public class Employee {
    private String name;
    private double money;
    private double grade;
    private int workDay;

    public static void main(String[] args) {
        Manager manager = new Manager("刘邦", 100, 20, 1.2);
        //设置奖金
        manager.setBonus(3000);
        manager.printSal();
        Worker worker = new Worker("马宇",100,30,1);
        worker.printSal();
    }
    //构造方法 获取信息
    public Employee(String name, double money, int workDay, double grade) {
        this.name=name;
        this.money=money;
        this.workDay=workDay;
        this.grade=grade;
    }

    public void printSal(){
        System.out.println(name+"工资"+money*workDay*grade);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

}

