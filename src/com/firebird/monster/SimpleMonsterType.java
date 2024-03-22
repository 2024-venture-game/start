package com.firebird.monster;

import java.util.Random;

public class SimpleMonsterType {

    private String name_M;
    private int HP_M;       // 체력
    private int AD_M;          // 공격력
    private int DF_M;         // 방어력
    private int LV_M;        // 레벨
    private int coin;           //드랍 코인



    // 생성자
    public SimpleMonsterType(String name_M, int HP_M, int AD_M, int DF_M, int LV_M) {
        this.name_M = name_M;
        this.HP_M = HP_M;
        this.AD_M = AD_M;
        this.DF_M = DF_M;
        this.LV_M = LV_M;
        this.coin = new Random().nextInt(5) + 1;
    }

    public void setName_M(String name_M){
        this.name_M = name_M;
    }

    public String getName_M(){
        return name_M;
    }

    // HP_M에 대한 getter
    public int getHP_M() {
        return HP_M;
    }

    // HP_M에 대한 setter
    public void setHP_M(int HP_M) {
        this.HP_M = HP_M;
    }

    // AD_M에 대한 getter
    public int getAD_M() {
        return AD_M;
    }

    // AD_M에 대한 setter
    public void setAD_M(int AD_M) {
        this.AD_M = AD_M;
    }

    // DF_M에 대한 getter
    public int getDF_M() {
        return DF_M;
    }

    // DF_M에 대한 setter
    public void setDF_M(int DF_M) {
        this.DF_M = DF_M;
    }

    // LV_M에 대한 getter
    public int getLV_M() {
        return LV_M;
    }

    // LV_M에 대한 setter
    public void setLV_M(int LV_M) {
        this.LV_M = LV_M;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}

//몬스터 처치시 드롭되는 코인의 양을 랜덤성으로 지정해서 드롭되게 설정하기
