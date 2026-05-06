import java.util.*;

public class Mao {
    private Baralho baralho;
    private Carta[] mao;
    private ArrayList<Carta> descarte;

    public Mao(Baralho baralho) {
        this.baralho = baralho;
        this.mao = new Carta[5];
        this.descarte = new ArrayList<>();
        this.baralho.embaralhar();
    }

    public void distribuirMao() {
        for (int i = 0; i < 5; i++) {
            mao[i] = baralho.removeTopo();
        }
    }

    public void trocarCartas(String entrada) {
        if (entrada.trim().isEmpty()) return;
        String[] partes = entrada.trim().split("\\s+");
        ArrayList<Integer> indices = new ArrayList<>();

        for (String p : partes) {
            int idx = Integer.parseInt(p) - 1;
            if (idx >= 0 && idx < 5) indices.add(idx);
        }
        Collections.sort(indices);

        for (int idx : indices) {
            descarte.add(mao[idx]);
            mao[idx] = baralho.removeTopo();
        }
    }

    public void finalizarRodada() {
        for (Carta c : mao) baralho.adicionarFim(c);
        baralho.adicionarLista(descarte);
        descarte.clear();
        baralho.embaralhar();
    }

    public void imprimirMao() {
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print("+-----+ ");
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print("|     | ");
        System.out.println();
        for (Carta c : mao) System.out.print(c + " ");
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print("|     | ");
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print("+-----+ ");
        System.out.println();
        for (int i = 1; i <= 5; i++) System.out.printf("  (%d)   ", i);
        System.out.println();
    }

    public int verificarMao() {
        int[] valores = new int[5];
        char[] naipes = new char[5];
        Map<Integer, Integer> contagem = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            valores[i] = mao[i].getValor();
            naipes[i] = mao[i].getNaipe();
            contagem.put(valores[i], contagem.getOrDefault(valores[i], 0) + 1);
        }
        Arrays.sort(valores);

        boolean flush = true;
        for (int i = 1; i < 5; i++) if (naipes[i] != naipes[0]) flush = false;

        boolean straight = true;
        for (int i = 1; i < 5; i++) if (valores[i] != valores[i - 1] + 1) straight = false;

        if (straight && flush && valores[0] == 10) return 200;
        if (straight && flush) return 100;
        if (contagem.containsValue(4)) return 50;
        if (contagem.containsValue(3) && contagem.containsValue(2)) return 20;
        if (flush) return 10;
        if (straight) return 5;
        if (contagem.containsValue(3)) return 2;

        int pares = 0;
        for (int v : contagem.values()) if (v == 2) pares++;
        return (pares == 2) ? 1 : 0;
    }
}