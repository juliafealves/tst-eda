# Problemas de Estrutura de Dados.

## Problemas:

- [Fila com Array](#fila-com-array)
- [Pilha com Array](#pilha-com-array)
- [Tabela Hash Chaining](#tabela-hash-chaining)
- [Tabela Hash Probing](#tabela-hash-probing)
- [HashSet](#hashset)
- [Valor mais próximo de N em uma árvore binária de pesquisa](#valor-mais-proximo-de-n-em-uma-arvore-binaria-de-pesquisa)


## Fila com Array
Implemente uma fila com capacidade limitada utilizando array.

### Entrada
Seu programa deve ler da entrada o tamanho da fila e uma série de operações (add, remove, element e print). 
A leitura de operações deve ser encerrada com a palavra `"end"`.

### Saída
Seu programa deve imprimir o conteúdo da fila sempre que uma operação **print** for lida. Se a fila estiver vazia, imprima 
`"empty"`.

Seu programa deve imprimir o elemento inicial da fila quando ler a operação **element**.
Se a fila estiver vazia e for lida a operação **remove**, imprima `"empty"`.
Se a fila estiver cheia e for lida a operação **add**, imprima `"full"`.

### Exemplo de execução

```
$ javac Solution.java; java Solution
3
print
empty
add 2
element
2
add 5
print
2 5
remove
print
5
add 11
add 18
add 20
full   
remove
remove
remove
remove
empty
end
```

### Restrições e Observações
Você não pode usar coleção ou método algum do Collections framework. Sua implementação deve ser baseada em arrays.

## Pilha com Array
Implemente uma pilha com capacidade limitada utilizando array.

### Entrada
Seu programa deve ler da entrada o tamanho da pilha e uma série de operações (pop, push, peek e print). A leitura de 
operações deve ser encerrada com a palavra `"end"`.

### Saída
Seu programa deve imprimir o conteúdo da pilha sempre que uma operação print for lida. Se a pilha estiver vazia, 
imprima `"empty"`.

Seu programa deve imprimir o elemento no topo da pilha quando ler a operação **peek**.

Se a pilha estiver vazia e for lida a operação **pop**, imprima `"empty"`.

Se a pilha estiver cheia e for lida a operação **push**, imprima `"full"`.

### Exemplo de execução
```
$ javac Solution.java; java Solution
3
print
empty
push 2
peek
2
push 5
peek
5
print
2 5 
pop
print
2 
push 11
push 18
push 20
full
print
2 11 18
pop
pop
pop
pop
empty
end
```
### Restrições e Observações
Você não pode usar coleção ou método algum do Collections framework. Sua implementação deve ser baseada em arrays.

## Tabela Hash Chaining

Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.

Uma das maneiras de se resolver colisões é, ao invés de armazenar o par em uma posição da tabela, armazenar uma fila contendo todos os pares que forem mapeados para aquela posição.

Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.

A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por chaining.

Sua tabela deve ter as seguintes funções:
```
- put <chave> <valor>
- remove <chave>
- keys
- values
```
**Importante!** Para facilitar os testes, sua tabela sempre terá a seguinte função de hash:
```
hash(key) = key % M, onde M é o tamanho da tabela
```

### Entrada
Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove, keys, e values).
```
- put: adiciona o par chave,valor na tabela
- remove: remove o par cuja chave é igual a chave passada como parâmetro
- keys: imprime em ordem as chaves da tabela. Você pode usar Arrays.sort para isso.
- values: imprime em ordem os valores da tabela. Você pode usar Arrays.sort para isso.
```
A leitura de operações deve ser encerrada com a palavra `"end"`.

### Saída
Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.

Sempre que seu programa ler as operações put e remove, ele deve imprimir o estado da tabela após a execução dessas operações.

### Restrições
```
- Sua tabela deve ser baseada em arrays. Contudo, as listas dentro da tabela devem ser do tipo ArrayList.
- A função de hash deve ser sempre a mesma: key % M, onde M é o tamanho da tabela.
- Crie a classe TabelaHash para organizar o seu código. 
- Crie uma classe Pair como abstração para chave e valor.
```

### Exemplo de execução
```
$ javac Solution.java; java Solution
5
keys
[]
values
[]
put 10 joao
[[<10, joao>], [], [], [], []]
keys
[10]
values
[joao]
put 1 carlos
[[<10, joao>], [<1, carlos>], [], [], []]
put 11 pedro
[[<10, joao>], [<1, carlos>, <11, pedro>], [], [], []]
put 14 liu
[[<10, joao>], [<1, carlos>, <11, pedro>], [], [], [<14, liu>]]
remove 10
[[], [<1, carlos>, <11, pedro>], [], [], [<14, liu>]]
put 1 leticia
[[], [<1, leticia>, <11, pedro>], [], [], [<14, liu>]]
keys
[1, 11, 14]
values
[leticia, liu, pedro]
end
```

## Tabela Hash Probing

Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.

Uma das maneiras de se resolver colisões é, caso o hash da chave seja mapeado para uma posição já ocupada, o algoritmo de inserção procura por uma outra posição livre para inserir o par . A essa estratégia, dá-se o nome de resolução de colisões por endereçamento aberto. Em particular, quando a tentativa é sempre verificar a próxima posição da tabela, diz-se que a estratégia utiliza um probing linear.

Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.

A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por endereçamento aberto e probing linear.

Sua tabela deve ter as seguintes funções:
```
- put <chave> <valor>
- remove <chave>
- keys
- values
```
Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função base de hash:
```
hash(key, i) = (hash(key) + i) % M, onde M é o tamanho da tabela, i é o probe.
```
**Importante!** Caso a tabela já esteja completamente cheia durante uma inserção, basta não adicionar o novo par. Contudo, mesmo que a operação não seja realizada, imprima o conteúdo da tabela.

### Entrada
Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove, keys, e values).
```
- put: adiciona o par chave,valor na tabela
- remove: remove o par cuja chave é igual a chave passada como parâmetro
- keys: imprime em ordem as chaves da tabela. Você pode usar Arrays.sort para isso.
- values: imprime em ordem os valores da tabela. Você pode usar Arrays.sort para isso.
```
A leitura de operações deve ser encerrada com a palavra `"end"`.

### Saída
Seu programa deve imprimir o conteúdo da tabela sempre após as operações put e remove forem efetuadas. Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.

### Restrições
```
- Sua tabela deve ser baseada em arrays. 
- A função de hash deve ser sempre a mesma (exceto pelo probing): key % M, 
onde M é o tamanho da tabela.
- Crie a classe TabelaHash para organizar o seu código. 
- Crie uma classe Pair como abstração para chave e valor.
```
Lembre-se: tst vai testar apenas a entrada e saída do seu programa. Isso significa que você deve construir o main que leia os dados da entrada padrão manipula a sua Fila e imprime o que se espera na saída.

### Exemplo de execução
```
$ javac Solution.java; java Solution
5
put 0 joao
[<0, joao>, null, null, null, null]
put 4 leticia
[<0, joao>, null, null, null, <4, leticia>]
put 20 carlos
[<0, joao>, <20, carlos>, null, null, <4, leticia>]
put 0 pedro
[<0, pedro>, <20, carlos>, null, null, <4, leticia>]
remove 20
[<0, pedro>, null, null, null, <4, leticia>]
keys
[0, 4]
values
[leticia, pedro]
end
```

## HashSet

HashSets implementam a noção matemática de conjunto em Java, isto é, não permitem elementos repetidos. HashSets são estruturas bem semelhantes à Tabelas Hash no que diz respeito à implementação, pois também podem ser baseadas em arrays e utilizam funções de hash para determinar onde armazenar o valor passado. Contudo, uma grande diferença é que eles não armazenam , mas apenas os valores.

Devido à natureza das funções de hash que utilizamos na construção de HashSets, colisões são inevitáveis. Isto é, para algum par de valores, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição.

Uma das maneiras de se resolver colisões é, caso o hash seja mapeado para uma posição já ocupada, o algoritmo de inserção procura por uma outra posição livre para inserir o valor. A essa estratégia, dá-se o nome de resolução de colisões por endereçamento aberto. Em particular, quando a tentativa é sempre verificar a próxima posição livre do array, diz-se que a estratégia utiliza um probing linear.

Implemente um programa que leia da entrada padrão operações em um HashSet imprima o seu estado sempre que as operações put e remove forem efetuadas.

O HashSet deve armazenar valores inteiros e deve resolver colisões por endereçamento aberto e probing linear.

Seu HashSet deve ter as seguintes funções:
```
- put <valor>
- remove <valor> 
- contains <valor>
```
**Importante!** Para facilitar os testes, seu HashSet sempre terá a seguinte função base de hash:
```
hash(key, i) = (hash(key) + i) % M, onde M é o tamanho do HashSet, i é o probe.
```
**Importante!** Caso o conjunto já esteja completamente cheio durante uma inserção, basta não adicionar o novo valor. Contudo, mesmo que a operação não seja realizada, imprima o conteúdo do conjunto.

### Entrada
Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove e contains).
```
- put: adiciona um valor no conjunto 
- remove: remove o valor do conjunto
- contains: verifica se o conjunto contém um valor passado como parâmetro.
```
A leitura de operações deve ser encerrada com a palavra `"end"`.

### Saída
Seu programa deve imprimir o conteúdo do HashSet sempre que as operações put e remove forem efetuadas. Quando a operação contains for lida, seu programa deve imprimir true ou false.

### Restrições
```
- Seu HashSet deve ser baseado em arrays. 
- A função de hash deve ser sempre a mesma (exceto pelo probing): key % M, 
onde M é o tamanho do conjunto.
- Crie a classe HashSet para organizar o seu código. 
```

### Exemplo de execução
```
$ javac Solution.java; java Solution
5
put 0
[0, null, null, null, null]
put 14
[0, null, null, null, 14]
put 20
[0, 20, null, null, 14]
put 0
[0, 20, null, null, 14]
contains 20
true
remove 20
[0, null, null, null, 14]
contains 20
false
end
```

## Valor mais próximo de N em uma árvore binária de pesquisa
Escreva um programa que leia os números a serem adicionados em uma BST e um número N sobre o qual se deseja encontrar o valor mais próximo a ele presente na árvore.

### Restrições
```
- Não é permitido procurar por sucessor ou predecessor. Ainda que fosse, N 
não precisa ser um valor presente na árvore.
- A implementação deve ser O(h). Isto é, você não pode percorrer
toda a árvore para encontrar o elemento.
```

### Entrada
Seu programa deve ler duas linhas da entrada. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda irá conter um valor N (não necessariamente presente na árvore).
Seu programa deve encontrar na árvore o valor mais próximo de N.
Você pode assumir que não haverá elementos repetidos na árvore. Você pode assumir que não haverá empate dois valores.

### Saída
Inicialmente, seu programa deve imprimir o encaminhamento em pré-ordem da árvore lida. Depois, deve imprimir o valor mais próximo a N presente na árvore. Veja os exemplos de execução abaixo.

### Exemplos de execução
```
$ javac Solution.java; java Solution
10 8 1 9 20 18 25
23
[10, 8, 1, 9, 20, 18, 25]
25

$ javac Solution.java; java Solution
10 8 1 9 20 18 25
17
[10, 8, 1, 9, 20, 18, 25]
18
```
