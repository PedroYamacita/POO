import math

class Tabuleiro:
    def __init__(self, elementos):
        self.tam = int(math.isqrt(len(elementos)))
        self.matriz = []
        self.vazio_linha = 0
        self.vazio_coluna = 0
        
        for i in range(self.tam):
            linha = []
            for j in range(self.tam):
                val = elementos[i * self.tam + j]
                linha.append(val)
                if val == 0:
                    self.vazio_coluna = j
                    self.vazio_linha = i
            self.matriz.append(linha)        
    
    def mover(self, movimento):
        nova_linha, nova_coluna = self.vazio_linha, self.vazio_coluna

        if movimento == 'u':
            nova_linha+=1
        elif movimento == 'd':
            nova_linha-=1
        elif movimento == 'l':
            nova_coluna+=1
        elif movimento == 'r':
            nova_coluna-=1
        else:
            return
        
        if 0 <= nova_linha < self.tam and 0 <= nova_coluna <self.tam:
            temp = self.matriz[nova_linha][nova_coluna]
            self.matriz[nova_linha][nova_coluna] = 0
            self.matriz[self.vazio_linha][self.vazio_coluna] = temp

            self.vazio_linha, self.vazio_coluna = nova_linha, nova_coluna

    def esta_resolvido(self):
        correto = 0
        for i in range(self.tam):
            for j in range(self.tam):
                if self.matriz[i][j] != correto:
                    return False
                correto += 1
        return True
    
    def imprimir(self):
        linha_divisoria = "+" + "------+" * self.tam
        print(linha_divisoria)

        for i in range(self.tam):
            print("|", end="")
            for j in range(self.tam):
                val = self.matriz[i][j]
                display = f"{val:4d}" if val != 0 else "    "
                print(f"{display}  |", end="")
            print("\n" + linha_divisoria)