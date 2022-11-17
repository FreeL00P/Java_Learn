package HouseRentalSys.HouseView;
import HouseRentalSys.HouseDomain.House;
import HouseRentalSys.HouseService.HouseService;
import HouseUtility.HouseUtility;

import java.util.Scanner;
public class HouseView {
    Scanner scanner=new Scanner(System.in);
    boolean loop=true;
    char key;
    private HouseService houseService=new HouseService(10);//设置数组大小
    public void mainMenu(){
        do {
            System.out.println("----------房屋出租系统菜单----------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.println("请输入你的选择：");
            key = HouseUtility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    selHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入有误");

            }
        }while (loop);
    }
    //退出
    private void exit() {
        char c=HouseUtility.readConfirmSelection();
        if(c=='Y') loop=false;
    }

    // 显示房屋列表
    public void  listHouses(){
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses=houseService.list();//列出所有房屋信息
        for (int i = 0; i <houses.length ; i++) {
            if (houses[i]==null) break;
            System.out.println(houses[i]);
        }
        System.out.println("----------房屋列表显示完毕----------");
    }
    //添加房屋 把新的房屋对象添加到House[]
    public void addHouse(){
        System.out.println("----------添加房屋信息----------");
        System.out.print("姓名： ");
        String name=HouseUtility.readString(8);
        System.out.print("电话： ");
        String phone=HouseUtility.readString(12);
        System.out.print("地址: ");
        String address=HouseUtility.readString(16);
        System.out.print("月租： ");
        int rent=HouseUtility.readInt();
        System.out.print("状态: ");
        String state=HouseUtility.readString(3);
        //创建一个house对象 id是系统分配的
        House newHouse= new House(0,name,phone,address,rent,state);
        if(houseService.add(newHouse)){
            System.out.println("----------添加成功----------");
        }else{
            System.out.println("----------添加失败----------");
        }
    }
    //删除房屋信息
    public void delHouse(){
        System.out.println("----------删除房屋信息----------");
        System.out.println("输入待删除的房屋编号(-1退出):");
        int delId=HouseUtility.readInt();
        if (delId==-1){
            System.out.println("----------取消删除房屋信息----------");
            return;
        }
        char choice=HouseUtility.readConfirmSelection();
        if (choice=='Y'){
            if (houseService.del(delId)){
                System.out.println("----------删除房屋信息成功----------");
            }else {
                System.out.println("----------房间编号不存在----------");
            }
        }else{
            System.out.println("----------取消删除房屋信息----------");
        }
    }
    //查找
    public void selHouse(){
        System.out.println("----------查找房屋信息----------");
        System.out.println("输入查找的房屋编号(-1退出):");
        int selId=HouseUtility.readInt();
        if (selId==-1){
            System.out.println("----------取消查找房屋信息----------");
            return;
        }
        //调用方法
       House house= houseService.sel(selId);
       if (house!=null){
           System.out.println(house);
       }else {
           System.out.println("----------该id没有对应信息----------");
       }
    }
    //修改
    public void updHouse(){
        System.out.println("----------更新房屋信息----------");
        System.out.println("输入更新的房屋编号(-1退出):");
        int updId=HouseUtility.readInt();
        if (updId==-1){
            System.out.println("----------取消更新房屋信息----------");
            return;
        }
        House house= houseService.sel(updId);//获取当前对象
        if (house==null){
            System.out.println("----------该id没有对应信息----------");
            return;
        }
        System.out.println("姓名("+house.getName()+"): ");
        String newName=HouseUtility.readString(8,"");//直接回车表示不修改该信息
        if (!"".equals(newName)){//不为空  则修改
            house.setName(newName);
        }
        System.out.println("电话("+house.getPhone()+"): ");
        String newPhone=HouseUtility.readString(12,"");//直接回车表示不修改该信息
        if (!"".equals(newPhone)){//不为空  则修改
            house.setPhone(newPhone);
        }
        System.out.println("地址("+house.getAddress()+"): ");
        String newAddress=HouseUtility.readString(18,"");//直接回车表示不修改该信息
        if (!"".equals(newAddress)){//不为空  则修改
            house.setAddress(newAddress);
        }
        System.out.println("租金("+house.getRent()+"): ");
        int newRent=HouseUtility.readInt(-1);//直接回车表示不修改该信息
        if (newRent!=-1){//不为空  则修改
            house.setRent(newRent);
        }
        System.out.println("状态("+house.getState()+"): ");
        String newState=HouseUtility.readString(3,"");//直接回车表示不修改该信息
        if (!"".equals(newState)){//不为空  则修改
            house.setState(    newState);
        }
        System.out.println("----------更新房屋信息成功----------");
    }
}
