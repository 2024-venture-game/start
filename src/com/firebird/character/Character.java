package com.firebird.character;

import com.firebird.monster.MonsterDragon;

public class Character {

    public int HP_C;       // 체력
    public int AD_C;       // 공격력
    public int DF_C;       // 방어력
    public int LV_C;       // 레벨

    // Character 생성자
    public Character(int HP, int AD, int DF, int LV) {
        this.HP_C = HP;
        this.AD_C = AD;
        this.DF_C = DF;
        this.LV_C = LV;
    }

    // 캐릭터 공격 메소드
    public void attack(Object target) {
        if(target instanceof Character) {
            Character targetCharacter = (Character) target;
            int damage = this.AD_C - targetCharacter.DF_C;
            damage = Math.max(damage, 0); // 데미지가 음수가 되지 않도록 처리
            targetCharacter.HP_C -= damage;
            System.out.println("캐릭터가 공격하여 " + damage + "의 피해를 입혔습니다.");
        } else if(target instanceof MonsterDragon) {
            MonsterDragon targetMonster = (MonsterDragon) target;
            int damage = this.AD_C - targetMonster.DF_M;
            damage = Math.max(damage, 0);
            targetMonster.HP_M -= damage;
            System.out.println("캐릭터가 드래곤에게 공격하여 " + damage + "의 피해를 입혔습니다.");
        }
    }
}
