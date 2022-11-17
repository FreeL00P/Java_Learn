package Homework05;

public class Worker extends Employee{
    public Worker(String name,double sal){
        super(name,sal);
    }

    @Override
    public void priSal() {
        System.out.println("工人"+getName()+"全年工资为"+ getSal() *12);
    }
}
