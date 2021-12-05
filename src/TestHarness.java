import org.github.jamm.MemoryMeter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestHarness {
    public static void main(String[] args) throws IOException {
        // Read in the word files.
        File f = new File("dictionary.txt"), g = new File("phonenumbers.txt");
        Scanner br1 = new Scanner(f);
        Scanner br2 = new Scanner(g);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> jumbles = new ArrayList<>();

        while (br1.hasNextLine()) {
            words.add(br1.nextLine());
        }
        while (br2.hasNextLine()) {
            jumbles.add(br2.nextLine());
        }
        br1.close();
        br2.close();

        int N = 30;
        long totalTime = 0;
        long totalMemory = 0;
        MemoryMeter meter = new MemoryMeter();

        System.out.println("dictionary.txt");
        System.out.println("--------------");

        for (int i = 1; i <= N; i++) {
            BaseAbstractMap<String, Integer> hashMap = new HashMap<>();
            Collections.shuffle(words);

            long startTime = System.nanoTime();
            for (String word : words) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("HashMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("HashMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            AbstractTrieMap<Integer> trieMap = new TrieMap<>();
            Collections.shuffle(words);

            long startTime = System.nanoTime();
            for (String word : words) {
                trieMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(trieMap);
        }

        System.out.println("TrieMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("TrieMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();
            Collections.shuffle(words);

            long startTime = System.nanoTime();
            for (String word : words) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("java.util.HashMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("java.util.HashMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            java.util.TreeMap<String, Integer> hashMap = new java.util.TreeMap<>();
            Collections.shuffle(words);

            long startTime = System.nanoTime();
            for (String word : words) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("java.util.TreeMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("java.util.TreeMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        System.out.println("\nphonenumbers.txt");
        System.out.println("-------------");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            BaseAbstractMap<String, Integer> hashMap = new HashMap<>();
            Collections.shuffle(jumbles);

            long startTime = System.nanoTime();
            for (String word : jumbles) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("HashMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("HashMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            AbstractTrieMap<Integer> trieMap = new TrieMap<>();
            Collections.shuffle(jumbles);

            long startTime = System.nanoTime();
            for (String word : jumbles) {
                trieMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(trieMap);
        }

        System.out.println("TrieMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("TrieMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();
            Collections.shuffle(jumbles);

            long startTime = System.nanoTime();
            for (String word : jumbles) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("java.util.HashMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("java.util.HashMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");

        totalTime = 0;
        totalMemory = 0;

        for (int i = 1; i <= N; i++) {
            java.util.TreeMap<String, Integer> hashMap = new java.util.TreeMap<>();
            Collections.shuffle(jumbles);

            long startTime = System.nanoTime();
            for (String word : jumbles) {
                hashMap.put(word, word.length());
            }
            long endTime = System.nanoTime();
            if (i % 10 == 0) {
                System.out.println(i + " iterations complete.");
            }
            totalTime += endTime - startTime; // in nanoseconds
            totalMemory += meter.measureDeep(hashMap);
        }

        System.out.println("java.util.TreeMap: Average running time: " + (totalTime / N) / 1000
                + " microseconds");
        System.out.println("java.util.TreeMap: Average memory usage: " + (totalMemory / N) / 1024
                + " kilobytes");
    }
}
