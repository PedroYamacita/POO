from tabuleiro import Tabuleiro
import sys

try: 
    entrada = sys.stdin.readline().strip()
    if not entrada:
        pass
    
    elementos = [int(x) for x in entrada.split()]
    puzzle = Tabuleiro(elementos)
    puzzle.imprimir()
    print()

    movimentos = sys.stdin.readline().strip()

    for mov in movimentos:
        puzzle.mover(mov)
        puzzle.imprimir()
        print()

    status = "True" if puzzle.esta_resolvido() else "False"
    print(f"Posicao final: {status}")

except EOFError:
    pass