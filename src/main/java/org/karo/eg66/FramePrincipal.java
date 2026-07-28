package org.karo.eg66;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {
    public FramePrincipal() {
        TorneoEstructuras torneo = (TorneoEstructuras) GestorArchivos.cargar("torneo_completo.dat");
        if (torneo == null) {
            torneo = new TorneoEstructuras();
        }
        InterfazInicial interfaz1 = new InterfazInicial(torneo);
        Inscripcion inscripcion = new Inscripcion(torneo);
        InicioSesion pantallaPrincipalInicio = new InicioSesion();
        InterfazCompleta interfazCompleta = new InterfazCompleta(torneo);
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal(inscripcion,interfaz1,pantallaPrincipalInicio,interfazCompleta);
        pantallaPrincipalInicio.setInterfazPrincipal(interfazPrincipal);
        interfaz1.setInterfazPrincipal(interfazPrincipal);
        inscripcion.setInterfazPrincipal(interfazPrincipal);
        interfazCompleta.setInterfazPrincipal(interfazPrincipal);
        setTitle("Torneo Ajedrez");
        setSize(800, 600);
        add(interfazPrincipal.getPanelInterfazPrincipal());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png"));
            setIconImage(icono);
        } catch (Exception e) {
            System.out.println("No se pudo cargar el icono de la aplicación: " + e.getMessage());
        }


        TorneoEstructuras torneoFinal = torneo;
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                GestorArchivos.guardar(torneoFinal, "torneo_completo.dat");
                System.exit(0);
            }
        });
        setVisible(true);
    }
}
