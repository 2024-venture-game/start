package com.firebird.skill;

import java.util.Scanner;

public class SkillBandit {

    /*[캐릭터4] 도적(동물) - 총
        총 : -10
        수류탄 : -15
        창 : -15

    **/

    private CharacterSkill[] characterSkills = new CharacterSkill[3];

    public SkillBandit(){
        kindOfCharacterSkill(); //
    }

    public void kindOfCharacterSkill(){
        characterSkills[0] = new CharacterSkill(" 총 ", -10);
        characterSkills[1] = new CharacterSkill("수류탄", -15);
        characterSkills[2] = new CharacterSkill(" 창 ", -15);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }

    //공격 메소드
    public void attack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 도적의 스킬 =====");
        System.out.println("1. 총 공격");
        System.out.println("2. 수류탄 공격");
        System.out.println("3. 창 공격");
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
