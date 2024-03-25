package com.firebird.main;

import java.util.*;

import com.firebird.character.*;
import com.firebird.monster.MonsterInfomation;
import com.firebird.monster.MonsterSkill;
import com.firebird.monster.SimpleMonsterType;

import com.firebird.monster.MonsterInfomation;
import com.firebird.skill.*;
import com.sun.tools.javac.Main;

public class Application {
    private static Scanner scanner = new Scanner(System.in);


//    public int num;

    public static void main(String[] args) {
        boolean gameStart = false;

        while (!gameStart) {
            System.out.println("******게임 시작******");
            System.out.println("1. 검사");
            System.out.println("2. 마법사");
            System.out.println("3. 궁수");
            System.out.println("4. 도적");
            System.out.print("선택할 캐릭터의 번호를 입력하세요: ");
            int num = scanner.nextInt();

//            Application gmChar = new Application();
//            int num3 = gmChar.startBattle(num);

//            startBattle();

            String characterName = "";

            switch (num) {
                case 1:
                    characterName = "검사";
                    break;
                case 2:
                    characterName = "마법사";
                    break;
                case 3:
                    characterName = "궁수";
                    break;
                case 4:
                    characterName = "도적";
                    break;
                default:
                    System.out.println("다시 숫자를 입력해주십시오.");
                    continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
            }


            System.out.println(characterName + "가 선택되었습니다.");
            System.out.println("정말 이 캐릭터로 선택하시겠습니까?");
            System.out.println("1. 예");
            System.out.println("2. 아니오");
            int num2 = scanner.nextInt();

            if (num2 == 1) {
                System.out.println("게임을 시작합니다.");
                /* 캐릭터 설명 불러오기 */
                switch (num) {
                    case 1:
                        // 검사의 설명을 불러오기
                        Warrior warrior = new Warrior(90, 20, 10, 1); // 예시 값
                        warrior.introduce();
                        break;
                    case 2:
                        // 마법사의 설명을 불러오기
                        Magician magician = new Magician(90, 10, 20, 1); // 예시 값
                        magician.introduce();
                        break;
                    case 3:
                        // 궁수의 설명을 불러오기
                        Archer archer = new Archer(80, 10, 15, 1); // 예시 값
                        archer.introduce();
                        break;
                    case 4:
                        // 도적의 설명을 불러오기
                        Bandit bandit = new Bandit(100, 10, 5, 1); // 예시 값
                        bandit.introduce();
                        break;
                    default:
                        break;
                }
                gameStart = true; // 게임 시작
                startBattle(num); // 전투 시작
            } else if (num2 == 2) {
                System.out.println("캐릭터를 다시 선택해주세요.");
                continue; // 캐릭터 선택부터 다시 시작
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                continue; // 캐릭터 선택부터 다시 시작
            }
        }

        scanner.close();
    }

