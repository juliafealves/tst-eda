# Problemas de Estrutura de Dados.

## Problemas:

- [Fila com Arry](#fila-com-array)
- [Pilha com Arry](#pilha-com-array)
- [Tabela Hash Chaining](#tabela-hash-chaining)


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
Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função de hash:
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