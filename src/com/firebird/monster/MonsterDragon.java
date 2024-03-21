package com.firebird.monster;

import com.firebird.character.Character; // Character 클래스 사용을 위해 임포트

public class MonsterDragon extends SimpleType {

    private boolean isBreathUsed;

    public MonsterDragon(int HP, int AD, int DF, int LV) {
        this.HP_M = HP;
        this.AD_M = AD;
        this.DF_M = DF;
        this.LV_M = LV;
        this.isBreathUsed = false;
    }

    // attack 메소드 수정
    public void attack(Object target) {
        if(target instanceof Character) {
            Character targetCharacter = (Character) target;
            int damage = this.AD_M - targetCharacter.DF_C;
            damage = Math.max(damage, 0);
            targetCharacter.HP_C -= damage;
            System.out.println("드래곤이 캐릭터에게 공격하여 " + damage + "의 피해를 입혔습니다.");
        } else if(target instanceof MonsterDragon) {
            MonsterDragon targetMonster = (MonsterDragon) target;
            int damage = this.AD_M - targetMonster.DF_M;
            damage = Math.max(damage, 0);
            targetMonster.HP_M -= damage;
            System.out.println("드래곤이 다른 드래곤에게 공격하여 " + damage + "의 피해를 입혔습니다.");
        }
    }

    // 기존 MonsterDragon 클래스의 나머지 부분은 동일하게 유지
}
