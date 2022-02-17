package basic;

import java.util.Scanner;

public class ProcessControlTest {
    // if-else结构
    public static void rewardJudge() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入分数：");
        double score = sc.nextDouble();
        if (score >= 80) {
            System.out.println("奖励一台iPhone X");
        } else if (score < 80 & score >= 60) {
            System.out.println("奖励一辆自行车");
        } else {
            System.out.println("奖励一个大嘴巴子");
        }
    }

    // switch-case结构
    public static void huluwaColorJudeg() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的娃号：");
        int number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("你是大力娃，你是红色");
                break;
            case 2:
                System.out.println("你是千里眼顺风耳娃，你是菊色");
                break;
            case 3:
                System.out.println("你是金刚娃，你是黄色");
                break;
            case 4:
                System.out.println("你是水娃，你是青色");
                break;
            case 5:
                System.out.println("你是火娃，你是绿色");
                break;
            case 6:
                System.out.println("你是隐身娃，你是蓝色");
                break;
            case 7:
                System.out.println("你是宝葫娃，你是紫色");
                break;
            default:
                System.out.println("你什么娃都不是");
        }
    }

    // for结构(99乘法表)
    public static void multiplicationTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // while结构(打印质数)
    public static void whileTest() {
        int stopFlag = 1000;
        int printNum = 1;
        System.out.print(stopFlag + "以内的质数有：");
        while (printNum <= stopFlag) {
            boolean isZhiShu = true;
            for (int i = 2; i < printNum; i++) {
                if (printNum % i == 0) {
                    isZhiShu = false;
                    break;
                }
            }
            if (isZhiShu) {
                System.out.print(printNum + "\t");
            }
            printNum++;
        }
    }

    public static void dowhileTest() {
        int stopFlag = 10;
        int printNum = 0;
        do {
            System.out.print(printNum++ + "\t");
        } while (printNum <= stopFlag);
    }

    public static void main(String[] args) {
//        huluwaColorJudeg();
//        rewardJudge();
//        multiplicationTable();
        whileTest();
//        dowhileTest();
    }
}
