package org.karo.eg66;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Torneo torneo = new Torneo();
        Interfaz1 interfaz1 = new Interfaz1();
        Inscripcion inscripcion = new Inscripcion(torneo);
        PantallaPrincipalInicio pantallaPrincipalInicio = new PantallaPrincipalInicio();
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal(inscripcion,interfaz1,pantallaPrincipalInicio);
        pantallaPrincipalInicio.setInterfazPrincipal(interfazPrincipal);
        interfaz1.setInterfazPrincipal(interfazPrincipal);
        inscripcion.setInterfazPrincipal(interfazPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(interfazPrincipal.getPanelInterfazPrincipal());
        frame.setVisible(true);
    }
}