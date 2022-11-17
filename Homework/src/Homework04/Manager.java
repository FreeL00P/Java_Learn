package Homework04;

public class Manager extends Employee{
    private double bonus;//特有属性 奖金

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    //构造方法 获取父类的信息
    public Manager(String name, double money, int workDay, double grade){
        super(name,money,workDay,grade);
    }
    @Override
    public void printSal() {
        System.out.println("经理"+getName()+"工资"+(getBonus()+getMoney()*getWorkDay()*getGrade()));
    }
}
