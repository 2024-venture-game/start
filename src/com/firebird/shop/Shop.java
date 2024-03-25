package com.firebird.shop;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Shop {

    private int coin;

    public Shop(int coin) {
        this.coin = coin;
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

        Scanner sc = new Scanner(System.in);

       String[] items = {"물약", "갑옷", "독화살","엑스칼리버","묠니르","딱총나무 지팡이"};
       String[] descriptions = {"HP 회복", "방어력 증가", "궁수의 공격력 증가", "검사의 공격력 증가","도적의 공격력 증가","마법사 공격력 증가"};

       int[] prices = {50,20,30,30,30,30};

       if (itemNum < 1 || itemNum > items.length) {
           System.out.println("잘못된 번호입니다. 다시 입력하세요! '◡'✿ ");
           return;
       }

       int price = prices[itemNum  -1];     //선택한 아이템 가격
       if (coin >= price) {
           System.out.println("선택하신 " + items[itemNum - 1] + "은(는)" + price + "coin 입니다. " );

           System.out.println("구매하시겠습니까? (Y/N)");
           String ans = sc.nextLine();
           if (ans.equalsIgnoreCase("Y")) {
               coin -= price;
               System.out.println("구매 완료! (*•̀ᴗ•́*)و 남은 코인 : " + coin);
           } else {
               System.out.println("구매 취소");
           }
       } else {
           System.out.println("코인 부족");
       }
    }
           }

