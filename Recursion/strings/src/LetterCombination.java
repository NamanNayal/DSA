import java.util.ArrayList;

// Google Question M- Phone Pad
public class LetterCombination {
    public static void main(String[] args) {
        phonePad("","12");
        System.out.println(phonePadList("","13"));
        System.out.println(phonePadCount("","22"));
    }
    static void phonePad(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for(int i = (digit-1)*3; i<digit*3; i++){
            char ch = (char)('a'+i);
            phonePad(p+ch, up.substring(1));
        }

    }
    static ArrayList<String> phonePadList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for(int i = (digit-1)*3; i<digit*3; i++){
            char ch = (char)('a'+i);
            ans.addAll(phonePadList(p+ch, up.substring(1)));

        }
        return ans;
    }
    static int phonePadCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int digit = up.charAt(0)-'0';
        int count = 0;
        for(int i = (digit-1)*3; i<digit*3; i++){
            char ch = (char)('a'+i);
            count = count+ phonePadCount(p+ch, up.substring(1));
        }
        return count;
    }
}

/*
Base Case:

If up (unprocessed string) is empty, print p (processed part) and return.
Recursive Case:

Convert the first digit (up.charAt(0)) to an integer.
Find the corresponding letter range from the English alphabet (a-z).
Iterate over the valid characters using a for loop and recursively call phonePad() with each letter added to p.

Each digit maps to three letters in sequence.
The range is determined using (digit-1) * 3 to digit * 3 - 1.

phonePad("", "23")

Step 1: Processing '2'
digit = 2
Range: i = 3 to 5 (letters: 'd', 'e', 'f')
Recursive calls:
phonePad("d", "3")
phonePad("e", "3")
phonePad("f", "3")

Step 2: Processing '3' (for each previous letter)
digit = 3
Range: i = 6 to 8 (letters: 'g', 'h', 'i')
For "d":

phonePad("dg", "")
phonePad("dh", "")
phonePad("di", "")
Since up is now empty, these calls print:
dg
dh
di

The same process repeats for "e" and "f", giving:
eg eh ei
fg fh fi

✅ Final Output:
dg dh di
eg eh ei
fg fh fi
 */