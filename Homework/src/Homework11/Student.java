package Homework11;

public class Student extends Person{
    @Override
    public void run(){
        System.out.println("student run");
    }
    @Override
    public void eat(){
        System.out.println("student eat");
    }
    public  void study(){
        System.out.println("student study");
    }
}
