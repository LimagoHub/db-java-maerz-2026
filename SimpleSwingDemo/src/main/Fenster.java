package main;

import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame {


    static {
        try {
            // Setzt das Design auf das native Design des Betriebssystems
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Falls das System-Design nicht geladen werden kann,
            // wird das Standard-Design beibehalten.
            System.err.println("Look and Feel konnte nicht geladen werden.");
        }

    }

    private JButton button;
    private JButton button2;


    public Fenster() {
        super("Simple Swing Demo");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        button = new JButton("Click Me!");
        add(button, BorderLayout.SOUTH);
        button2 = new JButton("Me too");
        add(button2,BorderLayout.CENTER);
    }



    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }
}
