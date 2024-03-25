package com.firebird.skill;

import java.util.Scanner;

public class SkillMagician {

    /*[캐릭터2] 마법사(여자) - 마법
        얼음 마법 : -10
        번개 마법 : -15
        불 마법 : -20

    * */
    private CharacterSkill[] characterSkills = new CharacterSkill[3];

    public SkillMagician(){
        kindOfCharacterSkill(); //
    }

    public void kindOfCharacterSkill(){
        characterSkills[0] = new CharacterSkill("얼음 마법", -10);
        characterSkills[1] = new CharacterSkill("번개 마법", -15);
        characterSkills[2] = new CharacterSkill(" 불 마법", -20);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }

    //공격 메소드
    public void attack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 마법사의 스킬 =====");
        System.out.println("1. 얼음 마법 공격");
        System.out.println("2. 번개 마법 공격");
        System.out.println("3. 불 마법 공격");
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
