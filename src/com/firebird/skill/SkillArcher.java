package com.firebird.skill;

import java.util.Scanner;

public class SkillArcher {

    /* [캐릭터3] 궁수(중성) - 화살
        기본 화살 : -10
        연속 화살 : -15
        불 화살 : -25

    * */

    private CharacterSkill[] characterSkills = new CharacterSkill[3];

    public SkillArcher(){
        kindOfCharacterSkill(); //
    }

    public void kindOfCharacterSkill(){
        characterSkills[0] = new CharacterSkill("기본 화살", -10);
        characterSkills[1] = new CharacterSkill("연속 화살", -15);
        characterSkills[2] = new CharacterSkill(" 불 화살", -25);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }

    //공격 메소드
    public void attack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 궁수의 스킬 =====");
        System.out.println("1. 기본 화살 공격");
        System.out.println("2. 연속 화살 공격");
        System.out.println("3. 불 화살 공격");
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
