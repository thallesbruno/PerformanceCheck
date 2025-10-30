import java.util.*;

/**
 * Classe principal para testar e comparar a performance
 * das principais estruturas de dados da Java Collections Framework (JCF).
 */
public class PerformanceTest {

    // Quantidade de elementos que será usada nos testes de performance
    private static final int ELEMENTS = 100_000;

    public static void main(String[] args) {
        // Criação de diferentes implementações de List (interface):
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Criação de diferentes implementações de Set (interface):
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        // Criação de diferentes implementações de Map (interface):
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("=== TESTE DE PERFORMANCE DAS COLLECTIONS ===\n");

        // Teste de performance para cada tipo de estrutura
        testListPerformance(arrayList, "ArrayList");
        testListPerformance(linkedList, "LinkedList");
        testSetPerformance(hashSet, "HashSet");
        testSetPerformance(treeSet, "TreeSet");
        testMapPerformance(hashMap, "HashMap");
        testMapPerformance(treeMap, "TreeMap");
    }

    /**
     * Método genérico para testar o desempenho de estruturas do tipo List.
     * @param list  Instância da lista (ArrayList, LinkedList, etc.)
     * @param name  Nome da estrutura para exibir nos resultados
     */
    private static void testListPerformance(List<Integer> list, String name) {
        long start, end;

        // Inserção de ELEMENTS elementos na lista
        start = System.nanoTime(); // Marca o início da contagem em nanossegundos
        for (int i = 0; i < ELEMENTS; i++) list.add(i);
        end = System.nanoTime(); // Marca o fim da operação
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        // Busca de um elemento específico (metade da lista)
        start = System.nanoTime();
        list.contains(ELEMENTS / 2); // O método .contains() percorre os elementos para verificar a existência
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        // Remoção de um elemento específico
        start = System.nanoTime();
        list.remove(Integer.valueOf(ELEMENTS / 2)); // remove(Object) -> converte int para Integer para evitar remover por índice
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }

    /**
     * Método genérico para testar o desempenho de estruturas do tipo Set.
     * Sets não permitem elementos duplicados.
     */
    private static void testSetPerformance(Set<Integer> set, String name) {
        long start, end;

        // Inserção de elementos
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) set.add(i);
        end = System.nanoTime();
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        // Busca de um elemento
        start = System.nanoTime();
        set.contains(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        // Remoção de um elemento
        start = System.nanoTime();
        set.remove(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }

    /**
     * Método genérico para testar o desempenho de estruturas do tipo Map.
     * Um Map armazena pares (chave, valor).
     */
    private static void testMapPerformance(Map<Integer, Integer> map, String name) {
        long start, end;

        // Inserção de pares (chave, valor)
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) map.put(i, i);
        end = System.nanoTime();
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        // Busca por chave
        start = System.nanoTime();
        map.containsKey(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        // Remoção de um par pela chave
        start = System.nanoTime();
        map.remove(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }
}
