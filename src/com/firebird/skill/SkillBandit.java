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
        characterSkills[0] = new CharacterSkill("총🔫", -10);
        characterSkills[1] = new CharacterSkill("수류탄💣", -15);
        characterSkills[2] = new CharacterSkill("창🔱", -25);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }

    
}
