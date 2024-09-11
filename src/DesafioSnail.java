import java.util.ArrayList;
import java.util.List;

public class DesafioSnail {
    public static List<Integer> percorrerMatriz(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        // Verifica se a matriz está vazia
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return resultado; // Retorna uma lista vazia se a matriz estiver vazia
        }

        int top = 0, bottom = matriz.length - 1;
        int left = 0, right = matriz[0].length - 1;

        while (top <= bottom && left <= right) {
            // Percorre da esquerda para a direita na linha superior
            for (int i = left; i <= right; i++) {
                resultado.add(matriz[top][i]);
            }
            top++; // Atualiza o limite superior

            // Percorre de cima para baixo na coluna direita
            for (int i = top; i <= bottom; i++) {
                resultado.add(matriz[i][right]);
            }
            right--; // Atualiza o limite da direita

            if (top <= bottom) {
                // Percorre da direita para a esquerda na linha inferior
                for (int i = right; i >= left; i--) {
                    resultado.add(matriz[bottom][i]);
                }
                bottom--; // Atualiza o limite inferior
            }

            if (left <= right) {
                // Percorre de baixo para cima na coluna esquerda
                for (int i = bottom; i >= top; i--) {
                    resultado.add(matriz[i][left]);
                }
                left++; // Atualiza o limite esquerdo
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Teste com matriz 3x3
        int[][] matriz1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Teste com matriz 3x3, valores diferentes
        int[][] matriz2 = {
                {1, 2, 3},
                {4, 10, 12},
                {6, 7, 33}
        };

        // Teste com matriz vazia
        int[][] matrizVazia = {};

        // Exibe os resultados
        System.out.println(percorrerMatriz(matriz1)); // Saída: [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(percorrerMatriz(matriz2)); // Saída: [1, 2, 3, 12, 33, 7, 6, 4, 10]
        System.out.println(percorrerMatriz(matrizVazia)); // Saída: []
    }
}
