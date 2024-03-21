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

    // 브래스 사용 메소드
    public void useBreath(MonsterDragon target) {
        if (!isBreathUsed) {
            int damage = (int) (this.AD_M * 1.5); // 기본 공격력의 150%로 계산
            target.HP_M -= damage;
            isBreathUsed = true; // 브래스 사용 상태로 변경
            System.out.println("드래곤이 브래스를 사용하여 " + damage + "의 피해를 입혔습니다.");
            // 브래스 사용 후 특별한 행동이나 상태 변화가 필요하다면 여기에 추가
        } else {
            System.out.println("브래스는 이미 사용되었습니다.");
        }
    }

    // 드래곤의 HP가 절반 이하일 때와 이상일 때의 데미지 처리를 위한 메소드
    public void takeDamage(int damage) {
        if (this.HP_M > this.HP_M / 2) {
            damage /= 2; // HP가 절반 이상일 때는 받는 데미지를 반으로 줄임
        }
        this.HP_M -= damage;
    }
}
