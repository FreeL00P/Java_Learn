package Homework10;

public class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;
    //重邪父类equals方法
    @Override
    public boolean equals(Object obj){
        if (this==obj){//判断两个对象是否相同
            return true;
        }
        //判断obj是否为Doctor类型或子类
        if(!(obj instanceof  Doctor)){
            return false;

        }
        //向下转型
        Doctor doctor = (Doctor) obj;
        return this.name.equals(doctor.name)&&this.age==doctor.age
                &&this.gender==doctor.gender&&this.job.equals(doctor.job)
                &&this.sal==doctor.sal;
    }

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
