package Homework05;

public class Waiter extends Employee{
    public Waiter(String name, double sal) {
        super(name, sal);
    }
    @Override
    public void priSal() {
        System.out.println("服务生"+getName()+"全年工资为"+ getSal() *12);
    }
}
