package com.firebird.main;

import com.firebird.character.Character;
import com.firebird.monster.MonsterDragon;

public class Application {
    public static void main(String[] args) {
        // 캐릭터와 몬스터 드래곤 생성
        Character hero = new Character(1000, 200, 50, 1);
        MonsterDragon dragon = new MonsterDragon(1200, 150, 30, 1);

        // 전투 시작
        System.out.println("전투가 시작되었습니다!");

        // 간단한 전투 로직: 한 쪽의 체력이 0 이하가 될 때까지 계속
        while (hero.HP_C > 0 && dragon.HP_M > 0) {
            hero.attack(dragon); // 캐릭터가 드래곤을 공격
            printStatus(hero, dragon); // 현재 상태 출력

            if (dragon.HP_M <= 0) {
                System.out.println("드래곤이 쓰러졌습니다. 캐릭터가 승리했습니다!");
                break;
            }

            dragon.attack(hero); // 드래곤이 캐릭터를 공격
            printStatus(hero, dragon); // 현재 상태 출력

            if (hero.HP_C <= 0) {
                System.out.println("캐릭터가 쓰러졌습니다. 드래곤이 승리했습니다!");
                break;
            }
        }
    }

    // 캐릭터와 드래곤의 현재 상태를 출력하는 메소드
    private static void printStatus(Character hero, MonsterDragon dragon) {
        System.out.println("====== 현재 상태 ======");
        System.out.println("캐릭터 HP: " + hero.HP_C);
        System.out.println("드래곤 HP: " + dragon.HP_M);
        System.out.println("====================");
    }
}
