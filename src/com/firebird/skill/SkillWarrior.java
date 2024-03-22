package com.firebird.skill;

import com.firebird.monster.MonsterDragon;

import java.util.Scanner;

public class SkillWarrior {

    /*[캐릭터1] 검사(남자) - 검(칼)
        목검 : -10
        장검 : -15
        광선검 : -20
     */

    private CharacterSkill[] characterSkills = new CharacterSkill[3];

    public SkillWarrior(){
        kindOfCharacterSkill(); //
    }
    public void kindOfCharacterSkill(){
        characterSkills[0] = new CharacterSkill("목검", -10);
        characterSkills[1] = new CharacterSkill("장검", -15);
        characterSkills[2] = new CharacterSkill("광선검", -20);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }

    //공격 메소드
    public void attack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 검사의 스킬 =====");
        System.out.println("1. 목검 공격");
        System.out.println("2. 장검 공격");
        System.out.println("3. 광선검 공격");
        System.out.print("사용할 공격 번호를 입력하세요 : ");
        int num = sc.nextInt();

        if(num == 1) {
            //hp = hp - characterSkills[0].skill_damage_C;

        } else if(num == 2) {
            //hp = hp - characterSkills[1].skill_damage_C;

        }else if(num == 3) {
            //hp = hp - characterSkills[2].skill_damage_C;

        }
    }


}
