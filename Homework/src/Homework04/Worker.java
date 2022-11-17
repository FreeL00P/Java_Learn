package Homework04;

public class Worker extends Employee{
    //获取父类信息
    public Worker(String name, double money, int workDay, double grade) {
        super(name, money, workDay, grade);
    }

    @Override
    public void printSal() {
        super.printSal();
    }
}
