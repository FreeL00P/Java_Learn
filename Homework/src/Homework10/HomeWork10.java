package Homework10;

public class HomeWork10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("jack", 20, "ya", '男',2000);
        Doctor doctor1 = new Doctor("jack", 20, "ya", '男',2000);
        System.out.println(doctor.equals(doctor1));
    }
}
