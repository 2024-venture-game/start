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
        this.coin = new Random().nextInt(5) + 1;        //1~5 사이의 난수 발생
    }

    public void setName_M(String name_M){
        this.name_M = name_M;
    }

    public String getName_M(){
        return name_M;
    }

    public int getHP_M() {
        return HP_M;
    }

    public void setHP_M(int HP_M) {
        this.HP_M = HP_M;
    }

    public int getAD_M() {
        return AD_M;
    }

    public void setAD_M(int AD_M) {
        this.AD_M = AD_M;
    }

    public int getDF_M() {
        return DF_M;
    }

    public void setDF_M(int DF_M) {
        this.DF_M = DF_M;
    }

    public int getLV_M() {
        return LV_M;
    }

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

