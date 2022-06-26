package LeetCode.Neetcode150.ArraysHashing;
import java.util.ArrayList;
import java.util.List;
/**
 * PROBLEM: https://www.lintcode.com/problem/659/
 * SOLUTION: https://www.youtube.com/watch?v=B1k_sxOSgv8
 * BIG O: O(n)
 */
public class EncodeDecodeStrings {

    public static String encode(List<String> strList) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strList) {
            int length = str.length();
            encodedString.append(length + "#");
            encodedString.append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String length = "";
            while (str.charAt(i) != '#') {
                length += str.charAt(i);
                i++;
            }
            int wordLength = Integer.parseInt(length);
            i++;

            String word = "";
            for (int j = i; j < wordLength + i; j++) {
                word += str.charAt(i);
            }
            decodedStrings.add(word);
            i += wordLength - 1;
        }
        return decodedStrings;
    }
}
