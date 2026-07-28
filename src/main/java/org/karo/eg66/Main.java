package org.karo.eg66;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        TorneoEstructuras torneo = new TorneoEstructuras();
        InterfazInicial interfaz1 = new InterfazInicial(torneo);
        Inscripcion inscripcion = new Inscripcion(torneo);
        InicioSesion pantallaPrincipalInicio = new InicioSesion();
        InterfazCompleta interfazCompleta = new InterfazCompleta(torneo);
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal(inscripcion,interfaz1,pantallaPrincipalInicio,interfazCompleta);
        pantallaPrincipalInicio.setInterfazPrincipal(interfazPrincipal);
        interfaz1.setInterfazPrincipal(interfazPrincipal);
        inscripcion.setInterfazPrincipal(interfazPrincipal);
        interfazCompleta.setInterfazPrincipal(interfazPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(interfazPrincipal.getPanelInterfazPrincipal());
        frame.setVisible(true);
    }
}