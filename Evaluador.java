public class Evaluador {
    public static void main(String[] args) {
        int Tamano = 6;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';
        boolean Turno1 = true;
        int x = 3;
        char simbolo = Simbolo_Jugador_1;
        boolean ConnectFour = false;

        if (!Turno1)
            simbolo = Simbolo_Jugador_2;

        int[] ys = {2, 2, 3, 4, 0, 0};

        char[][] matriz = {
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', 'X'},
                {'Y', 'Y', 'Y', 'X', ' ', ' '},
                {'Y', 'X', 'Y', 'Y', ' ', ' '},
                {'X', 'Y', 'Y', 'X', ' ', ' '}
        };

        //int[] ys = {1, 2, 3, 4, 0, 0};
        int y = Tamano - ys[x];


        int contador = 0;

        // Verifico la línea horizontal:
        for (int i = 0; i < Tamano; i++) {
            if (matriz[y][i] == simbolo) {
                contador++;
                if (contador == 4) {
                    ConnectFour = true;
                    break;
                }
            } else {
                contador = 0;
            }
        }
        // Verifico la línea vertical:
        if (!ConnectFour) {
            contador = 0;
            for (int i = 0; i < Tamano; i++) {
                if (matriz[i][x] == simbolo) {
                    contador++;
                    if (contador == 4) {
                        ConnectFour = true;
                        break;
                    }
                } else {
                    contador = 0;
                }
            }
        }
        // Verifico la diagonal principal:
        if (x == y && !ConnectFour) {
            contador = 0;
            for (int i = 0; i < Tamano; i++) {
                if (matriz[i][i] == simbolo) {
                    contador++;
                    if (contador == 4) {
                        ConnectFour = true;
                        break;
                    }
                } else {
                    contador = 0;
                }
            }
        }
        // Verifico la diagonal invertida:
        if (x + y == Tamano - 1 && !ConnectFour) {
            contador = 0;
            for (int i = 0; i < Tamano; i++) {
                if (matriz[i][Tamano - 1 - i] == simbolo) {
                    contador++;
                    if (contador == 4) {
                        ConnectFour = true;
                        break;
                    }
                } else {
                    contador = 0;
                }
            }
        }

        // Imprimir matriz:
        for (int i = 0; i < Tamano; i++) {
            for (int j = 0; j < Tamano; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        if (ConnectFour) {
            System.out.println("Es ConnectFour");
        } else {
            System.out.println("No es ConnectFour");
        }
    }
}