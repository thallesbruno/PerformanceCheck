import java.util.*;

public class PerformanceTest {
    private static final int ELEMENTS = 100_000;

    public static void main(String[] args) {
        // Listas
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Conjuntos
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        // Mapas
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("=== TESTE DE PERFORMANCE DAS COLLECTIONS ===\n");

        testListPerformance(arrayList, "ArrayList");
        testListPerformance(linkedList, "LinkedList");
        testSetPerformance(hashSet, "HashSet");
        testSetPerformance(treeSet, "TreeSet");
        testMapPerformance(hashMap, "HashMap");
        testMapPerformance(treeMap, "TreeMap");
    }

    private static void testListPerformance(List<Integer> list, String name) {
        long start, end;

        // Inserção
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) list.add(i);
        end = System.nanoTime();
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        // Busca
        start = System.nanoTime();
        list.contains(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        // Remoção
        start = System.nanoTime();
        list.remove(Integer.valueOf(ELEMENTS / 2));
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }

    private static void testSetPerformance(Set<Integer> set, String name) {
        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) set.add(i);
        end = System.nanoTime();
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        set.contains(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        set.remove(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }

    private static void testMapPerformance(Map<Integer, Integer> map, String name) {
        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) map.put(i, i);
        end = System.nanoTime();
        System.out.println(name + " - Inserção: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        map.containsKey(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Busca: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        map.remove(ELEMENTS / 2);
        end = System.nanoTime();
        System.out.println(name + " - Remoção: " + (end - start) / 1_000_000.0 + " ms\n");
    }
}
