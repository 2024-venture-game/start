package com.firebird.main;

import com.firebird.monster.MonsterInfomation;
import com.firebird.monster.MonsterSkill;
import com.firebird.monster.SimpleMonsterType;

public class Application {
    public static void main(String[] args) {

        MonsterInfomation MI = new MonsterInfomation();
        SimpleMonsterType SM = new SimpleMonsterType();

        MonsterSkill[] skills = MI.getMonsterSkills();

        if (skills.length > 0) {
            System.out.println(1000 - skills[1].getSkillDamage());
        }
    }
}
