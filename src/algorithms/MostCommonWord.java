package algorithms;
import java.util.HashMap;
import java.util.Map;


public class MostCommonWord {
    public static void main(String[] args) {
        String sentence = "apple banana apple orange banana banana grape apple";
        System.out.println(findMostCommonWord(sentence)); // Çıxış: banana
    }

    public static String findMostCommonWord(String text) {
        String[] words = text.split(" "); // Sözləri ayırırıq

        Map<String, Integer> wordCount = new HashMap<>();

        // Sözlərin təkrarlanma sayını hesablayırıq
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Ən çox təkrarlanan sözü tapırıq
        String mostCommon = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}


//public class MostCommonWord {
//    public static void main(String[] args) {
//        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "apple");
//
//        System.out.println(findMostCommonWord(words)); // Çıxış: banana
//    }
//
//    public static String findMostCommonWord(List<String> words) {
//        Map<String, Integer> wordCount = new HashMap<>();
//
//        // 1. Hər sözün neçə dəfə təkrarlandığını sayırıq
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//
//        // 2. Ən çox təkrarlanan sözü tapırıq
//        String mostCommon = null;
//        int maxCount = 0;
//        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
//            if (entry.getValue() > maxCount) {
//                maxCount = entry.getValue();
//                mostCommon = entry.getKey();
//            }
//        }
//
//        return mostCommon; // Ən çox təkrarlanan sözü qaytarır
//    }
//}




















