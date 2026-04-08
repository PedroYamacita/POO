import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextLine()){
            sc.close();
            return;
        }

        String linhaElementos = sc.nextLine().trim();
        String[] partes = linhaElementos.trim().split("\\s+");
        int[] elementos = new int[partes.length];
        
        //transforma a string em ints para compor o tabuleiro
        for(int i = 0; i < partes.length; i++){
            elementos[i] = Integer.parseInt(partes[i]);
        }

        Tabuleiro puzzle = new Tabuleiro(elementos);
        puzzle.imprimir();
        System.out.println();

        String movimentos = sc.hasNextLine() ? sc.nextLine().trim() : "";

        //faz os movimentos e printa estado atual
        for(int i = 0; i<movimentos.length(); i++){
            puzzle.mover(movimentos.charAt(i));
            puzzle.imprimir();
            System.out.println();
        }
        System.out.println("Posicao final: " + puzzle.estaResolvido());
        sc.close();
    }
}
