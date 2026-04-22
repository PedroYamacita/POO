import sys
from dados import RolaDados
from placar import Placar

try:
    semente_input = input("Digite a semente (zero para aleatório): ").strip()
    seed = int(semente_input) if semente_input else 0
except ValueError:
    seed = 0

rd = RolaDados(5, seed)
pl = Placar()

print(pl)

for rodada in range(1, 11):
    print(f"****** Rodada {rodada}")
    input("Pressione ENTER para lançar os dados")

    valores = rd.rolar_todos()
    print("\n1          2          3          4          5")
    print(rd)

    for _ in range(2):
        muda = input("Digite os números dos dados que quiser TROCAR. Separados por espaços.\n")
        valores = rd.rolar_alguns(muda)
        print("1          2          3          4          5")
        print(rd)

    print("\n\n")
    print(pl)

    while True:
        try:
            pos = int(input("Escolha a posição que quer ocupar com essa jogada ===> "))
            pl.add(pos, valores)
            break
        except (ValueError, IndexError):
            print("Valor inválido. Posição ocupada ou inexistente.")

    print("\n\n")
    print(pl)

print("***********************************")
print("***")
print(f"*** Seu escore final foi: {pl.get_score()}")
print("***")
print("***********************************")