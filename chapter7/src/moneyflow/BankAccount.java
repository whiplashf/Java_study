package moneyflow;
import java.text.SimpleDateFormat;
import java.util.Date;

// 从零钱通继承来的银行存取款账户，功能很类似
public class BankAccount extends SmallChangeSys {
    private double money = 0;
    private double profitRate = 0.1;
    private int freeCount = 3;

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public void mainMenu() {
        while (flag) {
            this.printBankMenu();
            String choice;
            choice = sc.next();

            switch (choice) {
                case "1":
                    this.showAccount();
                    break;

                case "2":
                    this.deposit();
                    break;

                case "3":
                    this.withdraw();
                    break;

                case "4":
                    this.exitBank();
                    break;
                case "p":
                    this.nextMonth();
                    break;

                default:
                    System.out.println("非法输入");
            }
        }
    }

    public void printBankMenu() {
        System.out.println("-------------银行--------------");
        System.out.println("\t\t1 账户查询");
        System.out.println("\t\t2 存款");
        System.out.println("\t\t3 取款");
        System.out.println("\t\t4 退出");
        System.out.println("\t\tp 下一个月");
        System.out.print("请选择（1-4）：");
    }

    public void showAccount() {
        System.out.println("======账户交易记录======");
        for (int d = 0; d < detail.length; d++) {
            detail[d].showInfo();
        }
        System.out.println("查看账户成功！返回主界面");
    }

    public void deposit() {
        System.out.print("存入金额：");
        double num = sc.nextDouble();

        if (num <= 1) {
            System.out.println("存入金额需大于1美元！");
            return;
        }
        if (freeCount == 0) {
            System.out.println("本月免手续费操作次数已用完，将自动扣除手续费");
            money--;
        } else if (freeCount > 0) {
            freeCount--;
            System.out.println("本次操作免手续费，本月剩余免手续费操作次数：" + freeCount + "次");
        }
        money += num;
        date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化的对象
        DepositDetail depositDetail = new DepositDetail(sdf.format(date), num, money);
        detail = new Detail().AddDetail(detail, depositDetail); // 录入明细的方法

        System.out.println("存入成功！账户余额" + money + "美元");
    }

    public void withdraw() {

        System.out.print("请输入取款金额：");
        double num3 = sc.nextDouble();

        if (num3 <= 1) {
            System.out.println("取款金额需大于1美元！");
            return;
        }
        if (num3 > money - 1) {
            System.out.println("余额不足，取出金额应在1.0-" + (money - 1) + "美元");
            return;
        }
        if (freeCount == 0) {
            System.out.println("本月免手续费操作次数已用完，将自动扣除手续费");
            money--;
        } else if (freeCount > 0) {
            freeCount--;
            System.out.println("本次操作免手续费，本月剩余免手续费操作次数：" + freeCount + "次");
        }

        money -= num3;
        date = new Date();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化的对象
        WithdrawDetail withdrawDetail = new WithdrawDetail(sdf3.format(date), num3, money);
        detail = new Detail().AddDetail(detail, withdrawDetail); // 录入明细
        System.out.println("取款成功！账户余额" + money + "美元");
    }

    public void exitBank() {
        do {
            System.out.println("确认退出？（y/n）");
            char c = sc.next().charAt(0);
            if (c == 'y') {
                flag = false;
                System.out.println("银行账户已安全退出。");
                break;
            } else if (c == 'n') {
                System.out.println("继续运行！返回主界面");
                break;
            }
        } while (true);
    }

    public void nextMonth() {
        double profit = money * profitRate;
        money += profit;
        freeCount = 3;
        System.out.println("本月利息收入" + profit + "美元，账户余额" + money + "美元（本息），剩余免手续费操作次数：" + freeCount + "次");

        date = new Date();
        SimpleDateFormat sdfp = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化的对象
        MonthlyDetail monthlyDetail = new MonthlyDetail(sdfp.format(date), money);
        detail = new Detail().AddDetail(detail, monthlyDetail); // 录入明细
    }
}

class DepositDetail extends Detail {
    public DepositDetail(String time, double num, double remain) {
        super("存入", time, num, remain);
    }

    @Override
    public void showInfo() {
        double handFee = 1;
        System.out.println(getTime() + " 存入" + getNum() + "美元，扣除手续费" + handFee + "美元，账户余额" + getRemain() + "美元");
    }
}

class WithdrawDetail extends Detail {
    public WithdrawDetail(String time, double num, double remain) {
        super("取出", time, num, remain);
    }

    @Override
    public void showInfo() {
        double handFee = 1;
        System.out.println(getTime() + " 取出" + getNum() + "美元，扣除手续费" + handFee + "美元，账户余额" + getRemain() + "美元");
    }
}

class MonthlyDetail extends Detail {
    public MonthlyDetail(String time, double remain) {
        super("月利息", time, remain, remain);
    }

    @Override
    public void showInfo() {
        System.out.println(getTime() + "月利息到账，账户余额" + getRemain() + "美元");
    }
}