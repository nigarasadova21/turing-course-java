package algorithms;   //bir massivdəki elementlərin neçə dəfə təkrarlandığını müəyyənləşdirmək
// və bu təkrarlanma saylarının unikal olub-olmadığını yoxlamaq

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class UniqueOccurrances {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 5, 5, 5};   //tekrarlanma sayi ferqlidirse true ,eynidirse false
        int[] arr2 = {1, 2, 3, 4, 5, 1, 1, 2, 2, 2};
        System.out.println(uniqueOccurences(arr1));
        System.out.println(uniqueOccurences(arr2));

    }

    public static boolean uniqueOccurences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        }
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());
        return countMap.size() == occurrenceSet.size();
    }
}

