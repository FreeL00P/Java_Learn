package Homework05;

public class Scientist extends Employee{
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;
    public Scientist(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void priSal() {
        System.out.println("科学家"+getName()+"全年工资为"+((getSal()*12)+getBonus()));
    }
}
