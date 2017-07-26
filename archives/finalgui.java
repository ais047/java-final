import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;

public class finalgui extends JFrame{
    private final int width = 1000;
    private final int height = 600;
    private final String msg="RPG Game (It sucks tho)";
    private Container contentpane;
    private JLabel label;
    private JPanel hero = new JPanel();
    private JPanel enemy = new JPanel();
    public static JOptionPane text =  new JOptionPane();


    public finalgui(){
        super();
        setTitle("Final Game");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentpane = getContentPane();
        contentpane.setLayout(new BorderLayout());


        buildHero();
        buildEne();

        contentpane.add(hero, BorderLayout.EAST);
        contentpane.add(enemy, BorderLayout.WEST);
        contentpane.add(text, BorderLayout.CENTER);

        label = new JLabel(msg);
        contentpane.add(label, BorderLayout.NORTH);
        setVisible(true);

    }


    public void buildHero() {
        hero.setLayout(new FlowLayout(FlowLayout.CENTER));
        hero.setBackground(Color.BLUE);
        hero.add(new LoadImageApp("src\\GoldDekaNobu.png"));

    }
    public void buildEne(){
        enemy.setLayout(new FlowLayout(FlowLayout.CENTER));
        enemy.setBackground(Color.RED);
        enemy.add(new LoadImageApp("src\\GoldDekaNobu.png"));
        enemy.remove(0);
    }

    public void main(String[] args){


    }
}
