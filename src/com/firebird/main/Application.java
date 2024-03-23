package com.firebird.main;

import com.firebird.monster.MonsterInfomation;
import com.firebird.monster.MonsterSkill;
import com.firebird.monster.SimpleMonsterType;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MonsterInfomation monsterInformation = new MonsterInfomation();
        // 몬스터와 스킬 정보 초기화
        monsterInformation.kindOfMonster();
        monsterInformation.kindOfSkill();

        // 스킬 정보 출력
        MonsterSkill[] skills = monsterInformation.getMonsterSkills();

        Random random = new Random();

        int i = random.nextInt(skills.length);
//        System.out.print("사용할 스킬 번호 입력 : ");
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
        if (skills[i] != null) {
            System.out.println(skills[i - 1].getSkillName() + "로 " + skills[i - 1].getSkillDamage() + "데미지를 주었습니다.");
        } else {
            System.out.println("스킬이 null입니다.");
        }

        SimpleMonsterType dragon = monsterInformation.getMonsterType()[0]; //드래곤 불러오기
        SimpleMonsterType oak = monsterInformation.getMonsterType()[1]; //오크 불러오기
        SimpleMonsterType wizard = monsterInformation.getMonsterType()[2]; //마법사 불러오기

        if (dragon.getHP_M() <= 0) {
            System.out.println(dragon.getName_M() + "을(를) 처치했습니다! " + dragon.getCoin() + "코인을 획득하였습니다.");
        } else {
            System.out.println(dragon.getName_M() + "의 남은 체력: " + dragon.getHP_M());
        }
    }
}
