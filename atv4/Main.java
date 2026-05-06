import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Semente: ");
        long seed = sc.nextLong();
        System.out.print("Saldo inicial: ");
        int saldo = sc.nextInt();
        sc.nextLine();

        Baralho baralho = new Baralho(seed);
        Mao deck = new Mao(baralho);

        while (true) {
            if (saldo <= 0) {
                System.out.println("Seu saldo acabou. Tente jogar outra vez.");
                break;
            }
            System.out.println("Saldo atual: $" + saldo);
            System.out.print("Digite o valor da aposta of 'F' para terminar ==> ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("F")) {
                System.out.println("Terminando o jogo... Parabéns você ainda tem saldo de $" + saldo);
                break;
            }

            int aposta = Integer.parseInt(entrada);
            if (aposta <= 0 || aposta > saldo) {
                System.out.println("Saldo insuficiente. Tecle enter para continuar");
                sc.nextLine();
                continue;
            }

            saldo -= aposta;
            deck.distribuirMao();

            for (int i = 0; i < 2; i++) {
                deck.imprimirMao();
                System.out.print("Digite o número das cartas que você deseja trocar, separados por espaços: ");
                deck.trocarCartas(sc.nextLine());
            }

            deck.imprimirMao();
            int resultado = deck.verificarMao();
            if (resultado > 0) {
                int ganho = aposta * resultado;
                saldo += ganho;
                System.out.println("Parabéns. Você acrescentou $" + ganho + " ao seu saldo");
            } else {
                System.out.println("Peninha... não ganhou nada nessa rodada");
            }

            System.out.println("Tecle enter para continuar");
            sc.nextLine();
            deck.finalizarRodada();
        }
        sc.close();
    }
}