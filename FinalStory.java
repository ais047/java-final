import javax.swing.*;


public class FinalStory {
    public FinalStory() {
    }

    public static void start(){

        JOptionPane.showMessageDialog(null, "You've been out for a while now..");
        JOptionPane.showMessageDialog(null,"Do you remember your name?");

    };

    public static void startfightpre(){

        JOptionPane.showMessageDialog(null, "It seems you can move now.");
        JOptionPane.showMessageDialog(null, "The monsters are attacking!");
        JOptionPane.showMessageDialog(null, "Get that sword right there!");
        JOptionPane.showMessageDialog(null, "Equipped Iron Sword!");
    }

    public static int characterCreator(String i){
        Object[] options = {"Swordsman", "Magic Caster"};
        int classChoice = JOptionPane.showOptionDialog(null, //Component parentComponent
                "It seems like you are a...?", //Object message,
                "Choose an option", //String title
                JOptionPane.YES_NO_OPTION, //int optionType
                JOptionPane.INFORMATION_MESSAGE, //int messageType
                null, //Icon icon,
                options, //Object[] options,
                "Swordsman");//Object initialValue
        return classChoice;
    }

    public static void afterfirst(){
        JOptionPane.showMessageDialog(null, "Wow good job...");
        JOptionPane.showMessageDialog(null, "??? The monster dropped something?");
        JOptionPane.showMessageDialog(null, "You picked up " + mainChar.getEquippedItm());
        JOptionPane.showMessageDialog(null, "Wow that's a legendary weapon!");
        JOptionPane.showMessageDialog(null, "Oh noo whoop di doopity doop it's the boss fight");



    }
    public  static void afterlast(){
        finalgui.text.showMessageDialog(null, "Ok so apparently that was the boss...");
        finalgui.text.showMessageDialog(null, "I guess we're saved now?");
        finalgui.text.showMessageDialog(null, "Thanks LMAO");
        finalgui.text.showMessageDialog(null, "You have been killed by Villager A");
        finalgui.text.showMessageDialog(null, "Save File corrupted.");
        finalgui.text.showMessageDialog(null, "Good bye.");

    }
}