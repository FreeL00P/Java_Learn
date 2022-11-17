public class Homework02 {
    public static void main(String[] args) {
        int f1=Frock.getNextNum();
        int f2=Frock.getNextNum();
        System.out.println(f1);
        System.out.println(f2);
        Frock frock1=new Frock();
        Frock frock2=new Frock();
        Frock frock3=new Frock();
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
        System.out.println(frock3.getSerialNumber());
    }
}
class Frock{
    private  static int currentNum=100000;
    private int serialNumber;
    public static int getNextNum() {
        currentNum+=100;
        return currentNum;
    }
    Frock() {
        serialNumber=getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}