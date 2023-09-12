import java.util.Scanner;

public class Tablero {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Parámetros del juego:
        int TAMANO = 6;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';
        boolean Turno1 = true;

        // Tablero:
        char[][] matriz = new char[TAMANO][TAMANO];
        int[] cantidadFichas = new int[TAMANO];

        // Imprimir matriz:
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Reglas del juego:
        while(true){
            char simbolo = Simbolo_Jugador_1;
            if(!Turno1)
                simbolo = Simbolo_Jugador_2;
            System.out.println("Ingresa tu posición (X,Y)");
            int x = lector.nextInt();
            int y = TAMANO - 1 - cantidadFichas[x];
            cantidadFichas[x] += 1;
            matriz[y][x] = simbolo;

            // Imprimir matriz:
            for(int i=0; i<matriz.length; i++){
                for(int j=0; j<matriz[i].length; j++){
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            Turno1 = !Turno1;
        }
    }
}
