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


}
