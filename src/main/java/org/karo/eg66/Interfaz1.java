package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz1 {
    private JLabel lblTitle;
    private JButton btnInscribir;
    private JPanel panelInterfaz1;


    public Interfaz1() {
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanelInterfaz1() {
        return panelInterfaz1;
    }
}
