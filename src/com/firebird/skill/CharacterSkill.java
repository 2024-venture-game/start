package com.firebird.skill;

public class CharacterSkill {

    String skill_name_C;  //스킬 이름

//    int AD_C;         //공격력
//    int DF_C;         //방어력
    int skill_damage_C;         //데미지


    //생성자
//    public CharacterSkill(String skill, int ad, int df, int hp){
//        this.skill_name = skill;
//        this.AD_C = ad;
//        this.DF_C = df;
//        this.HP_C = hp;
//    }
    public CharacterSkill(String skill, int damage){
        this.skill_name_C = skill;
        this.skill_damage_C = damage;
    }

    public CharacterSkill(){}

//    public String getSkill() { return skill_name_C; }
//    public void setSkill(String skill) { this.skill_name_C = skill; }

//    public int getAD_C() { return AD_C; }
//    public void setAD_C(int AD_C) { this.AD_C = AD_C; }
//
//    public int getDF_C() { return DF_C; }
//    public void setDF_C(int DF_C) { this.DF_C = DF_C; }

//    public int getHP_C() { return skill_damage_C; }
//    public void setHP_C(int damage) { this.skill_damage_C = damage;}


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
