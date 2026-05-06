public class Carta {
    private int valor;
    private char naipe;

    public Carta(int valor, char naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public char getNaipe() {
        return naipe;
    }

    public String valorToString() {
        switch (valor) {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return String.valueOf(valor);
        }
    }

    @Override
    public String toString() {
        String valorStr = valorToString();
        if (valor == 10) {
            return String.format("| %s%s |", valorStr, naipe);
        } else {
            return String.format("|%2s %s |", valorStr, naipe);
        }
    }
}