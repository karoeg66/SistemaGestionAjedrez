package org.karo.eg66;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal {
    private JPanel panelInterfazPrincipal;
    Inscripcion inscripcion;
    Interfaz1 interfaz1;
    PantallaPrincipalInicio pantallaPrincipalInicio;
    private CardLayout cardLayout;


    public InterfazPrincipal(Inscripcion inscripcion,  Interfaz1 interfaz1,PantallaPrincipalInicio pantallaPrincipalInicio) {
        this.inscripcion = inscripcion;
        this.interfaz1 = interfaz1;
        this.pantallaPrincipalInicio = pantallaPrincipalInicio;
        cardLayout = (CardLayout) panelInterfazPrincipal.getLayout();
        panelInterfazPrincipal.add(interfaz1.getPanelInterfaz1(),"menu inicial");
        panelInterfazPrincipal.add(pantallaPrincipalInicio.getPanelPantallaInicio(),"inicio sesion");
        panelInterfazPrincipal.add(inscripcion.getPanelInscripcion(),"inscripcion");
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


    public JPanel getPanelInterfazPrincipal() {
        return panelInterfazPrincipal;
    }
}
