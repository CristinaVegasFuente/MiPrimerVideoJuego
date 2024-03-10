/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package piedrapapeltijerabrain;
import java.util.Scanner;

/**
* Este programa simula un juego de Piedra, Papel o Tijera entre el jugador y 
el ordenador.
* El jugador tiene como objetivo ganar o perder, según la decisión aleatoria 
del ordenador.
* El rendimiento del jugador se evalúa al final de cinco rondas.
* Se muestra un arte ASCII para cada movimiento de la computadora.
* Hay una penalización por movimientos incorrectos, y se informa el tiempo 
total del juego.
* @author Cristina Vegas
*/
public class MiPrimerVideoJuego {

    /**
    * @param args los argumentos de la línea de comandos
    */
    public static void main(String[] args) {
        // Declaración de las variables.
        // Contador de intentos con exito del jugador.
        int chiquipuntos = 0;  
        // Objeto Scanner para entrada de movimientos del usuario.
        Scanner sc = new Scanner(System.in);  
        // Almacena la elección del jugador.
        String opcionJugador = "";  
        // Almacena la elección aleatoria del ordenador.
        String opcionBot = "";  
        // Variable para evaluar éxito o fracaso del jugador.
        int exitoEnProposito = 1;  
        // Inicia el contador del tiempo.
        long inicio = System.currentTimeMillis();  

        // Bucle principal para ejecutar el juego cinco veces.
        for (int i = 0; i < 5; i++) {
            /** La variable "proposito" selecciona aleatoriamente 
            si el jugador debe intentar ganar o perder
            */
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            } else if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }

            /** Genera un número aleatorio para la elección del ordenador, un 
            numero asociado a cada uno de los movimientos 
            (tijera, papel o piedra)
            */
            int j = (int) Math.floor(Math.random() * 3 + 1);

            // Muestra el movimiento del ordenador y llama a los métodos.
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            } else if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            } else if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }

            // Bucle para obtener la elección del jugador.
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                // Asegurándose de que sea diferente a la del ordenador.
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot.equals(opcionJugador));

            // Evalúa el resultado de la ronda y actualiza la variable de éxito
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            } else if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            } else if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            } else if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            } else if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            } else if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }

            // Invierte el resultado si el propósito original era perder.
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }

            // Incrementa el contador si la ronda ganada por el jugador.
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }

        // Finaliza el contador de tiempo.
        long fin = System.currentTimeMillis();
        // Calcula el tiempo de la partida.
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        // Calcula los fallos y la penalización.
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        // Calcula el tiempo final
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
             
    }

    // Métodos para mostrar arte ASCII correspondiente a cada movimiento.
    public static void tijera() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " __________)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }

    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " _______)\n"
                + " _______)\n"
                + "---.__________)\n"
                + "'''");
    }

    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + " (_____)\n"
                + " (_____)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}
