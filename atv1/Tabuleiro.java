import java.util.Arrays;

public class Tabuleiro{
    private int[][] matriz;
    private int tam;
    private int vazioLinha, vazioColuna;

    public Tabuleiro(int[] elementos){
        this.tam = (int) Math.sqrt(elementos.length);
        this.matriz = new int[tam][tam];
        int k = 0;
        //criação do tabuleiro
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                matriz[i][j] = elementos[k++];
                if(matriz[i][j] == 0){
                    vazioLinha = i;
                    vazioColuna = j;
                }
            }
        }
    }

    public void mover(char movimento){
        int novaLinha = vazioLinha;
        int novaColuna = vazioColuna;
        // Escolha do movimento
        switch (movimento) {
            case 'u':
                novaLinha++;
                break;
            case 'd':
                novaLinha--;
                break;
            case 'l':
                novaColuna++;
                break;
            case 'r':
                novaColuna--;
                break;
            default:
                return;
        }
        //verificação se permanece dentro do tabuleiro
        if(novaLinha >= 0 && novaLinha < tam && novaColuna >=0 && novaColuna < tam){
            int temp = matriz[novaLinha][novaColuna];
            matriz[novaLinha][novaColuna] = 0;
            matriz[vazioLinha][vazioColuna] = temp;
            //atualização da posição do zero
            vazioLinha = novaLinha;
            vazioColuna = novaColuna;

        }
    }

    public boolean estaResolvido(){
        int correto = 0;
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                if(matriz[i][j] != correto++) return false;
            }
        }
        return true;
    }

    public void imprimir(){
        String linhaDivisoria = "+";
        for(int i = 0; i < tam; i++) linhaDivisoria += "------+";

        System.out.println(linhaDivisoria);
        for(int i = 0; i < tam; i++){
            System.out.print("|");
            for(int j = 0; j < tam; j++){
                System.out.printf("%4d  |", matriz[i][j]);
            }
            System.out.println("\n" + linhaDivisoria);
        }
    }
}