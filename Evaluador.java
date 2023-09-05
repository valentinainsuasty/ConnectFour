public class Evaluador {
    public static void main(String[] args) {
        int Tamano = 6;
        char Simbolo_Jugador_1 = '1';
        char Simbolo_Jugador_2 = '2';
        boolean Turno1 = true;
        int x = 2;
        int y = 2;
        char simbolo = Simbolo_Jugador_1;
        boolean esTriqui = false;

        if(!Turno1)
            simbolo = Simbolo_Jugador_2;
        
        char[][] matriz = {
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'x', ' ', ' '},
                {' ', 'y', 'x', 'x', ' ', ' '},
                {'y', 'x', 'x', 'y', ' ', ' '},
                {'x', 'y', 'y', 'x', ' ', ' '}
        };

        int contador = 0;

        // Verifico la línea horizontal:
        for(int i = 0; i < matriz.length; i++){
            if(matriz[y][i] == simbolo){
                contador += 1;
            }
        }
        esTriqui = (contador == 3);
        // Verifico la línea vertical:
        if(!esTriqui){
            contador = 0;
            for(int i = 0; i < matriz.length; i++){
                if(matriz[i][x] == simbolo){
                    contador += 1;
                }
            }
            esTriqui = (contador == 3);
            // Verifico la diagonal principal:
            if(x == y && !esTriqui){
                contador = 0;
                for(int i = 0; i < matriz.length; i++){
                    if(matriz[i][i] == simbolo){
                        contador += 1;
                    }
                }
                esTriqui = (contador == 3);
                // Verifico la diagonal invertida:
                if(x + y == Tamano - 1 && !esTriqui){
                    contador = 0;
                    for(int i = 0; i < matriz.length; i++){
                        if(matriz[i][Tamano-1-i] == simbolo){
                            contador += 1;
                        }
                    }
                    esTriqui = (contador == 3);
                }
            }
        }

        // Imprimir matriz:
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        if(esTriqui)
            System.out.println("Es Triqui");
        else
            System.out.println("NO es Triqui");
    }
}