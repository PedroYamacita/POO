import random

class Dado:
    def __init__(self, lados = 6, seed = None):
        self.lados = lados

        self.rnd = random.Random(seed)
        self.valor_atual = 1
        self.rolar()
        
    def rolar(self):
        self.valor_atual = self.rnd.randint(1, self.lados)
        return self.valor_atual

    def get_lado(self):
        return self.valor_atual
    
    def __str__(self):
        if self.lados != 6:
            return "Sem representacao visual"
        
        s010 = "|  *  |" 
        s100 = "|*    |"
        s001 = "|    *|"
        s000 = "|     |"
        s101 = "|*   *|"
        s111 = "|* * *|"

        faces = {
            1: [s000, s010, s000],
            2: [s100, s000, s001],
            3: [s100, s010, s001],
            4: [s101, s000, s101],
            5: [s101, s010, s101],
            6: [s111, s000, s111]
        }

        res = ["+-----+"]
        res.extend(faces[self.valor_atual])
        res.append("+-----+")
        return "\n".join(res)
    
class RolaDados:
    def __init__(self, n = 5, seed = 0):
        self.dados = []
        if seed != 0:
            rd = random.Random()
            rd.seed(seed)

        for i in range(n):
            if seed == 0:
                d = Dado()
            else:
                d = Dado(6, rd.randint(1, 10000))
            self.dados.append(d)

    def rolar_todos(self):
        return [d.rolar() for d in self.dados]
    
    def rolar_alguns(self, indices):
        indices_para_rolar = []
        for indice in indices.split():
            if indice.isdigit():
                idx = int(indice) - 1
                if 0 <= idx < len(self.dados):
                    indices_para_rolar.append(idx)
        
        for i in range(len(self.dados)):
            if i in indices_para_rolar:
                self.dados[i].rolar()
            
        return [d.get_lado() for d in self.dados]
    
    def __str__(self):
        all_dice_strs = [str(d).split('\n') for d in self.dados]
        result = ""
        for i in range(len(all_dice_strs[0])):
            line = ""
            for d_str in all_dice_strs:
                line += d_str[i] + "    "
            result += line + "\n"
        return result