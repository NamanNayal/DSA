import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        permutations("","abc");
        ArrayList<String> ans = permutationList("", "abc");
        System.out.println(ans);
        System.out.println(permutationCount("","abcd"));
    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for(int i =0 ; i<= p.length(); i++){
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s , up.substring(1));
        }
    }
    static ArrayList<String> permutationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i<= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationList(f+ch+s, up.substring(1)));

        }
        return ans;
    }
    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for(int i = 0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationCount(f+ch+s, up.substring(1));
        }
        return count;

    }
}

/*
1st Iteration (Initial Call)
p = ""      // processed part
up = "abc"  // unprocessed part
ch = 'a'    // first character from up
The loop runs once (i = 0, because p.length() = 0):
f = "" (first part of p)
s = "" (second part of p)
New String: "a"
Recursive call:
permutations("a", "bc");

2nd Iteration (p = "a", up = "bc")
p = "a"
up = "bc"
ch = 'b'
The loop runs twice (i = 0 to p.length() = 1):
For i = 0:
f = "", s = "a"
"b" + "a" = "ba"
Recursive call:
permutations("ba", "c");
For i = 1:
f = "a", s = ""
"a" + "b" = "ab"
Recursive call:
permutations("ab", "c");

3rd Iteration (p = "ba", up = "c")
p = "ba"
up = "c"
ch = 'c'
The loop runs three times (i = 0 to p.length() = 2):
For i = 0:
f = "", s = "ba"
"c" + "ba" = "cba"
Recursive call:
permutations("cba", "");
For i = 1:
f = "b", s = "a"
"b" + "c" + "a" = "bca"
Recursive call:
permutations("bca", "");
For i = 2:
f = "ba", s = ""
"ba" + "c" = "bac"
Recursive call:
permutations("bac", "");
Since up = "", all three calls print their results:
cba
bca
bac
Understanding the Loop Behavior
🔹 The loop runs from i = 0 to p.length(), meaning it places ch at all possible positions in p.
🔹 Every recursive call builds up p by inserting characters at different positions, ensuring all permutations are explored.

 permutations("", "abc")
 ├── permutations("a", "bc")
 │    ├── permutations("ba", "c")
 │    │    ├── permutations("cba", "") → "cba"
 │    │    ├── permutations("bca", "") → "bca"
 │    ├── permutations("ab", "c")
 │    │    ├── permutations("cab", "") → "cab"
 │    │    ├── permutations("acb", "") → "acb"
 ├── permutations("b", "ac")
 │    ├── permutations("ab", "c") (repeats)
 │    ├── permutations("ba", "c") (repeats)
 ├── permutations("c", "ab")
 │    ├── permutations("ac", "b")
 │    │    ├── permutations("bac", "") → "bac"
 │    │    ├── permutations("abc", "") → "abc"
 │    ├── permutations("ca", "b")
 │    │    ├── permutations("bca", "") → "bca"
 │    │    ├── permutations("cba", "") → "cba"

 */