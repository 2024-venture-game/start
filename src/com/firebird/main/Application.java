package com.firebird.main;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("******게임 시작******");
        System.out.println("1. 검사");
        System.out.println("2. 마법사");
        System.out.println("3. 궁수");
        System.out.println("4. 도적");
        System.out.println("선택할 캐릭터의 번호를 입력하세요: ");
        int num = sc.nextInt();

    }

}
