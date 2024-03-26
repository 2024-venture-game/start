package com.firebird.character;

public class Magician extends character {

    public Magician (int HP_C, int AD_C, int DF_C,int LV_C) {
        super(HP_C,AD_C,DF_C, LV_C);

    }

    public void introduce () {
        System.out.println("===================================================");
        System.out.println("[마법사🪄]를 선택하셨습니다!");
        System.out.println("[레벨🌟] " + LV_C);
        System.out.println("[체력🫙] " + HP_C);
        System.out.println("[공격력🎯] " + AD_C);
        System.out.println("[방어력🛡️] " + DF_C);
        System.out.println("[전투 특성⚔️] 마법, 원거리");
        System.out.println("===================================================");
        System.out.println("영혼을 다루는 신비로운 마법사...╰( ´・ω・)つ──☆✿✿✿✿✿✿");
        System.out.println("다양한 정령과 함께 강력한 마법으로 적을 제압합니다.");
        System.out.println("다채롭고 화려한 마법을 연계하는 마법사와 함께 몬스터를 물리치세요!");

    }


}

