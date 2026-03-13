package de.db.gui;




import de.db.gui.presenter.Euro2DollarPresenter;

import javax.swing.*; // Swing statt java.awt.*
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Euro2DollarRechnerViewImpl extends JFrame implements de.db.gui.Euro2DollarRechnerView {

    private static final long serialVersionUID = 1L;

    // Swing nutzt JComponents
    private JPanel centerPanel = null;
    private JPanel southPanel = null;
    private JTextField txtEuro = null;
    private JTextField txtDollar = null;
    private JButton btnRechnen = null;
    private JButton btnEnde = null;

    private transient Euro2DollarPresenter presenter;

    public Euro2DollarRechnerViewImpl() {
        // JFrame Standard-Verhalten beim Schließen
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (presenter != null) {
                    presenter.onBeenden();
                }
            }
        });

        // Komponenten hinzufügen
        add(getCenterPanel(), BorderLayout.CENTER);
        add(getSouthPanel(), BorderLayout.SOUTH);

        setTitle("Euro zu Dollar Rechner");
        pack();
        setLocationRelativeTo(null); // Zentriert das Fenster
    }

    // --- Presenter Logic ---

    @Override
    public Euro2DollarPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Euro2DollarPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public boolean isRechnenEnabled() {
        return getBtnRechnen().isEnabled();
    }

    @Override
    public void setRechnenEnabled(boolean enabled) {
        getBtnRechnen().setEnabled(enabled);
    }

    @Override
    public String getEuro() {
        return getTxtEuro().getText();
    }

    @Override
    public void setEuro(String euro) {
        getTxtEuro().setText(euro);
    }

    @Override
    public String getDollar() {
        return getTxtDollar().getText();
    }

    @Override
    public void setDollar(String dollar) {
        getTxtDollar().setText(dollar);
    }

    // --- Komponenten-Fabrik (Lazy Loading) ---

    private JPanel getCenterPanel() {
        if(centerPanel == null) {
            // Swing JPanels haben standardmäßig FlowLayout, wir setzen GridLayout
            centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
            centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding
            centerPanel.add(new JLabel("Euro:"));
            centerPanel.add(getTxtEuro());
            centerPanel.add(new JLabel("Dollar:"));
            centerPanel.add(getTxtDollar());
        }
        return centerPanel;
    }

    private JPanel getSouthPanel() {
        if(southPanel == null) {
            southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            southPanel.add(getBtnRechnen());
            southPanel.add(getBtnEnde());
        }
        return southPanel;
    }

    private JTextField getTxtEuro() {
        if(txtEuro == null) {
            txtEuro = new JTextField(20);

            // In Swing nutzt man für Textänderungen lieber einen DocumentListener
            // anstatt des veralteten TextListeners von AWT.
            txtEuro.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) { check(); }
                public void removeUpdate(DocumentEvent e) { check(); }
                public void insertUpdate(DocumentEvent e) { check(); }

                private void check() {
                    if(presenter != null) presenter.updateRechnenActionState();
                }
            });
        }
        return txtEuro;
    }

    private JTextField getTxtDollar() {
        if(txtDollar == null) {
            txtDollar = new JTextField(20);
            txtDollar.setEditable(false);
            txtDollar.setBackground(Color.LIGHT_GRAY); // Optisches Feedback für Read-Only
        }
        return txtDollar;
    }

    private JButton getBtnRechnen() {
        if(btnRechnen == null) {
            btnRechnen = new JButton("Rechnen");
            btnRechnen.setEnabled(false);
            btnRechnen.addActionListener(e -> presenter.onRechnen());
        }
        return btnRechnen;
    }

    private JButton getBtnEnde() {
        if(btnEnde == null) {
            btnEnde = new JButton("Ende");
            btnEnde.addActionListener(e -> presenter.onBeenden());
        }
        return btnEnde;
    }
}