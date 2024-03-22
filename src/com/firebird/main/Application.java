package com.firebird.main;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameStart = false;

        while (!gameStart) {
            System.out.println("******게임 시작******");
            System.out.println("1. 검사");
            System.out.println("2. 마법사");
            System.out.println("3. 궁수");
            System.out.println("4. 도적");
            System.out.println("선택할 캐릭터의 번호를 입력하세요: ");
            int num = scanner.nextInt();

            String characterName = "";

            switch (num) {
                case 1:
                    characterName = "검사";
                    break;
                case 2:
                    characterName = "마법사";
                    break;
                case 3:
                    characterName = "궁수";
                    break;
                case 4:
                    characterName = "도적";
                    break;
                default:
                    System.out.println("다시 숫자를 입력해주십시오.");
                    continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
            }

            System.out.println(characterName + "가 선택되었습니다.");
            System.out.println("정말 이 캐릭터로 선택하시겠습니까?");
            System.out.println("1. 예");
            System.out.println("2. 아니오");
            int num2 = scanner.nextInt();

            if (num2 == 1) {
                System.out.println("게임을 시작합니다.");

                System.out.println("전투를 시작합니다.");

                while (true) {
                    System.out.println("전투를 진행하셨나요? (y/n)");
                    String answer = scanner.next();

                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Game over!");
                        System.out.println("게임을 종료합니다.");
                        break;
                    } else if (answer.equalsIgnoreCase("n")) {
                        System.out.println("Clear!");
                        boolean moveOn = askMoveOn(scanner);

                        if (!moveOn) {
                            System.out.println("게임 끝!");
                            break;
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    }
                }

                gameStart = true; // 게임 시작
            } else if (num2 == 2) {
                System.out.println("캐릭터를 다시 선택해주십시오.");
            } else {
                System.out.println("다시 숫자를 입력해주십시오.");
            }
        }

        scanner.close();
    }

    private static boolean askMoveOn(Scanner scanner) {
        System.out.println("다음 단계로 이동하시겠습니까? (y/n)");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("y")) {
            startBattle();
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("게임 포기하시겠습니까? (y/n)");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("게임 종료!");
                return false;
            } else if (answer.equalsIgnoreCase("n")) {
                return askMoveOn(scanner);
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                return askMoveOn(scanner);
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            return askMoveOn(scanner);
        }
    }

    private static void startBattle() {
        System.out.println("전투를 시작합니다.");
    }
}