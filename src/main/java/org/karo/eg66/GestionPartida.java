package org.karo.eg66;

public class GestionPartida {
    Resultado resultadoJugador1;
    Resultado resultadoJugador2;
    Partida partida;
    PantallaPartida pantallaPartida;

    public GestionPartida(Partida partida) {
        this.partida = partida;
    }
    public void otorgarPuntos () {
        if (resultadoJugador1 == Resultado.VICTORIA) {
            partida.jugador1.setPuntaje(partida.jugador1.getPuntaje() + 20);
        }
        else {
            partida.jugador1.setPuntaje(partida.jugador1.getPuntaje() - 10);
        }
        if (resultadoJugador2 == Resultado.VICTORIA) {
            partida.jugador2.setPuntaje(partida.jugador2.getPuntaje() + 20);
        }
        else {
            partida.jugador2.setPuntaje(partida.jugador2.getPuntaje() - 10);
        }

    }
}
