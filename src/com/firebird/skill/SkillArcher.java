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

    
}
