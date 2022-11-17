package Homework05;

public class Teacher extends Employee{
    private int classDay;
    private double classSal;

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    public Teacher(String name, double sal) {
        super(name, sal);
    }
    @Override
    public void priSal() {
        System.out.println("教师"+getName()+"全年工资为"+((getSal()*12)+classDay*classSal));
    }
}
