package TestFromStringBuffer;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String name="蔡徐坤";
        String password="123456";
        String email="10977@gmailcom";
        try{zc(name,password,email);}catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void zc(String name,String password,String email) {

        if (name.length()<2||name.length()>4){
            throw new RuntimeException("姓名格式错误");
        }
        if (password.length()!=6&&isDigital(password)==true){
            throw new RuntimeException("密码格式错误");
        }
        int m=email.indexOf('@');
        int n=email.indexOf('.');
        if (!(m>0&&n>m)){
           throw new RuntimeException("邮箱格式错误");
        }
        System.out.println("注册成功");
    }
    public static boolean isDigital(String str){
        char[] chars=str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]>'9'||chars[i]<'0'){
                return false;
            }
        }
        return true;
    }
}
