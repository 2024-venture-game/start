package com.firebird.skill;

// import com.firebird.monster.MonsterDragon;

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
        characterSkills[0] = new CharacterSkill("목검⚔️", -10);
        characterSkills[1] = new CharacterSkill("장검🤺", -15);
        characterSkills[2] = new CharacterSkill("광선검⚡", -1000);

    }

    public CharacterSkill[] getCharacterSkills() {
        return characterSkills;
    }


}
