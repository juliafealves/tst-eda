# Problemas de Estrutura de Dados.

## Problemas:

- [Fila com Arry](#fila-com-array)


## Fila com Array
Implemente uma fila com capacidade limitada utilizando array.

### Entrada
Seu programa deve ler da entrada o tamanho da fila e uma série de operações (add, remove, element e print). 
A leitura de operações deve ser encerrada com a palavra `"end"`.

### Saída
Seu programa deve imprimir o conteúdo da fila sempre que uma operação **print** for lida. Se a fila estiver vazia, imprima 
`"empty"`. Se estiver cheia, imprima `"full"`.

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