package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    private JButton rechnen = null;
    private JButton beenden = null;
    private JPanel centerPanel = null;
    private JPanel southPanel = null;
    private JTextField euroField = null;
    private JTextField dollarField = null;


    public Fenster() {
        super("Simple Swing Demo");
        //setSize(300, 300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                dispose();
            }
        });

        // Hauptmaske
        setLayout(new BorderLayout());


        add(getCenterPanel(), BorderLayout.CENTER);
        add(getSouthPanel(), BorderLayout.SOUTH);
        pack();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new  Fenster().setVisible(true));

    }

    private JButton getRechnen() {
        if( rechnen == null ) {
            rechnen = new JButton("Rechnen");

        }
        return rechnen;
    }

    private JButton getBeenden() {
        if( beenden == null ) {
            beenden = new JButton("Beenden");

        }
        return beenden;
    }

    private JPanel getCenterPanel() {
        if( centerPanel == null ) {
            centerPanel = new JPanel(new GridLayout(2, 2));
            centerPanel.add(new JLabel("Euro: "));
            centerPanel.add(getEuroField());
            centerPanel.add(new JLabel("Dollar: "));
            centerPanel.add(getDollarField());
        }
        return centerPanel;
    }

    private JPanel getSouthPanel() {
        if( southPanel == null ) {
            southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            southPanel.add(getRechnen());
            southPanel.add(getBeenden());
        }
        return southPanel;
    }

    private JTextField getEuroField() {
        if( euroField == null )
            euroField = new JTextField(10);
        return euroField;
    }

    private JTextField getDollarField() {
        if( dollarField == null )
            dollarField = new JTextField(10);
        return dollarField;
    }

}
