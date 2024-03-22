package com.firebird.monster;

public class MonsterInfomation {

    private SimpleMonsterType[] MonsterType = new SimpleMonsterType[3];
    private MonsterSkill[] MS = new MonsterSkill[3];


    public void kindOfMonster(){
        MonsterType[0] = new SimpleMonsterType("드래곤", 1000, 200, 0, 100);
        MonsterType[1] = new SimpleMonsterType("오크", 500, 50, 0, 20);
        MonsterType[2] = new SimpleMonsterType("마법사", 100, 300, 0, 5);

    }

    public void kindOfSkill(){
        MS[0] = new MonsterSkill("스킬1", 100, 0);
        MS[1] = new MonsterSkill("스킬2", 200, 50);
        MS[2] = new MonsterSkill("스킬3", 300, 0);


//        //밑에 스킬 값이 null인지 확인하기 위한 for문
//        for (MonsterSkill skill : MS) {
//            if (skill != null) {
//                System.out.println(skill.getSkillName() + ": " + skill.getSkillDamage());
//            } else {
//                System.out.println("스킬이 null입니다.");
//            }
//        }


    }

    public SimpleMonsterType[] getMonsterType(){
        return MonsterType;
    }

    public MonsterSkill[] getMonsterSkills() {
        return MS;
    }

}
