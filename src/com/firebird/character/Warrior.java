package com.firebird.character;
    public class Warrior extends character {

        public Warrior(int HP_C, int AD_C, int DF_C, int LV_C) {
            super(HP_C,AD_C,DF_C,LV_C);

        }

        public void introduce () {
            System.out.println("===================================================");
            System.out.println("[검사🗡️]를 선택하셨습니다!");
            System.out.println("[레벨🌟] " + LV_C);
            System.out.println("[체력🫙] " + HP_C);
            System.out.println("[공격력🎯] " + AD_C);
            System.out.println("[방어력🛡️] " + DF_C);
            System.out.println("[전투 특성⚔️]  ");
            System.out.println("===================================================");
            System.out.println("지옥 너머 낙원을 꿈꾸는 검은 들개...");
            System.out.println("공격 중심의 캐릭터로 적에게 막강한 데미지를 줄 수 있습니다.");
            System.out.println("숙련된 검술을 익힌 흑기사는 몬스터들에게 두려움의 상징입니다.");
            System.out.println("흑기사와 함께 몬스터를 물리치세요! ╰༼.◕ヮ◕.༽つ¤=[]————");

        }


    }

