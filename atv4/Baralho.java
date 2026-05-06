import java.util.*;

public class Baralho {
    private ArrayList<Carta> cartas;
    private Random rand;

    public Baralho(long seed) {
        cartas = new ArrayList<>();
        char[] naipes = {'♣', '♥', '♠', '♦'};

        for (char naipe : naipes) {
            for (int valor = 2; valor <= 14; valor++) {
                cartas.add(new Carta(valor, naipe));
            }
        }
        rand = new Random(seed);
        embaralhar();
    }

    public Carta removeTopo() {
        return cartas.remove(0);
    }

    public void adicionarFim(Carta carta) {
        cartas.add(carta);
    }

    public void adicionarLista(ArrayList<Carta> lista) {
        cartas.addAll(lista);
    }

    public void embaralhar() {
        Collections.shuffle(cartas, rand);
    }
}