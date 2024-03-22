package com.firebird.character;

    public class Archer extends character {

        public Archer( int HP_C, int AD_C, int DF_C, int LV_C) {
            super(HP_C,AD_C,DF_C,LV_C);
        }

        public void introduce () {

            System.out.println("===================================================");
            System.out.println("궁수를 선택하셨습니다!");
            System.out.println("레벨 : " + LV_C);
            System.out.println("체력 : " + HP_C);
            System.out.println("공격력 : " + AD_C);
            System.out.println("방어력 : " + DF_C);
            System.out.println("전투 특성 : 연속 공격, 원거리");
            System.out.println("===================================================");
            System.out.println("활을 주무기로 다루며 특수 화살로 적을 공격합니다.");
            System.out.println("높은 정확도의 공격으로 상대방의 약점을 공략하여 적을 무너뜨립니다.");
            System.out.println(" ");
        }


    }
