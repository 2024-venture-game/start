package com.firebird.character;
    public class Bandit extends character {

        public Bandit (int HP_C, int AD_C, int DF_C, int LV_C) {
            super(HP_C,AD_C,DF_C, LV_C);

        }

        public void introduce () {
            System.out.println("===================================================");
            System.out.println("도적를 선택하셨습니다!");
            System.out.println("레벨 : " + LV_C);
            System.out.println("체력 : " + HP_C);
            System.out.println("공격력 : " + AD_C);
            System.out.println("방어력 : " + DF_C);
            System.out.println("전투 특성 : ");
            System.out.println("===================================================");
            System.out.println("");
            System.out.println("숙련된 검술을 익힌 흑기사는 몬스터들에게 두려움의 상징입니다!");
        }


    }
