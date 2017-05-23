import java.util.Random;
import javax.swing.*;
import java.io.*;


public class Final {
    static mainChar hero = new mainChar();
    private static enemy oppo = new enemy();
    static boolean needwin = true;
    static String first;
    static String second;
    static int firstdmg;
    static int seconddmg;
    static int dmgstat;

    public Final(){};

    public static void contain(){
        String mainChar;
        //Main character naming and intro.

        mainChar = finalgui.text.showInputDialog("Good morning, do you remember your name?");
        finalgui.text.showMessageDialog(null, "Hello " + mainChar +
                ". You've been out for quite some time now...");

        System.out.print("jello");

        classset(FinalStory.characterCreator(""));

        FinalStory.startfightpre();

        //needs to make randomizer for monster stat creation
        while(needwin) {
            battleSystem(0);
        }

        first = monsterCreator();
        System.out.println("You defeated " + first);
        firstdmg = dmgstat;
        needwin=true;


        FinalStory.afterfirst();
        while(needwin){
            battleSystem(1);
        }
        if (hero.getEquippedItm()== "Caliburn"){
            hero.setAtk(30);
        }
        else{
            hero.setmAtk(40);
        }

        second = monsterCreator();
        System.out.println("You defeated " + second);
        needwin=true;
        seconddmg = dmgstat;

        FinalStory.afterlast();
    }

    public static void namefirst() {
        System.out.println("Enemy name = " +  first);
    }
    public static void namesecond(){
        System.out.println("Enemy name = " + second);
    }
    public static void firstdmg(){
        System.out.println("Enemy damage done = " + firstdmg);
    }
    public static void seconddmg(){
        System.out.println("Enemy damage done = " + seconddmg);
    }



    public static void classset(int classChoice){
        if(classChoice == 0){
            hero.setAtk(15);
            hero.setDef(5);
            hero.setmAtk(10);
            hero.setmDef(5);
            hero.setSpd(10);
            hero.setHp(100);
            hero.setEquippedItm("Caliburn");
        }
        else {
            hero.setAtk(10);
            hero.setDef(5);
            hero.setmAtk(15);
            hero.setmDef(5);
            hero.setSpd(10);
            hero.setHp(100);
            hero.setEquippedItm("Staff of the Snake");
        }
    }

    private static String monsterCreator(){

        String adj[]={"Black ", "White ", "Evil ", "Cruel ", "Unholy ", "Magic ", "Crazed "
        };
        String noun[]={"Demon", "Devil", "Fighter", "Swordsman","Mage", "Axeman", "King"
        };
        Random generator = new Random();
        int n = generator.nextInt(adj.length)+0;
        int i = generator.nextInt(noun.length)+0;
        return adj[n] + noun[i];

    }

    private static void battleSystem(int k) {

        dmgstat =0;
        int Atk = hero.getAtk();
        int Def = hero.getDef();
        int mAtk = hero.getmAtk();
        int mDef = hero.getmDef();
        int Spd = hero.getSpd();
        int Hp = hero.getHp();
        String EquippedItm = hero.getEquippedItm();


        //Enemy stats

            int eAtk = oppo.getAtk();
            int eDef = oppo.getDef();
            int emAtk = oppo.getmAtk();
            int emDef = oppo.getmDef();
            int eSpd = oppo.getSpd();
            int eHp = oppo.getHp();



            if(k == 1){
                eHp = eHp* 2;
            }
        //neutral variables
        int dmg;
        Random generator = new Random();
        int n;

        //Item identifiers
        String item1Name = "Iron Sword";
        int item1 = 1;

        int TurnCounter;
        int eTurnCounter;
        int i;

        //Item check

        TurnCounter = Spd;
        eTurnCounter = eSpd;

        while (Hp > 0 && eHp > 0) {

            //Double Attack
            TurnCounter = Spd / eSpd;
            if (TurnCounter < 1) {
                TurnCounter = 1;
            }
            eTurnCounter = eSpd / Spd;
            if (eTurnCounter < 1) {
                eTurnCounter = 1;
            }
            //End Double attack


            for (i = 0; i < TurnCounter; i++) {
                System.out.println("\nYour current health is " + Hp);
                Object[] options = {"Physical Attack", "Magic Attack"};
                int choice = finalgui.text.showOptionDialog(null, //Component parentComponent
                        "Physical or Magic attack?", //Object message,
                        "Choose an option", //String title
                        finalgui.text.YES_NO_OPTION, //int optionType
                        finalgui.text.INFORMATION_MESSAGE, //int messageType
                        null, //Icon icon,
                        options, //Object[] options,
                        "Physical Attack");//Object initialValue
                switch (choice) {
                    case 0:
                        dmg = Atk - eDef;
                        eHp = eHp - dmg;
                        TextAreaLogProgram.printLog("Attacked with a Physical attack!");
                        break;
                    default:
                        dmg = mAtk - emDef;
                        eHp = eHp - dmg;
                        System.out.println("Attacked with a Magic attack!");
                }
            }
            for (i = 0; i < eTurnCounter; i++) {
                n = generator.nextInt();
                if (n % 2 == 0) {
                    dmg = eAtk - Def;
                    Hp = Hp - dmg;
                    System.out.println("The enemy attacked you with a physical attack!");
                    System.out.println("You took " + dmg + " damage!");
                    dmgstat += dmg;
                } else {
                    dmg = emAtk - mDef;
                    Hp = Hp - dmg;
                    System.out.println("The enemy attacked you with a magic attack!");
                    System.out.println("You took " + dmg + " damage!");
                    dmgstat += dmg;
                }
            }
        }
        if (Hp <= 0) {
            System.out.println("\nYou're dead!");
        }
        if (eHp <= 0) {
            System.out.println("\nThe enemy is dead!");
            needwin = false;
        }

        //End Battle System
        System.out.println("");
    }

    public static void main(String[] args){
        contain();
        TextAreaLogProgram.printLog("Hello");
    };
}

