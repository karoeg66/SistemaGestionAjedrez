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
            partida.getJugador1().setPuntaje(partida.getJugador1().getPuntaje() + 20);
            partida.getJugador2().setPuntaje(partida.getJugador2().getPuntaje() - 10);
            resultadoPartida = ("GANO: " + partida.getJugador1().getNombre() + "\n PERDIO: " + partida.getJugador2().getNombre() );
            partida.setResultado(resultadoPartida);
        }
        else if (resultadoJugador2 == Resultado.VICTORIA) {
            partida.getJugador2().setPuntaje(partida.getJugador2().getPuntaje() + 20);
            partida.getJugador1().setPuntaje(partida.getJugador1().getPuntaje() - 10);
            resultadoPartida = ("GANO: " + partida.getJugador2().getNombre() + "\n PERDIO: " + partida.getJugador1().getNombre() );
            partida.setResultado(resultadoPartida);
        }
        else {
            partida.setResultado("EMPATE");
        }

    }
}
