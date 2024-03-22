package com.firebird.character;

import java.util.Scanner;

public class CharacterSelection {
        public CharacterSelection(int HP_C, int AD_C, int DF_C, int LV_C) {
        }

        public static character selectionChar() {
            Scanner sc = new Scanner(System.in);

            System.out.println("******************************");
            System.out.println("캐릭터를 선택하세요 : ");
            System.out.println("1. 검사");
            System.out.println("2. 마법사");
            System.out.println("3. 궁수");
            System.out.println("4. 도적");
            System.out.println("******************************");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    return new Warrior(90,20,10,1);

                case 2 :
                    return new Magician( 90,10,20,1);

                case 3:
                    return new Archer(80,10,15,1);

                case 4:
                    return new Bandit(100, 10,5,1);

                default:
                    System.out.println("잘못된 번호입니다. 다시 선택하세요!");
                    return selectionChar();
            }

        }
    }

