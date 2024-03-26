package com.firebird.character;
    public class Bandit extends character {

        public Bandit (int HP_C, int AD_C, int DF_C, int LV_C) {
            super(HP_C,AD_C,DF_C, LV_C);
        }

        public void introduce () {
            System.out.println("===================================================");
            System.out.println("[도적💣]를 선택하셨습니다!");
            System.out.println("[레벨🌟] " + LV_C);
            System.out.println("[체력🫙] " + HP_C);
            System.out.println("[공격력🎯️] " + AD_C);
            System.out.println("[방어력🛡️] " + DF_C);
            System.out.println("[전투 특성⚔️] 반격, 원거리");
            System.out.println("===================================================");
            System.out.println("별빛을 쫓는 검은 판다...(⌐■_■)–︻╦╤─");
            System.out.println("덩치에 맞는 무서운 괴력과 타고난 전투 감각으로 적을 제압합니다.");
            System.out.println("적에게 극한의 공포를 선사하는 대왕 판다와 함께 몬스터를 물리치세요!");
            System.out.println("===================================================");

        }


    }
