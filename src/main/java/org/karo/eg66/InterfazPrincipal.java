package org.karo.eg66;

import javax.swing.*;

public class InterfazPrincipal {
    private JPanel panelInterfazPrincipal;
    Inscripcion inscripcion;
    Interfaz1 interfaz1;


    public InterfazPrincipal(Inscripcion inscripcion,  Interfaz1 interfaz1) {
        this.inscripcion = inscripcion;
        this.interfaz1 = interfaz1;
        panelInterfazPrincipal.add(interfaz1.getPanelInterfaz1());
    }





    public JPanel getPanelInterfazPrincipal() {
        return panelInterfazPrincipal;
    }
}
