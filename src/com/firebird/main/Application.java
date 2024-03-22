package com.firebird.main;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        Character ch = new Character();

        System.out.println("******게임 시작******");
        System.out.println("1. 검사");
        System.out.println("2. 마법사");
        System.out.println("3. 궁수");
        System.out.println("4. 도적");
        System.out.println("선택할 캐릭터의 번호를 입력하세요: ");
        int num = sc.nextInt();

        if(num == 1) {

            System.out.println("검사가 선택되었습니다.");

        } else if(num == 2) {

            System.out.println("마법사가 선택되었습니다.");

        } else if(num == 3) {

            System.out.println("궁수가 선택되었습니다.");

        } else if(num == 4) {

            System.out.println("도적이 선택되었습니다.");

        } else {

            System.out.println("다시 선택해주십시오.");

        }

        System.out.println("정말 이 캐릭터로 선택하시겠습니까?");

    }

}
