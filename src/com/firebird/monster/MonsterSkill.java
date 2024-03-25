package com.firebird.monster;

public class MonsterSkill {

    private String SkillName;       //스킬명
    private int SkillDamage;        //스킬데미지

    private int SkillHeal;          //스킬 회복

    public MonsterSkill(String SkillName, int SkillDamage, int SkillHeal){
        this.SkillName = SkillName;
        this.SkillDamage = SkillDamage;
        this.SkillHeal = SkillHeal;
    }

    public void setSkillName(String Skillname){
        this.SkillName = Skillname;
    }

    public String getSkillName(){
        return SkillName;
    }

    public void setSkillDamage(int SkillDamage){
        this.SkillDamage = SkillDamage;
    }

    public int getSkillDamage(){
        return SkillDamage;
    }

    public void setSkillHeal(int SkillHeal){
        this.SkillHeal = SkillHeal;
    }

    public int getSkillHeal(){
        return SkillHeal;
    }
}
