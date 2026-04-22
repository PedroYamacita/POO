class Placar:
    def __init__(self):
        self.posicoes = [0] * 10
        self.ocupado = [False] * 10

    def add(self, posicao, dados):
        if not (1 <= posicao <= 10) or self.ocupado[posicao - 1]:
            raise ValueError("Posição ocupada ou inexistente.")
        
        v = sorted(dados)
        pontos = 0

        if 1 <= posicao <= 6:
            pontos = dados.count(posicao) * posicao
        elif posicao == 7:
            if (v[0] == v[1] == v[2] and v[3] == v[4]) or (v[0] == v[1] and v[2] == v[3] == v[4]):
                pontos = 15
        elif posicao == 8:
            if all(v[i] == v[i+1] - 1 for i in range(4)):
                pontos = 20
        elif posicao == 9:
            if (v[0] == v[3]) or (v[1] == v[4]):
                pontos = 30
        elif posicao == 10:
            if v[0] == v[4]:
                pontos = 40

        self.posicoes[posicao - 1] = pontos
        self.ocupado[posicao - 1] = True

    def get_score(self):
        total = 0
        for i in range(10):
            if self.ocupado[i]:
                total += self.posicoes[i]
        return total
    
    def __str__(self):
        def fmt(i):
            idx = i - 1
            if self.ocupado[idx]:
                val = str(self.posicoes[idx])
                if i in [1, 2, 3]: return f" {val:<6}"   
                if i in [4, 5, 6]: return f"   {val:<5}"  
                return f"    {val:<6}"                    
            else:
                if i in [1, 2, 3]: return f"({i})    "   
                if i in [4, 5, 6]: return f"  ({i})  "   
                if i == 10:        return "   (10)   "    
                return f"   ({i})    "                    

        sep = "-------|----------|-------\n"
        l1 = f"{fmt(1)}|{fmt(7)}|{fmt(4)}".rstrip() + "\n"
        l2 = f"{fmt(2)}|{fmt(8)}|{fmt(5)}".rstrip() + "\n"
        l3 = f"{fmt(3)}|{fmt(9)}|{fmt(6)}".rstrip() + "\n"
        l4 = f"       |{fmt(10)}|".rstrip() + "\n"
        
        return l1 + sep + l2 + sep + l3 + sep + l4 + "       +----------+\n"