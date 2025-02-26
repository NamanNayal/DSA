import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");
        subseqAscii("", "abc");
        System.out.println(subseqlist("","abc"));
        System.out.println(subseqAsciiList("","abc"));
    }
    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }

        char ch = up.charAt(0);
        subseq(p, up.substring(1));
        subseq(p+ch, up.substring(1));

    }

    static ArrayList<String> subseqlist (String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subseqlist(p+ch, up.substring(1));
        ArrayList<String> right = subseqlist(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    static void subseqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p,up.substring(1));
        subseqAscii(p+ch, up.substring(1));
        subseqAscii(p+(ch+0),up.substring(1));
    }

    static ArrayList<String> subseqAsciiList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAsciiList(p,up.substring(1));
        ArrayList<String> second = subseqAsciiList(p+ch, up.substring(1));
        ArrayList<String> third = subseqAsciiList(p+(ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;
    }


}

/*
1. Base Case:

If the input string (up) is empty, print the accumulated result (p) and return.
Recursive Case:

Extract the first character ch of up.
Exclude ch and recursively call subseq(p, up.substring(1)).
Include ch and recursively call subseq(p + ch, up.substring(1)).
Termination:

When all characters are processed, the function prints all possible subsequences.

 2. Base Case:

If up (unprocessed string) is empty, create an ArrayList containing p (processed string) and return it.
Recursive Case:

Extract the first character ch from up.
Include ch and recursively compute the subsequences (left).
Exclude ch and recursively compute the subsequences (right).
Merge both lists (left.addAll(right)) and return the result.

subseqlist("", "abc")
  ├── subseqlist("a", "bc")
  │    ├── subseqlist("ab", "c")
  │    │    ├── subseqlist("abc", "") → ["abc"]
  │    │    ├── subseqlist("ab", "")  → ["ab"]
  │    │    └── ["abc", "ab"]
  │    ├── subseqlist("a", "c")
  │    │    ├── subseqlist("ac", "") → ["ac"]
  │    │    ├── subseqlist("a", "")  → ["a"]
  │    │    └── ["ac", "a"]
  │    └── ["abc", "ab", "ac", "a"]
  ├── subseqlist("", "bc")
  │    ├── subseqlist("b", "c")
  │    │    ├── subseqlist("bc", "") → ["bc"]
  │    │    ├── subseqlist("b", "")  → ["b"]
  │    │    └── ["bc", "b"]
  │    ├── subseqlist("", "c")
  │    │    ├── subseqlist("c", "") → ["c"]
  │    │    ├── subseqlist("", "")  → [""]
  │    │    └── ["c", ""]
  │    └── ["bc", "b", "c", ""]
  └── ["abc", "ab", "ac", "a", "bc", "b", "c", ""]

Final Output: `["abc", "ab", "ac", "a", "bc", "b", "c", ""]`

3. Base Case:

If the input string (up) is empty, print the accumulated result (p) and return.
Recursive Case:

Extract the first character ch from up.
Exclude ch and recursively call subseqAscii(p, up.substring(1)).
Include ch as a character and call subseqAscii(p + ch, up.substring(1)).
Include ch as its ASCII value (ch + 0) and call subseqAscii(p + (ch + 0), up.substring(1)).

subseqAscii("", "ab")
 ├── subseqAscii("", "b")  // Exclude 'a'
 │    ├── subseqAscii("", "")   → ""
 │    ├── subseqAscii("b", "")  → "b"
 │    ├── subseqAscii("98", "") → "98"  (ASCII of 'b')
 ├── subseqAscii("a", "b")  // Include 'a'
 │    ├── subseqAscii("a", "")   → "a"
 │    ├── subseqAscii("ab", "")  → "ab"
 │    ├── subseqAscii("a98", "") → "a98"
 ├── subseqAscii("97", "b") // Include ASCII of 'a'
 │    ├── subseqAscii("97", "")   → "97"
 │    ├── subseqAscii("97b", "")  → "97b"
 │    ├── subseqAscii("9798", "") → "9798"


Since each character has 3 choices, the total number of subsequences is
3
𝑛
3
n
 .
Thus, the time complexity is O(3^n), which is higher than normal subsequence generation O(2^n).


4.Base Case:

If the input string (up) is empty, return an ArrayList containing the processed string (p).
Recursive Case:

Extract the first character ch from up.
Exclude ch and recursively compute subsequences (first).
Include ch as a character and compute subsequences (second).
Include ch as its ASCII value and compute subsequences (third).
Merge all three lists (first.addAll(second); first.addAll(third)) and return the final list.

subseqAsciiList("", "ab")
 ├── subseqAsciiList("", "b")      → ["", "b", "98"]
 │    ├── subseqAsciiList("", "")  → [""]
 │    ├── subseqAsciiList("b", "") → ["b"]
 │    ├── subseqAsciiList("98", "") → ["98"]
 ├── subseqAsciiList("a", "b")     → ["a", "ab", "a98"]
 │    ├── subseqAsciiList("a", "") → ["a"]
 │    ├── subseqAsciiList("ab", "") → ["ab"]
 │    ├── subseqAsciiList("a98", "") → ["a98"]
 ├── subseqAsciiList("97", "b")    → ["97", "97b", "9798"]
 │    ├── subseqAsciiList("97", "") → ["97"]
 │    ├── subseqAsciiList("97b", "") → ["97b"]
 │    ├── subseqAsciiList("9798", "") → ["9798"]

Each character has three choices (exclude, include as char, include as ASCII).
This leads to O(3^n) complexity, making it exponential in nature.
 */