    /*====================== startBattle ======================*/
    private static void startBattle(int num) {
        System.out.println("전투를 시작합니다.");
        Random rand = new Random();
//        int monsterHP = rand.nextInt(100) + 1; // 몬스터의 체력을 랜덤으로 설정
//        int playerHP = 100; // 플레이어의 체력 초기화

        SimpleMonsterType simpleMonsterType = new SimpleMonsterType();

        MonsterInfomation monsterInformation = new MonsterInfomation();

        monsterInformation.kindOfMonster();
        monsterInformation.kindOfSkill();

        MonsterSkill[] monsterSkills = monsterInformation.getMonsterSkills();

        Random random = new Random();

        SimpleMonsterType dragon = monsterInformation.getMonsterType()[0]; // 드래곤 불러오기
        SimpleMonsterType oak = monsterInformation.getMonsterType()[1]; // 오크 불러오기
        SimpleMonsterType wizard = monsterInformation.getMonsterType()[2]; // 마법사 불러오기

        SkillWarrior warrior = new SkillWarrior();
        warrior.kindOfCharacterSkill();
        SkillArcher archer = new SkillArcher();
        archer.kindOfCharacterSkill();
        SkillBandit bandit = new SkillBandit();
        bandit.kindOfCharacterSkill();
        SkillMagician magician = new SkillMagician();
        magician.kindOfCharacterSkill();

        CharacterSelection characterSelection = new CharacterSelection();
        Warrior ch_warrior = new Warrior(90, 20, 10, 1);
        Magician ch_magician = new Magician(90, 10, 20, 1);
        Archer ch_archer = new Archer(80, 10, 15, 1);
        Bandit ch_bandit = new Bandit(100, 10, 5, 1);


        System.out.println("");
        System.out.println("*************************************");
        System.out.println(wizard.getName_M() + "가 등장했습니다.");
        System.out.println("전투를 시작합니다.");
        System.out.println(wizard.getName_M() + "의 현재 체력은 " + wizard.getHP_M() + "입니다.");
        System.out.println("*************************************");
        System.out.println("");


        int wizardBossHP = wizard.getHP_M();
        int oakBossHP = oak.getHP_M();
        int dragonBossHP = dragon.getHP_M();

        int warriorHP = ch_warrior.HP_C;
        int magicianHP = ch_magician.HP_C;
        int archerHP = ch_archer.HP_C;
        int banditHP = ch_bandit.HP_C;

        int level = 1;  // 레벨 초기화

        if (num == 1) {   //=========================================================== 전사 Level1
            while (true) {
//                System.out.println("확인용");
                CharacterSkill[] skills = warrior.getCharacterSkills();

                System.out.println("어떤 스킬을 사용하시겠습니까?");
                System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                Scanner scanner = new Scanner(System.in);
                int skillNum = scanner.nextInt();


                int damageDealt = 0; // 입힌 데미지 초기화

                switch (skillNum) {
                    case 1:
                        damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                        break;
                    case 2:
                        damageDealt = skills[1].getSkill_damage_C();
                        ; // 스킬 2에 대한 데미지 설정
                        break;
                    case 3:
                        damageDealt = skills[2].getSkill_damage_C();
                        ; // 스킬 3에 대한 데미지 설정
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                        continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                wizardBossHP += damageDealt;
                System.out.println("");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                System.out.println("현재 『" + wizard.getName_M() + "』 의 체력은 '" + wizardBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                int i = random.nextInt(monsterSkills.length);
                if (skills[i] != null) {

                    if (wizardBossHP <= 0) {
                        System.out.println("");
                        System.out.println("몬스터를 물리쳤습니다.");
                        System.out.println("");
                        level++;
                        break;
                    }

                    System.out.println("");
                    System.out.println("'" + wizard.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                    System.out.println("");
                    //                    System.out.println("여기 데미지 확인 구문");
                    warriorHP -= monsterSkills[i].getSkillDamage();
                    System.out.println("*********************");
                    System.out.println("현재 플레이어의 체력은 " + warriorHP + " 입니다.");
                    System.out.println("*********************");
                } else {
                    System.out.println("대충 버그났다는 내용");
                }


                // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                if (warriorHP <= 0) {
                    System.out.println("");
                    System.out.println("플레이어가 졌습니다. 게임 끝!");
                    System.out.println("");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    System.out.println("        _/_/_/                                            _/_/                                 ");
                    System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                    System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                    System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                    System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                    System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    break;
                }

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

            }
            if (level == 2) {   //=========================================================== 전사 Level2
                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(oak.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(oak.getName_M() + "의 현재 체력은 " + oak.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //=======================================
                while (true) {
//                System.out.println("확인용");
                    CharacterSkill[] skills = warrior.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();

                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    oakBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + oak.getName_M() + "』 의 체력은 '" + oakBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (oakBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
                            level++;
                            break;
                        }

                        System.out.println("");
                        System.out.println("'" + oak.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        warriorHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + warriorHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    /*if (warriorHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        level++;
                        System.out.println("레벨이" + level + "레벨 되었습니다");
                        break;
                    }*/
                }
            } /*else {
                System.out.println("레벨 부족으로 게임이 종료됩니다.");
            }*/

            if(level == 3){     //=========================================================== 전사 Level3


                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(dragon.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(dragon.getName_M() + "의 현재 체력은 " + dragon.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //=======================================
                while (true) {
//                System.out.println("확인용");

                    CharacterSkill[] skills = warrior.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    dragonBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + dragon.getName_M() + "』 의 체력은 '" + dragonBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소

                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("                                                                                             ");
                            System.out.println("      _/      _/    _/_/    _/    _/      _/          _/  _/_/_/  _/      _/      _/  _/  _/");
                            System.out.println("       _/  _/    _/    _/  _/    _/      _/          _/    _/    _/_/    _/      _/  _/  _/ ");
                            System.out.println("        _/      _/    _/  _/    _/      _/    _/    _/    _/    _/  _/  _/      _/  _/  _/  ");
                            System.out.println("       _/      _/    _/  _/    _/        _/  _/  _/      _/    _/    _/_/                  ");
                            System.out.println("      _/        _/_/      _/_/            _/  _/      _/_/_/  _/      _/      _/  _/  _/  ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");


                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        warriorHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + warriorHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (warriorHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

                    if (skills[i] != null) {
                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("모든 모스를 처치했습니다! 축하합니다.");
                            break;
                        }

//                        System.out.println("");
//                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
//                        System.out.println("");
//                        //                    System.out.println("여기 데미지 확인 구문");
//                        banditHP -= monsterSkills[i].getSkillDamage();
//                        System.out.println("*********************");
//                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
//                        System.out.println("*********************");
                    } /*else {
                        System.out.println("대충 버그났다는 내용");
                    }*/


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (warriorHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }


//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
            }


        } else if (num == 2) {    //=========================================================== 마법사 Level1
            while (true) {
                CharacterSkill[] skills = magician.getCharacterSkills();

                System.out.println("어떤 스킬을 사용하시겠습니까?");
                System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                Scanner scanner = new Scanner(System.in);
                int skillNum = scanner.nextInt();

                int damageDealt = 0; // 입힌 데미지 초기화

                switch (skillNum) {
                    case 1:
                        damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                        break;
                    case 2:
                        damageDealt = skills[1].getSkill_damage_C();
                        ; // 스킬 2에 대한 데미지 설정
                        break;
                    case 3:
                        damageDealt = skills[2].getSkill_damage_C();
                        ; // 스킬 3에 대한 데미지 설정
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                        continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                wizardBossHP += damageDealt;
                System.out.println("");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                System.out.println("현재 『" + wizard.getName_M() + "』 의 체력은 '" + wizardBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                int i = random.nextInt(monsterSkills.length);
                if (skills[i] != null) {

                    if (wizardBossHP <= 0) {
                        System.out.println("");
                        System.out.println("몬스터를 물리쳤습니다.");
                        System.out.println("");
                        level++;
                        System.out.println("레벨이 " + level + " 레벨 되었습니다");
                        break;
                    }
                    System.out.println("");
                    System.out.println("'" + wizard.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                    System.out.println("");
                    //                    System.out.println("여기 데미지 확인 구문");
                    magicianHP -= monsterSkills[i].getSkillDamage();
                    System.out.println("*********************");
                    System.out.println("현재 플레이어의 체력은 " + magicianHP + " 입니다.");
                    System.out.println("*********************");
                } else {
                    System.out.println("대충 버그났다는 내용");
                }

                if (magicianHP <= 0) {
                    System.out.println("");
                    System.out.println("플레이어가 졌습니다. 게임 끝!");
                    System.out.println("");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    System.out.println("        _/_/_/                                            _/_/                                 ");
                    System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                    System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                    System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                    System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                    System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    break;
                }



                // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                /*if (magicianHP <= 0) {
                    System.out.println("");
                    System.out.println("플레이어가 졌습니다. 게임 끝!");
                    System.out.println("");
                    break;
                }*/

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

            }
            if (level == 2) {       //=========================================================== 마법사 Level2
                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(oak.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(oak.getName_M() + "의 현재 체력은 " + oak.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //=======================================
                while (true) {
//                System.out.println("확인용");
                    CharacterSkill[] skills = magician.getCharacterSkills();


                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    oakBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + oak.getName_M() + "』 의 체력은 '" + oakBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (oakBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
                            level++;
                            break;
                        }

                        System.out.println("");
                        System.out.println("'" + oak.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        magicianHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + magicianHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }

                    if (magicianHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }


                }
            }

            if(level == 3){
                //=========================================================== 도적 Level2

                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(dragon.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(dragon.getName_M() + "의 현재 체력은 " + dragon.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //======================================= 전사
                while (true) {
//                System.out.println("확인용");

                    CharacterSkill[] skills = magician.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    dragonBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + dragon.getName_M() + "』 의 체력은 '" + dragonBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소

                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");

//                            level++;
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("                                                                                             ");
                            System.out.println("      _/      _/    _/_/    _/    _/      _/          _/  _/_/_/  _/      _/      _/  _/  _/");
                            System.out.println("       _/  _/    _/    _/  _/    _/      _/          _/    _/    _/_/    _/      _/  _/  _/ ");
                            System.out.println("        _/      _/    _/  _/    _/      _/    _/    _/    _/    _/  _/  _/      _/  _/  _/  ");
                            System.out.println("       _/      _/    _/  _/    _/        _/  _/  _/      _/    _/    _/_/                  ");
                            System.out.println("      _/        _/_/      _/_/            _/  _/      _/_/_/  _/      _/      _/  _/  _/  ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");



                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        magicianHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + magicianHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (magicianHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

                    if (skills[i] != null) {
                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("모든 모스를 처치했습니다! 축하합니다.");
                            break;
                        }

//                        System.out.println("");
//                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
//                        System.out.println("");
//                        //                    System.out.println("여기 데미지 확인 구문");
//                        banditHP -= monsterSkills[i].getSkillDamage();
//                        System.out.println("*********************");
//                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
//                        System.out.println("*********************");
                    } /*else {
                        System.out.println("대충 버그났다는 내용");
                    }*/


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소


//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
            }

            } else if (num == 3) {          //=========================================================== 궁수 Level1
                while (true) {
//                System.out.println("확인용");
                    CharacterSkill[] skills = archer.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    wizardBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + wizard.getName_M() + "』 의 체력은 '" + wizardBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (wizardBossHP <= 0) {

                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
                            level++;
                            System.out.println("레벨이 " + level + " 레벨 되었습니다");
                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + wizard.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        archerHP -= monsterSkills[i].getSkillDamage();                      //!!!
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + archerHP + " 입니다.");   //!!!
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (archerHP <= 0) {        //!!!
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
                if (level == 2) {           //=========================================================== 궁수 Level2
                    System.out.println();
                    System.out.println("==================================");
                    System.out.println("5초 후에 다음 단계로 이동합니다!");
                    System.out.println("==================================");
                    System.out.println();

                    try {
                        Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                    System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                    System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                    System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                    System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                    System.out.println("                                                                                 _/             ");
                    System.out.println("                                                                            _/_/               ");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");

                    System.out.println("");
                    System.out.println("*************************************");
                    System.out.println(oak.getName_M() + "가 등장했습니다.");
                    System.out.println("전투를 시작합니다.");
                    System.out.println(oak.getName_M() + "의 현재 체력은 " + oak.getHP_M() + "입니다.");
                    System.out.println("*************************************");
                    System.out.println("");

                    //=======================================
                    while (true) {
//                System.out.println("확인용");
                        CharacterSkill[] skills = archer.getCharacterSkills();


                        System.out.println("어떤 스킬을 사용하시겠습니까?");
                        System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                        System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                        System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                        Scanner scanner = new Scanner(System.in);
                        int skillNum = scanner.nextInt();


                        int damageDealt = 0; // 입힌 데미지 초기화

                        switch (skillNum) {
                            case 1:
                                damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                                break;
                            case 2:
                                damageDealt = skills[1].getSkill_damage_C();
                                ; // 스킬 2에 대한 데미지 설정
                                break;
                            case 3:
                                damageDealt = skills[2].getSkill_damage_C();
                                ; // 스킬 3에 대한 데미지 설정
                                break;
                            default:
                                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                                continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                        }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                        oakBossHP += damageDealt;
                        System.out.println("");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                        System.out.println("현재 『" + oak.getName_M() + "』 의 체력은 '" + oakBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                        int i = random.nextInt(monsterSkills.length);
                        if (skills[i] != null) {

                            if (oakBossHP <= 0) {
                                System.out.println("");
                                System.out.println("몬스터를 물리쳤습니다.");
                                System.out.println("");
                                level++;
                                break;
                            }
                            System.out.println("");
                            System.out.println("'" + oak.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                            System.out.println("");
                            //                    System.out.println("여기 데미지 확인 구문");
                            archerHP -= monsterSkills[i].getSkillDamage();
                            System.out.println("*********************");
                            System.out.println("현재 플레이어의 체력은 " + archerHP + " 입니다.");
                            System.out.println("*********************");
                        } else {
                            System.out.println("대충 버그났다는 내용");
                        }


                        // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                        if (archerHP <= 0) {
                            System.out.println("");
                            System.out.println("플레이어가 졌습니다. 게임 끝!");
                            System.out.println("");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("        _/_/_/                                            _/_/                                 ");
                            System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                            System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                            System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            break;
                        }

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                    }


                }

            if(level == 3){
                //=========================================================== 도적 Level2

                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(dragon.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(dragon.getName_M() + "의 현재 체력은 " + dragon.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //======================================= 전사
                while (true) {
//                System.out.println("확인용");

                    CharacterSkill[] skills = archer.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    dragonBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + dragon.getName_M() + "』 의 체력은 '" + dragonBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소

                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("                                                                                             ");
                            System.out.println("      _/      _/    _/_/    _/    _/      _/          _/  _/_/_/  _/      _/      _/  _/  _/");
                            System.out.println("       _/  _/    _/    _/  _/    _/      _/          _/    _/    _/_/    _/      _/  _/  _/ ");
                            System.out.println("        _/      _/    _/  _/    _/      _/    _/    _/    _/    _/  _/  _/      _/  _/  _/  ");
                            System.out.println("       _/      _/    _/  _/    _/        _/  _/  _/      _/    _/    _/_/                  ");
                            System.out.println("      _/        _/_/      _/_/            _/  _/      _/_/_/  _/      _/      _/  _/  _/  ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");


                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        archerHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + archerHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (archerHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

                    if (skills[i] != null) {
                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("모든 모스를 처치했습니다! 축하합니다.");
                            break;
                        }

//                        System.out.println("");
//                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
//                        System.out.println("");
//                        //                    System.out.println("여기 데미지 확인 구문");
//                        banditHP -= monsterSkills[i].getSkillDamage();
//                        System.out.println("*********************");
//                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
//                        System.out.println("*********************");
                    } /*else {
                        System.out.println("대충 버그났다는 내용");
                    }*/


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    /*if (archerHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }
*/

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
            }

            } else if (num == 4) {     //=========================================================== 도적 Level1

                while (true) {
//                System.out.println("확인용");
                    CharacterSkill[] skills = bandit.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    wizardBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + wizard.getName_M() + "』 의 체력은 '" + wizardBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소


                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {
                        if (wizardBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                    break;
                            level++;
                            System.out.println("레벨이 " + level + " 레벨 되었습니다");
                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + wizard.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        banditHP -= monsterSkills[i].getSkillDamage();                      //!!!
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");   //!!!
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (banditHP <= 0) {        //!!!
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임오버!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
                if (level == 2) {           //=========================================================== 도적 Level2

                    System.out.println();
                    System.out.println("==================================");
                    System.out.println("5초 후에 다음 단계로 이동합니다!");
                    System.out.println("==================================");
                    System.out.println();

                    try {
                        Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");
                    System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                    System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                    System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                    System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                    System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                    System.out.println("                                                                                 _/             ");
                    System.out.println("                                                                            _/_/               ");
                    System.out.println("#################################################################################################");
                    System.out.println("#################################################################################################");

                    System.out.println("");
                    System.out.println("*************************************");
                    System.out.println(oak.getName_M() + "가 등장했습니다.");
                    System.out.println("전투를 시작합니다.");
                    System.out.println(oak.getName_M() + "의 현재 체력은 " + oak.getHP_M() + "입니다.");
                    System.out.println("*************************************");
                    System.out.println("");

                    //======================================= 전사
                    while (true) {
//                System.out.println("확인용");

                        CharacterSkill[] skills = bandit.getCharacterSkills();

                        System.out.println("어떤 스킬을 사용하시겠습니까?");
                        System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                        System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                        System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                        Scanner scanner = new Scanner(System.in);
                        int skillNum = scanner.nextInt();


                        int damageDealt = 0; // 입힌 데미지 초기화

                        switch (skillNum) {
                            case 1:
                                damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                                break;
                            case 2:
                                damageDealt = skills[1].getSkill_damage_C();
                                ; // 스킬 2에 대한 데미지 설정
                                break;
                            case 3:
                                damageDealt = skills[2].getSkill_damage_C();
                                ; // 스킬 3에 대한 데미지 설정
                                break;
                            default:
                                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                                continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                        }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                        oakBossHP += damageDealt;
                        System.out.println("");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                        System.out.println("현재 『" + oak.getName_M() + "』 의 체력은 '" + oakBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소

                        int i = random.nextInt(monsterSkills.length);
                        if (skills[i] != null) {

                            if (oakBossHP <= 0) {
                                System.out.println("");
                                System.out.println("몬스터를 물리쳤습니다.");
                                System.out.println("");
                                level++;
                                break;
                            }
                            System.out.println("");
                            System.out.println("'" + oak.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                            System.out.println("");
                            //                    System.out.println("여기 데미지 확인 구문");
                            banditHP -= monsterSkills[i].getSkillDamage();
                            System.out.println("*********************");
                            System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
                            System.out.println("*********************");
                        } else {
                            System.out.println("대충 버그났다는 내용");
                        }


                        // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                        if (banditHP <= 0) {
                            System.out.println("");
                            System.out.println("플레이어가 졌습니다. 게임 끝!");
                            System.out.println("");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("        _/_/_/                                            _/_/                                 ");
                            System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                            System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                            System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            break;
                        }

                        if (skills[i] != null) {
                            if (dragonBossHP <= 0) {
                                System.out.println("");
                                System.out.println("몬스터를 물리쳤습니다.");
                                System.out.println("");
                                level++;
                                break;
                            }

//                            System.out.println("");
//                            System.out.println("'" + oak.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
//                            System.out.println("");
//                            //                    System.out.println("여기 데미지 확인 구문");
//                            banditHP -= monsterSkills[i].getSkillDamage();
//                            System.out.println("*********************");
//                            System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
//                            System.out.println("*********************");
                        } /*else {
                            System.out.println("대충 버그났다는 내용");
                        }*/


                        // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

//                        if (banditHP <= 0) {
//                            System.out.println("");
//                            System.out.println("플레이어가 졌습니다. 게임 끝!");
//                            System.out.println("");
//                            System.out.println("#################################################################################################");
//                            System.out.println("#################################################################################################");
//                            System.out.println("        _/_/_/                                            _/_/                                 ");
//                            System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
//                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
//                            System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
//                            System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
//                            System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
//                            System.out.println("#################################################################################################");
//                            System.out.println("#################################################################################################");
//                            break;
//                        }


//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                    }

                }





                /*============================================================================================*/
            /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/






            if(level == 3){
                //=========================================================== 도적 Level2

                System.out.println();
                System.out.println("==================================");
                System.out.println("5초 후에 다음 단계로 이동합니다!");
                System.out.println("==================================");
                System.out.println();

                try {
                    Thread.sleep(5000); // InterruptedException을 발생시킬 수 있는 메서드
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");
                System.out.println("    _/      _/                        _/            _/_/_/    _/                                 ");
                System.out.println("   _/_/    _/    _/_/    _/    _/  _/_/_/_/      _/        _/_/_/_/    _/_/_/    _/_/_/    _/_/ ");
                System.out.println("  _/  _/  _/  _/_/_/_/    _/_/      _/            _/_/      _/      _/    _/  _/    _/  _/_/_/_/");
                System.out.println(" _/    _/_/  _/        _/    _/    _/                _/    _/      _/    _/  _/    _/  _/       ");
                System.out.println("_/      _/    _/_/_/  _/    _/      _/_/      _/_/_/        _/_/    _/_/_/    _/_/_/    _/_/_/ ");
                System.out.println("                                                                                 _/             ");
                System.out.println("                                                                            _/_/               ");
                System.out.println("#################################################################################################");
                System.out.println("#################################################################################################");

                System.out.println("");
                System.out.println("*************************************");
                System.out.println(dragon.getName_M() + "가 등장했습니다.");
                System.out.println("전투를 시작합니다.");
                System.out.println(dragon.getName_M() + "의 현재 체력은 " + dragon.getHP_M() + "입니다.");
                System.out.println("*************************************");
                System.out.println("");

                //======================================= 전사
                while (true) {
//                System.out.println("확인용");

                    CharacterSkill[] skills = bandit.getCharacterSkills();

                    System.out.println("어떤 스킬을 사용하시겠습니까?");
                    System.out.println("1." + skills[0].getSkill_name_C() + " 데미지 : " + skills[0].getSkill_damage_C());
                    System.out.println("2." + skills[1].getSkill_name_C() + " 데미지 : " + skills[1].getSkill_damage_C());
                    System.out.println("3." + skills[2].getSkill_name_C() + " 데미지 : " + skills[2].getSkill_damage_C());
                    Scanner scanner = new Scanner(System.in);
                    int skillNum = scanner.nextInt();


                    int damageDealt = 0; // 입힌 데미지 초기화

                    switch (skillNum) {
                        case 1:
                            damageDealt = skills[0].getSkill_damage_C(); // 스킬 1에 대한 데미지 설정
                            break;
                        case 2:
                            damageDealt = skills[1].getSkill_damage_C();
                            ; // 스킬 2에 대한 데미지 설정
                            break;
                        case 3:
                            damageDealt = skills[2].getSkill_damage_C();
                            ; // 스킬 3에 대한 데미지 설정
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                            continue; // 잘못된 입력 시 다시 반복문의 처음으로 돌아감
                    }

//                System.out.println("데미지 확인용 출력문 :" + damageDealt);
//                System.out.println("체력 확인문 : " + bossHP);

                    dragonBossHP += damageDealt;
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("보스에게 " + damageDealt + " 데미지를 주었습니다.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

//                simpleMonsterType.setHP_M(bossHP + damageDealt);
                    System.out.println("현재 『" + dragon.getName_M() + "』 의 체력은 '" + dragonBossHP + "' 입니다.");
//                System.out.println("현재 이 코드가 작동하는지 확인하는 구문");

//            monsterHP -= damageDealt; // 몬스터의 체력 감소

                    int i = random.nextInt(monsterSkills.length);
                    if (skills[i] != null) {

                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");
                            System.out.println("                                                                                             ");
                            System.out.println("      _/      _/    _/_/    _/    _/      _/          _/  _/_/_/  _/      _/      _/  _/  _/");
                            System.out.println("       _/  _/    _/    _/  _/    _/      _/          _/    _/    _/_/    _/      _/  _/  _/ ");
                            System.out.println("        _/      _/    _/  _/    _/      _/    _/    _/    _/    _/  _/  _/      _/  _/  _/  ");
                            System.out.println("       _/      _/    _/  _/    _/        _/  _/  _/      _/    _/    _/_/                  ");
                            System.out.println("      _/        _/_/      _/_/            _/  _/      _/_/_/  _/      _/      _/  _/  _/  ");
                            System.out.println("#################################################################################################");
                            System.out.println("#################################################################################################");


                            break;
                        }
                        System.out.println("");
                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
                        System.out.println("");
                        //                    System.out.println("여기 데미지 확인 구문");
                        banditHP -= monsterSkills[i].getSkillDamage();
                        System.out.println("*********************");
                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
                        System.out.println("*********************");
                    } else {
                        System.out.println("대충 버그났다는 내용");
                    }


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

                    if (banditHP <= 0) {
                        System.out.println("");
                        System.out.println("플레이어가 졌습니다. 게임 끝!");
                        System.out.println("");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        System.out.println("        _/_/_/                                            _/_/                                 ");
                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
                        System.out.println("#################################################################################################");
                        System.out.println("#################################################################################################");
                        break;
                    }

                    if (skills[i] != null) {
                        if (dragonBossHP <= 0) {
                            System.out.println("");
                            System.out.println("몬스터를 물리쳤습니다.");
                            System.out.println("");
//                            level++;
                            System.out.println("모든 모스를 처치했습니다! 축하합니다.");
                            break;
                        }

//                        System.out.println("");
//                        System.out.println("'" + dragon.getName_M() + "' 가 Player에게 " + monsterSkills[i].getSkillName() + " 으로" + monsterSkills[i].getSkillDamage() + " 데미지를 주었습니다.");
//                        System.out.println("");
//                        //                    System.out.println("여기 데미지 확인 구문");
//                        banditHP -= monsterSkills[i].getSkillDamage();
//                        System.out.println("*********************");
//                        System.out.println("현재 플레이어의 체력은 " + banditHP + " 입니다.");
//                        System.out.println("*********************");
                    } /*else {
                        System.out.println("대충 버그났다는 내용");
                    }*/


                    // 몬스터의 공격
//            int monsterDamage = rand.nextInt(20) + 1; // 몬스터의 데미지를 랜덤으로 설정
//            playerHP -= monsterDamage; // 플레이어의 체력 감소

//                    if (banditHP <= 0) {
//                        System.out.println("");
//                        System.out.println("플레이어가 졌습니다. 게임 끝!");
//                        System.out.println("");
//                        System.out.println("#################################################################################################");
//                        System.out.println("#################################################################################################");
//                        System.out.println("        _/_/_/                                            _/_/                                 ");
//                        System.out.println("     _/          _/_/_/  _/_/_/  _/_/      _/_/        _/    _/  _/      _/    _/_/    _/  _/_/");
//                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
//                        System.out.println("    _/  _/_/  _/    _/  _/    _/    _/  _/_/_/_/      _/    _/  _/      _/  _/_/_/_/  _/_/     ");
//                        System.out.println("   _/    _/  _/    _/  _/    _/    _/  _/            _/    _/    _/  _/    _/        _/         ");
//                        System.out.println("    _/_/_/    _/_/_/  _/    _/    _/    _/_/_/        _/_/        _/        _/_/_/  _/         ");
//                        System.out.println("#################################################################################################");
//                        System.out.println("#################################################################################################");
//                        break;
//                    }


//            System.out.println("플레이어 HP: " + playerHP);
//            System.out.println("몬스터 HP: " + monsterHP);

                }
            }
            }
        }

   /* private static boolean askMoveOn(Scanner scanner) {
        System.out.println("다음 단계로 이동하시겠습니까? (y/n)");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("y")) {
            startBattle();
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("게임 포기하시겠습니까? (y/n)");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("게임 종료!");
                return false;
            } else if (answer.equalsIgnoreCase("n")) {
                return askMoveOn(scanner);
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                return askMoveOn(scanner);
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            return askMoveOn(scanner);
        }
    }*/
//   public void GameTimer(){
//       Timer timer = new Timer();
//       timer.schedule(timerTask,0,5000);
//   }
//
//    TimerTask timerTask = new TimerTask() {
//        @Override
//        public void run() {
//            printTimerTask();
//        }
//    };
//
//    private void printTimerTask(){
//        System.out.println();
//        System.out.println("==================================");
//        System.out.println("10초 후에 다음 단계로 이동합니다!");
//        System.out.println("==================================");
//        System.out.println();
//
//    }
//}
//
    }


