package Homework05;

public class Peasant extends Employee{
    public Peasant(String name, double sal) {
        super(name, sal);
    }
    @Override
    public void priSal() {
        System.out.println("农民"+getName()+"全年工资为"+ getSal() *12);
    }
}
