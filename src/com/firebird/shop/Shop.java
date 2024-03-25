package com.firebird.shop;

import java.util.Scanner;

public class Shop {

    private int coins;

    public Shop(int coins) {
        this.coins = coins;
    }

    public void itemSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ 상점 ===========");
        System.out.println("상점에 오신 걸 환영합니다! ✧⁺⸜(  •⌄•  )⸝⁺✧");
        System.out.println("============ 아이템 목록 ===========");

        String[] items = {"물약", "갑옷", "독화살", "엑스칼리버", "묠니르", "딱총나무 지팡이"};
        int[] prices = {50,20,30,30,30,30};

        for (int i = 0; i < items.length; i++) {
            System.out.println((i+1) + "." + items[i] + " : " + prices[i] + "coins");

        }

        System.out.println("구매할 아이템 번호를 선택하세요.");
        int itemNum = sc.nextInt();
        buyItem(itemNum);
    }

    public void buyItem(int itemNum) {

        switch (itemNum) {

            case 1 :
                System.out.println("물약 : HP 회복");
                break;
            case 2:
                System.out.println("갑옷 : 방어력 증가");
                break;
            case 3 :
                System.out.println("독화살 : 궁수의 공격력 증가");
                break;
            case 4:
                System.out.println("엑스칼리버 : 검사의 공격력 증가");
                break;
            case 5 :
                System.out.println("묠니르 : 도적의 공격력 증가");
                break;
            case 6 :
                System.out.println("딱총나무 지팡이 : 마법사 공격력 증가");
                break;
            default:
                System.out.println("잘못된 번호입니다!");

        }
    }

}
