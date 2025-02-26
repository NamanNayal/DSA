import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arrr = {1,2,2,2,3};
        List<List<Integer>> ans = subset(arr);
        List<List<Integer>> anss = subsetDuplicate(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
        for(List<Integer> list: anss){
            System.out.println(list);
        }
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for(int i = 0; i<n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i= 0; i<arr.length; i++){
            start = 0;
            // if current nd previous element is same, s = e+1
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size() -1;
            int n = outer.size();
            for(int j = start; j<n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}

/*
1. Start with an empty list outer containing an empty subset [].
Iterate through each number in the array:
Copy all existing subsets and append the new number to form new subsets.
Add them back to outer.
Finally, return outer, which contains all possible subsets.
Start: [[]]

Processing 1:
→ [[], [1]]

Processing 2:
→ [[], [1], [2], [1,2]]

Processing 3:
→ [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
Time Complexity: O(2^n), as each element doubles the subset count.

2. Sort the array to bring duplicates together.
Use two pointers start and end to track the range where new subsets should be added:
If a duplicate element is encountered, only generate new subsets from previously created subsets (tracked using start and end).
Otherwise, generate subsets as usual.

Start: [[]]

Processing 1:
→ [[], [1]]

Processing 2:
→ [[], [1], [2], [1,2]]

Processing 2 (Duplicate):
→ Only extend from the previous `2` subsets:
→ [[], [1], [2], [1,2], [2,2], [1,2,2]]

Processing 2 (Duplicate again):
→ Only extend from the previous `2,2` subsets:
→ [[], [1], [2], [1,2], [2,2], [1,2,2], [2,2,2], [1,2,2,2]]

Processing 3:
→ Extend all previous subsets:
→ [[], [1], [2], [1,2], [2,2], [1,2,2], [2,2,2], [1,2,2,2], [3], [1,3], [2,3], [1,2,3], [2,2,3], [1,2,2,3], [2,2,2,3], [1,2,2,2,3]]

Time Complexity: O(2^n) (worst case) but optimized by limiting subset formation for duplicates.

 */