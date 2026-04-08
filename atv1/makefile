# Variáveis
JC = javac
JVM = java
MAIN = Main

# Arquivos fonte
SOURCES = Tabuleiro.java Main.java
CLASSES = $(SOURCES:.java=.class)

all: $(CLASSES)

%.class: %.java
	$(JC) $<

run: all
	$(JVM) $(MAIN)


clean:
	rm -f *.class
