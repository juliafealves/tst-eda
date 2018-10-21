import java.util.*;

/**
 * Word Cloud
 * Word cloud é uma forma gráfica de apresentar as palavras de um determinado texto. Nela, as palavras assumem tamanho proporcional às suas frequências no texto original. Assim, uma biblioteca que desenha uma wordcloud deve usar como informação cada palavra contida no texto sob análise e sua respectiva frequência.
 * Seu objetivo nessa questão é fornecer a informação necessária para o construtor de word cloud, isto é, as palavras e suas respectivas frequências. Para isso, implemente um programa que receba uma String representando o texto a ser analisado e retorne essa informação.
 *
 * Importante:
 * i) considere que a string passada como parâmetro é grande e um algoritmo O(n**2) seria inviável
 * ii) você deve escolher a estrutura de dados adequada para o cálculo da frequência baseado no que vimos em sala de aula.
 *
 * Entrada
 * Seu programa deve ler da entrada padrão o texto a ser analisado e uma sequência de consultas de palavras até que a palavra fim seja lida. Para cada consulta, seu programa deve imprimir a frequência do termo consultado.
 * Você pode assumir que a palavra fim não faz parte do texto a ser analisado.
 *
 * Saída
 * Seu programa deve imprimir para cada termo do texto analisado a sua respectiva frequência.
 */
class WordCloud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        while (!text.contains("fim")) {
            countFrequency(text);
            text = scanner.nextLine();
        }
    }

    static void countFrequency(String text) {
        String[] words = text.trim().split(" ");
        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (String word : words) {
            if(frequency.containsKey(word)) {
                int count = frequency.get(word);
                frequency.put(word, count + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        for (String key : frequency.keySet()) {
            System.out.println(key);
            System.out.println(frequency.get(key));
        }
    }
}
