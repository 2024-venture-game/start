package com.firebird.monster;

public class MonsterInfomation {

    public void kindOfMonster(){

        SimpleMonsterType[] MonsterType = new SimpleMonsterType[3];
        MonsterType[0] = new SimpleMonsterType("드래곤", 1000, 200, 0, 100);
        MonsterType[1] = new SimpleMonsterType("오크", 500, 50, 0, 20);
        MonsterType[2] = new SimpleMonsterType("마법사", 100, 300, 0, 5);

    }

}
