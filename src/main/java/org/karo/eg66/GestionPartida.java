package org.karo.eg66;

public class GestionPartida {
    Resultado resultadoJugador1;
    Resultado resultadoJugador2;
    Partida partida;
    String resultadoPartida;

    public GestionPartida(Partida partida) {
        this.partida = partida;
    }
    public void otorgarPuntos () {
        if (resultadoJugador1 == Resultado.VICTORIA) {
            partida.jugador1.setPuntaje(partida.jugador1.getPuntaje() + 20);
            partida.jugador2.setPuntaje(partida.jugador2.getPuntaje() - 10);
            resultadoPartida = ("GANO: " + partida.jugador1.getNombre() + "\n PERDIO: " + partida.jugador2.getNombre() );
            partida.resultado = resultadoPartida;
        }
        else if (resultadoJugador2 == Resultado.VICTORIA) {
            partida.jugador2.setPuntaje(partida.jugador2.getPuntaje() + 20);
            partida.jugador1.setPuntaje(partida.jugador1.getPuntaje() - 10);
            resultadoPartida = ("GANO: " + partida.jugador2.getNombre() + "\n PERDIO: " + partida.jugador1.getNombre() );
            partida.resultado = resultadoPartida;
        }
        else {
            partida.resultado = "EMPATE";
        }

    }
}
