
import enums.EnumsBaraja;

import java.util.Random;
import java.util.Scanner;

public class Baraja {

    //la clase baraja va a tener metodos para las acciones(barajar,repartir,sacar,jugar, etc)

    private Carta[] baraja;
    private int siguienteCarta;

    //metodo para crear baraja
    public Baraja() {
        baraja = new Carta[40];
        siguienteCarta = 0;
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        int i = 0;
        for (EnumsBaraja.Palo palo : EnumsBaraja.Palo.values()) {
            for (int num : numeros) {
                baraja[i++] = new Carta(num, palo);
            }
        }
    }
    //metodo para mezclar las cartas
    public void barajar() {
        Random rdm = new Random();
        for (int i = baraja.length - 1; i > 0; i--) {
            int j = rdm.nextInt(i + 1);
            Carta a = baraja[i];
            baraja[i] = baraja[j];
            baraja[j] = a;
        }
    }
    //metodo para sacar la siguiente carta
    public Carta SacarCarta() {
        if (siguienteCarta >= baraja.length) {
            return null;
        }
        return baraja[siguienteCarta++];
    }
    //metodo para mostrar la cantidad cartas disponibles
    public int cartasDisponibles() {
        return baraja.length - siguienteCarta;
    }
    //metodo para imprimir cada carta disponible
    public void mostrarCartasDisponibles() {
        for (int i = siguienteCarta; i < baraja.length; i++) {
            System.out.println(baraja[i]);
        }
    }
    //metodo para jugar Mayor o menor
    public void partida() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Bienvenido a Mayor o menor, selecciona una opción:\n1.Jugar\n2.Reglas\n3.Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

                switch (opcion) {
                    case 1:
                        barajar();
                        siguienteCarta = 0;

                        Carta cartaActual = SacarCarta();
                        System.out.println("La primer carta es:" + cartaActual);

                        for (int i = 0; i < 4; i++) {
                            System.out.println("La siguiente carta es mayor o menor? (+ para mayor, - para menor)");
                            String prediccion = scanner.nextLine();
                            Carta cartaSiguiente = SacarCarta();

                            if (prediccion.equals("+")) {
                                if (cartaSiguiente.getNum() > cartaActual.getNum()) {
                                    System.out.println("Correcto! +10 pts carta: " + cartaSiguiente);
                                } else {
                                    System.out.println("Incorrecto +0pts. carta:" + cartaSiguiente);
                                }
                            } else if (prediccion.equals("-")) {
                                if (cartaSiguiente.getNum() < cartaActual.getNum()) {
                                    System.out.println("Correcto! +10 pts.carta:" + cartaSiguiente);
                                } else {
                                    System.out.println("Incorrecto + 0pts. carta:" + cartaSiguiente);
                                }
                            } else {
                                System.out.println("Entrada no válida. Por favor, ingresa '+' para mayor o '-' para menor.");
                                i--;
                                continue;
                            }
                            cartaActual = cartaSiguiente;
                            System.out.println("\n");
                        }
                        break;

                    case 2:
                        System.out.println("---------------REGLAS---------------");
                        System.out.println("Se muestra una carta inicial y se debe adivinar si la proxima será mayor o menor");
                        System.out.println("Los empates se tomaran como incorrectos (0pts.)");
                        System.out.println("Las partidas tendran 5 rondas, para ganar se deben obtener al menos 30pts.");
                        System.out.println("-------------------------------------");
                        break;

                    case 3:
                        System.out.println("Gracias por jugar!!");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
                }
            }
        }
    }






