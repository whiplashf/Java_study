package moneyflow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 第一个小项目，零钱通系统
public class SmallChangeSys {

    Scanner sc = new Scanner(System.in);
    Date date = null; // 声明一个Date类型的对象
    double money = 0;
    boolean flag = true;
    Detail detail[] = {};
    int index = 0; // 明细条数


    public void mainMenu() {

        while (flag) {
            this.printMenu();
            String choice;
            choice = sc.next();

            switch (choice) {
                case "1":
                    this.showMenu();
                    break;

                case "2":
                    this.income();
                    break;

                case "3":
                    this.spend();
                    break;

                case "4":
                    this.exit();
                    break;

                default:
                    System.out.println("非法输入");
            }
        }
    }

    public void printMenu() {
        System.out.println("-------------零钱通--------------");
        System.out.println("\t\t1 零钱通明细");
        System.out.println("\t\t2 收益入账");
        System.out.println("\t\t3 消费");
        System.out.println("\t\t4 退出");
        System.out.print("请选择（1-4）：");
    }

    public void showMenu() {
        System.out.println("======明细======");
        for (int d = 0; d < detail.length; d++) {
            detail[d].showInfo();
        }
        System.out.println("查看明细成功！返回主界面");
    }

    public void income() {
        System.out.print("请输入入账金额：");
        double num = sc.nextDouble();
        if (num <= 0) {
            System.out.println("入账金额需大于0！");
            return;
        }
        money += num;
        date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化的对象
        Detail_in detail_in = new Detail_in(sdf.format(date), num, money); // 格式化后的时间为String类型
        detail = new Detail().AddDetail(detail, detail_in); // 录入明细的方法

        System.out.println("入账成功！返回主界面");
    }

    public void spend() {
        System.out.print("请输入消费场所：");
        String location = sc.next();
        System.out.print("请输入消费金额：");
        double num3 = sc.nextDouble();

        if (num3 < 0) {
            System.out.println("消费金额需大于等于0！");
            return;
        }
        if (num3 > money) {
            System.out.println("余额不足，消费金额应在0.0-" + money);
            return;
        }

        money -= num3;
        date = new Date();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化的对象
        Detail_out detail_out = new Detail_out(location, sdf3.format(date), num3, money); // 生成本条明细的对象
        detail = new Detail().AddDetail(detail, detail_out); // 录入明细
        System.out.println("支付成功！返回主界面");
    }

    public void exit() {
        do {
            System.out.println("确认退出？（y/n）");
            char c = sc.next().charAt(0);
            if (c == 'y') {
                flag = false;
                System.out.println("零钱通已安全退出。");
                break;
            } else if (c == 'n') {
                System.out.println("零钱通继续运行！返回主界面");
                break;
            }
        } while (true);
    }
}

class Detail {  // 明细对象的父类
    private String name;
    private String time;
    private double num;
    private double remain;

    public Detail(String name, String time, double num, double remain) {
        this.name = name;
        this.time = time;
        this.num = num;
        this.remain = remain;
    }

    public Detail() {
    }

    public Detail[] AddDetail(Detail[] D, Detail d) {
        Detail detail_temp[] = new Detail[D.length + 1];
        for (int i = 0; i < D.length; i++) {
            detail_temp[i] = D[i];
        }
        detail_temp[D.length] = d;
        return detail_temp;
    }

    public void showInfo() {
        System.out.println(name + "  " + num + "  " + time + "\t余额：" + remain);
    }

    public String getName() {
        return name;
    }

    public double getNum() {
        return num;
    }

    public double getRemain() {
        return remain;
    }

    public String getTime() {
        return time;
    }
}

class Detail_in extends Detail {

    public Detail_in(String time, double num, double remain) {
        super("收益入账", time, num, remain);
    }

    public void showInfo() {
        System.out.println(getName() + "  +" + getNum() + "  " + getTime() + "\t余额：" + getRemain());
    }
}

class Detail_out extends Detail {
    public Detail_out(String name, String time, double num, double remain) {
        super(name, time, -num, remain);
    }
}



