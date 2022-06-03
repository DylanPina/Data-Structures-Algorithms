package LeetCode.Blind75.Graphs;

import java.util.*;

/*
 * PROBLEM: https://www.lintcode.com/problem/892/
 * SOLUTION: https://www.youtube.com/watch?v=6kTZYvNNyps
 */
public class AlienDictionary {

    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        // Step 1 -> Initialize the graph
        HashMap<Character, Integer> inDegree = new HashMap<>(); // # of incoming edges for every vertex
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<Character>());
            }
        }

        // Step 2 -> Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            // Check that word2 is not a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) { // If the two characters are different
                    graph.get(parent).add(child); // Add the character as a child of parent
                    inDegree.put(child, inDegree.get(child) + 1); // Increment the inDegree
                    break; // When we encounter first different character
                }
            }
        }

        // Step 3 -> Find all sources
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character vertex = sources.remove();
            sortedOrder.append(vertex);
            for (char c : graph.get(vertex)) {
                inDegree.put(c, inDegree.get(c) - 1);
                if (inDegree.get(c) == 0) {
                    sources.add(c);
                }
            }
        }
        // Check if there exists a cyclic dependency
        if (sortedOrder.length() != inDegree.size()) {
            return "";
        }
        return sortedOrder.toString();
    }

    public static void main(String[] args) {
        String result = findOrder(new String[] {"ba", "bc", "ac", "cab"});
        System.out.println("Character order: " + result);

        result = findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
