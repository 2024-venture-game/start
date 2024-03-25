package com.firebird.main;

import java.util.Random;
import java.util.Scanner;

//import com.firebird.character.Archer;
//import com.firebird.character.Bandit;
//import com.firebird.character.Magician;
//import com.firebird.character.Warrior;

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
            System.out.print("선택할 캐릭터의 번호를 입력하세요: ");
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

            /* 캐릭터 설명 불러오기 */
            switch (num) {
                case 1:
                    // 검사의 설명을 불러오기
//                    Warrior warrior = new Warrior(100, 50, 20, 1); // 예시 값
//                    warrior.introduce();
                    break;
                case 2:
                    // 마법사의 설명을 불러오기
//                    Magician magician = new Magician(100, 50, 20, 1); // 예시 값
//                    magician.introduce();
                    break;
                case 3:
                    // 궁수의 설명을 불러오기
//                    Archer archer = new Archer(100, 50, 20, 1); // 예시 값
//                    archer.introduce();
                    break;
                case 4:
                    // 도적의 설명을 불러오기
//                    Bandit bandit = new Bandit(100, 50, 20, 1); // 예시 값
//                    bandit.introduce();
                    break;
                default:
                    break;
            }

            if (num2 == 1) {
                System.out.println("게임을 시작합니다.");
                gameStart = true; // 게임 시작


                /* 몬스터 설명 불러오기 */

                System.out.println("전투를 시작합니다.");

                Random rand = new Random();
                int monsterHP = rand.nextInt(100) + 1; // 몬스터의 체력을 랜덤으로 설정
                int playerHP = 100; // 플레이어의 체력 초기화

                while (true) {
                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1. 스킬 1");
                    System.out.println("2. 스킬 2");
                    System.out.println("3. 스킬 3");
                    int skillNum = scanner.nextInt();

                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = 20; // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = 30; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = 40; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

                    monsterHP -= damageDealt; // 몬스터의 체력 감소

                    if (monsterHP <= 0) {
                        System.out.println("몬스터를 물리쳤습니다. 게임을 종료합니다.");
                        break;
                    }

                    // 몬스터의 공격
                    int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
                    playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (playerHP <= 0) {
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        break;
                    }

                    System.out.println("플레이어 HP: " + playerHP);
                    System.out.println("몬스터 HP: " + monsterHP);
                }
            } else if (num ==2) {
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