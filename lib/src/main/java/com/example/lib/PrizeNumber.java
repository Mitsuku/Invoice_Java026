package com.example.lib;

import java.util.Scanner;

public class PrizeNumber {
    private String BonusNumber[];
    private Scanner scanner = new Scanner(System.in);
    private String JudgeNumber = "";
    private static final int OneThousandW = 0;
    private static final int TwoHundredW = 1;
    private static final int TwentyW1 = 2;
    private static final int TwentyW2 = 3;
    private static final int TwentyW3 = 4;
    private static final int TwoHundred1 = 5;
    private static final int TwoHundred2 = 6;

    public PrizeNumber(String address) {
        ReadTxt readTxt = new ReadTxt(address);
        this.BonusNumber = readTxt.getInvoiceNumber();
    }

    public void Judge() {
        System.out.println("Enter invoice:");
        JudgeNumber = scanner.next();
        while (JudgeNumber.length() != 8) {
            System.out.println("error");
            JudgeNumber = scanner.next();
        }
        if (JudgeNumber.matches(BonusNumber[OneThousandW])) {
            System.out.println("You get 1000W");
        } else if (JudgeNumber.matches(BonusNumber[TwoHundredW])) {
            System.out.println("You get 200W");
        } else {
            if(!TwoHundred_Judge() && !TwentyW_Judge()){
                System.out.println("0");
            }
        }
    }

    private boolean TwentyW_Judge() {
        boolean getprize = false;
        for (int i = 0; i < 6; i++) {
            if (JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW1].substring(i, 8))
                    || JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW2].substring(i, 8))
                    || JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW3].substring(i, 8))) {
                switch (i) {
                    case 0:
                        System.out.println("You get 200000");
                        break;
                    case 1:
                        System.out.println("You get 100000");
                        break;
                    case 2:
                        System.out.println("You get 10000");
                        break;
                    case 3:
                        System.out.println("You get 4000");
                        break;
                    case 4:
                        System.out.println("You get 1000");
                        break;
                    case 5:
                        System.out.println("You get 200");
                        break;
                }
                getprize = true;
                break;
            } else {
                getprize = false;
            }
        }
        return getprize;
    }

    private boolean TwoHundred_Judge() {
        boolean getprize;
        String Last3 =JudgeNumber.substring(0, 8);
        if (Last3.matches(BonusNumber[TwoHundred1]) || Last3.matches(BonusNumber[TwoHundred2])) {
            System.out.println("You get 200");
            getprize = true;
        } else {
            getprize = false;
        }
        return getprize;
    }
}