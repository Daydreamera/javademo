package basic;

import java.util.ArrayList;
import java.util.Scanner;

class Payment {
    String paymentDate;
    double paymentAmount;
    String name;
    String paymentDesc;
    int paymentType;

    public Payment(String paymentDate, double paymentAmount,  String paymentDesc,String name, int paymentType) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.name = name;
        this.paymentDesc = paymentDesc;
        this.paymentType = paymentType;
    }
}

public class FamilyAccount {
    static double account = 0;
    static ArrayList<Payment> payments = new ArrayList<Payment>();

    public static void index() {
        System.out.println("************** 家庭账户 ***************");
        System.out.println("*            1.账号余额               *");
        System.out.println("*            2.收支明细               *");
        System.out.println("*            3.新增记录               *");
        System.out.println("*            4.退出                  *");
        System.out.println("*************************************");
        System.out.println("************ 请选择<1-4> *************");
        Scanner sc = new Scanner(System.in);
        int functNum = sc.nextInt();

        switch (functNum) {
            case 1:
                accountShow();
                break;
            case 2:
                paymentDetail();
                break;
            case 3:
                addPaymentRecord();
                break;
            default:
                exit();
        }
    }

    public static void accountShow() {
        Scanner sc = new Scanner(System.in);
        for (Payment p : payments) {
            if (p.paymentType == 1) {
                account += p.paymentAmount;
            } else {
                account -= p.paymentAmount;
            }
        }
        System.out.println("*************************");
        System.out.println("   当前账户余额为：" + account);
        System.out.println("*************************");
        System.out.println("(1)返回上级");
        System.out.println("(2)退出系统");
        int choiceFlag = sc.nextInt();
        if (choiceFlag == 1) {
            index();
        } else {
            exit();
        }

    }

    public static void paymentDetail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|%-17s|", "交易时间");
        System.out.printf("%-8s|", "交易金额");
        System.out.printf("%-9s|", "交易说明");
        System.out.printf("%-9s|", "交易类别");
        System.out.printf("%-9s|\n", "用户");
        System.out.println("---------------------------------------------------------------------");
        for (Payment p : payments) {
            System.out.printf("|%-20s|", p.paymentDate);
            System.out.printf("%-10s|", p.paymentAmount);
            System.out.printf("%-10s|", p.paymentDesc);
            System.out.printf("%-10s|", (p.paymentType == 1 ? "收入" : "支出"));
            System.out.printf("%-10s|\n", p.name);
            System.out.println("---------------------------------------------------------------------");
        }
        System.out.println("(1)返回上级");
        System.out.println("(2)退出系统");
        int choiceFlag = sc.nextInt();
        if (choiceFlag == 1) {
            index();
        } else {
            exit();
        }

        System.out.println("当前账户余额：" + account);
    }

    public static void addPaymentRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入收支金额：");
        double paymentNum = sc.nextDouble();
        System.out.println();
        System.out.print("请输入收支描述：");
        String paymentDesc = sc.next();
        System.out.println();
        String recordTime = DateTools.getNow();
        System.out.println("请输入记录人：");
        String recordName = sc.next();
        System.out.println();
        System.out.println("请选择收支类别(1-收入  2-支出)：");
        int paymentType = sc.nextInt();
        payments.add(new Payment(recordTime, paymentNum, paymentDesc, recordName, paymentType));
        System.out.println("是否继续添加？(1-是  0-否)");
        int continueFlag = sc.nextInt();
        if (continueFlag == 1) {
            addPaymentRecord();
        } else {
            index();
        }
    }

    public static void exit() {
        System.exit(0);
    }


    public static void main(String[] args) {
        index();

    }
}
