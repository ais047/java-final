import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

public class TextAreaLogProgram extends JFrame {
    /**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;

    private JButton buttonStart = new JButton("Next");
    private JButton buttonClear = new JButton("Clear");
    private JButton buttonAtk = new JButton("Physical Attack");
    private JButton buttonmAtk = new JButton("Magic Attack");
    private static int counter = 0;
    private PrintStream standardOut;
    private static int clas = 3;
    public TextAreaLogProgram() {
        super("Hit next to continue");

        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        add(buttonAtk, constraints);

        constraints.gridx = 3;
        add(buttonClear, constraints);

        constraints.gridx = 2;
        add(buttonStart, constraints);
        constraints.gridx = 1;
        add(buttonmAtk, constraints);
        constraints.gridx= 0;

        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        add(new JScrollPane(textArea), constraints);

        // adds event handler for button Start
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            }
        });


        buttonmAtk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(clas==3){clas=0;};

            }
        });
        buttonAtk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(clas==3){clas=1;};

            }
        });
        // adds event handler for button Clear
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // clears the text area
                try {
                    textArea.getDocument().remove(0,
                            textArea.getDocument().getLength());
                    standardOut.println("Text area cleared");
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);    // centers on screen
    }


    public static void printLog(String object) {
                    counter++;
                    System.out.println(object);
                }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextAreaLogProgram().setVisible(true);

                printLog("");
            }
        });
    }
}