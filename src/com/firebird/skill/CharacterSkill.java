package com.firebird.skill;

public class CharacterSkill {

    String skill_name_C;  //스킬 이름
    int skill_damage_C;         //데미지

    public CharacterSkill(String skill,  int damage){
        this.skill_name_C = skill;
        this.skill_damage_C = damage;
    }

    public String getSkill_name_C() {
        return skill_name_C;
    }

    public void setSkill_name_C(String skill_name_C) {
        this.skill_name_C = skill_name_C;
    }

    public int getSkill_damage_C() {
        return skill_damage_C;
    }

    public void setSkill_damage_C(int skill_damage_C) {
        this.skill_damage_C = skill_damage_C;
    }
}

