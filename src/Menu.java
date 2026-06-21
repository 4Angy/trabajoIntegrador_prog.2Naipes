import java.util.Scanner;
public class Menu {

    public static void main(String[] args) {
        
        Scanner menu = new Scanner(System.in);
        int opcion;

        Baraja baraja = new Baraja(); //genero la baraja

        //menu
        do {
        System.out.println("\n¿Que quieres hacer?");
        System.out.println(" 1) Barajar\n 2)Sacar una carta\n " +
                "3)Ver cantidad de cartas\n 4)Repartir \n" +
                " 5)Ver cartas repartidas \n 6)Ver cartas restantes \n7)Jugar Mayor o Menor\n8)Salir");
        opcion = menu.nextInt();

            switch (opcion) {
                case 1:
                    //mezclar cartas
                    baraja.barajar();
                    System.out.println("barajando...");
                    break;
                case 2:
                    System.out.println(baraja.SacarCarta());
                    break;
                case 3://ver cantidad de cartas
                    System.out.println("Cartas disponibles: "
                            + baraja.cartasDisponibles());
                    break;
                case 4: //repartir
                    System.out.println("¿Cuántas cartas quiere repartir?");

                    int cantidad = menu.nextInt();

                    System.out.println(
                            baraja.repartirCartas(cantidad)
                    );
                    break;
                case 5:
                    baraja.mostrarRepartidas();//ver manos
                    break;
                case 6:
                    baraja.mostrarCartasDisponibles();
                    break;
                case 7:
                    //jugar
                    baraja.partida();
                case 8:
                    //salir
                    System.out.println("¡¡ Gracias por jugar !!");
                    break;
                default:
                    //opcion invalida
                    System.out.println("Error,ingresa una opcion nuevamente");
            }

        } while (opcion != 7);

    }

}
