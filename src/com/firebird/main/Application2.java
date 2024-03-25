package com.firebird.main;

import com.firebird.skill.*;

public class Application2 {     //========================캐릭터별 스킬 종류 출력 테스트용
    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);

        /*========== 전사의 스킬 ==========*/
        // SkillWarrior 객체 생성
        SkillWarrior warrior = new SkillWarrior();
        warrior.kindOfCharacterSkill(); // 캐릭터 스킬 설정

        // 스킬 정보 출력
        CharacterSkill[] skills1 = warrior.getCharacterSkills();
        System.out.println("===== 검사의 스킬 =====");
//        for (CharacterSkill skill : skills1) {
//            System.out.print("스킬이름 : " + skill.getSkill_name_C() + "\tdamage: " + skill.getSkill_damage_C());
//            System.out.println();
//        }
        for (int i = 0; i < skills1.length; i++) {
            System.out.println((i + 1) + ". 스킬 이름 : " + skills1[i].getSkill_name_C() + "\tdamage: " + skills1[i].getSkill_damage_C());

        }

//        System.out.print("사용할 스킬을 선택해주세요. : ");
//        int num = sc.nextInt();


        /*========== 마법사의 스킬 ==========*/
        SkillMagician magician = new SkillMagician();
        magician.kindOfCharacterSkill();

        CharacterSkill[] skills2 = magician.getCharacterSkills();
        System.out.println("===== 마법사의 스킬 =====");
        for (int i = 0; i < skills2.length; i++) {
            System.out.println((i + 1) + ". 스킬 이름 : " + skills2[i].getSkill_name_C() + "\tdamage: " + skills2[i].getSkill_damage_C());

        }

        /*========== 궁수의 스킬 ==========*/
        SkillArcher archer = new SkillArcher();
        archer.kindOfCharacterSkill();

        CharacterSkill[] skills3 = archer.getCharacterSkills();
        System.out.println("===== 궁수의 스킬 =====");
        for (int i = 0; i < skills3.length; i++) {
            System.out.println((i + 1) + ". 스킬 이름 : " + skills3[i].getSkill_name_C() + "\tdamage: " + skills3[i].getSkill_damage_C());

        }

        /*========== 도적의 스킬 ==========*/
        SkillBandit bandit = new SkillBandit();
        bandit.kindOfCharacterSkill();

        CharacterSkill[] skills4 = bandit.getCharacterSkills();
        System.out.println("===== 도적의 스킬 =====");
        for (int i = 0; i < skills4.length; i++) {
            System.out.println((i + 1) + ". 스킬 이름 : " + skills4[i].getSkill_name_C() + "\tdamage: " + skills4[i].getSkill_damage_C());

        }

    }
}
