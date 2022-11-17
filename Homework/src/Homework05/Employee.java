package Homework05;

public class Employee {
    private String name;
    private double sal; //月工资

    public static void main(String[] args) {
        Worker worker =new Worker("马云",2000);
        worker.priSal();//工人

        Peasant peasant=new Peasant("马云",8000);
        peasant.priSal();//农民

        Waiter waiter = new Waiter("马云", 2600);
        waiter.priSal();//服务员

        Teacher teacher = new Teacher("马云", 2600);
        teacher.setClassDay(70);
        teacher.setClassSal(200);
        teacher.priSal();

        Scientist scientist = new Scientist("马云",5000);
        scientist.setBonus(10000);
        scientist.priSal();



    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Employee(String name,double sal){
        this.name=name;
        this.sal=sal;
    }

    public void priSal(){
    }
}
