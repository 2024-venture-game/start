package com.firebird.main;

import com.firebird.monster.MonsterInfomation;
import com.firebird.monster.MonsterSkill;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MonsterInfomation monsterInformation = new MonsterInfomation();
        // 몬스터와 스킬 정보 초기화
        monsterInformation.kindOfMonster();
        monsterInformation.kindOfSkill();

        // 스킬 정보 출력
        MonsterSkill[] skills = monsterInformation.getMonsterSkills();
        System.out.print("사용할 스킬 번호 입력 : ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (skills[i] != null) {
            System.out.println(skills[i - 1].getSkillName() + "로 " + skills[i - 1].getSkillDamage() + "데미지를 주었습니다.");
        } else {
            System.out.println("스킬이 null입니다.");
        }
    }
}
