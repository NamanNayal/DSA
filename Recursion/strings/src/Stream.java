public class Stream {
    public static void main(String[] args) {
        skip("", "absaabdja");
        System.out.println(skipp("absaabdja"));
        System.out.println(skipApple("absappleabdja"));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch=='a'){
            skip(p, up.substring(1));
        }else{
            skip(p+ch, up.substring(1));
        }
    }
    static  String skipp(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skipp(up.substring(1));
        }else{
            return ch+skipp(up.substring(1));
        }
    }
    static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return up.charAt(0)+skipApple(up.substring(1));
        }

    }
    static String skipAppNotApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApple(up.substring(3));
        }else{
            return up.charAt(0)+ skipAppNotApple(up.substring(1));

        }
    }
}
/*
The given code is about removing occurrences of the character 'a' from a string using recursion.
It consists of two recursive functions:

skip(String p, String up) → Prints all characters except 'a' by recursively building the result.
skipp(String up) → Returns a new string after removing all occurrences of 'a'.
Approach to Solve the Problem
Base Condition:

If the input string up is empty, return an empty string (or print the result).
Recursive Case:

Extract the first character ch of the string.
If ch == 'a', recursively call the function on the remaining substring (up.substring(1)) without adding ch.
Otherwise, include ch in the result and proceed with the remaining substring.
Termination:

The recursion stops when the input string is fully processed.
This is an efficient recursion-based filtering technique to modify a string without using loops.

Since strings are immutable, repeated concatenation (ch + skipp(...)) leads to multiple new string allocations, making this approach inefficient for large inputs.
A better approach would be using StringBuilder to avoid excessive memory allocation.
 */