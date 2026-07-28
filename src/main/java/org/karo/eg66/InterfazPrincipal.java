package org.karo.eg66;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal {
    private JPanel panelInterfazPrincipal;
    Inscripcion inscripcion;
    InterfazInicial interfaz1;
    InicioSesion pantallaPrincipalInicio;
    InterfazCompleta interfazCompleta;
    private CardLayout cardLayout;


    public InterfazPrincipal(Inscripcion inscripcion, InterfazInicial interfaz1, InicioSesion pantallaPrincipalInicio,InterfazCompleta interfazCompleta) {
        this.inscripcion = inscripcion;
        this.interfaz1 = interfaz1;
        this.pantallaPrincipalInicio = pantallaPrincipalInicio;
        this.interfazCompleta = interfazCompleta;
        cardLayout = (CardLayout) panelInterfazPrincipal.getLayout();
        panelInterfazPrincipal.add(interfaz1.getPanelInterfaz1(),"menu inicial");
        panelInterfazPrincipal.add(pantallaPrincipalInicio.getPanelPantallaInicio(),"inicio sesion");
        panelInterfazPrincipal.add(inscripcion.getPanelInscripcion(),"inscripcion");
        panelInterfazPrincipal.add(interfazCompleta.getPanelInterfazCompleta(), "interfaz completa");
        mostrarInicioSesion();

    }

    public void mostrarMenuInicial(){
        cardLayout.show(panelInterfazPrincipal,"menu inicial");
    }

    public void mostrarInscripcion(){
        cardLayout.show(panelInterfazPrincipal,"inscripcion");
    }

    public void mostrarInicioSesion(){
        cardLayout.show(panelInterfazPrincipal,"inicio sesion");
    }

    public void mostrarInterfazCompleta(){
        cardLayout.show(panelInterfazPrincipal,"interfaz completa");
    }


    public JPanel getPanelInterfazPrincipal() {
        return panelInterfazPrincipal;
    }
}
