import java.util.ArrayList;

//Amazon Question
public class Dice {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceList("",4));
        diceFace("",4,8);
    }
    static  void dice(String p, Integer target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i<=6 && i<=target; i++ ){
            dice(p+i, target-i);
        }
    }
    static ArrayList<String> diceList(String p, Integer target ){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list ;
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i=1; i<=6 && i<=target; i++){
            ans.addAll(diceList(p+i, target-i));


        }
        return ans;
    }
    static void diceFace(String p, int target, int face){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i<= face && i<=target; i++){
            diceFace(p+i, target-i, face);
        }
    }

}
/*
Base Case:

If target == 0, print p (processed part containing dice rolls) and return.
Recursive Case:

Roll a dice, choosing a number i from 1 to 6 (valid dice values).
Ensure i ≤ target to prevent negative sums.
Append i to p and recursively call dice(p + i, target - i)

Initial Call: dice("", 4)

Iteration 1 (i = 1, target = 4)
p = "1"
target = 4 - 1 = 3
Recursive call: dice("1", 3)

Iteration 2 (i = 1, target = 3)
p = "11"
target = 3 - 1 = 2
Recursive call: dice("11", 2)

Iteration 3 (i = 1, target = 2)
p = "111"
target = 2 - 1 = 1
Recursive call: dice("111", 1)

Iteration 4 (i = 1, target = 1)
p = "1111"
target = 1 - 1 = 0
Recursive call: dice("1111", 0)
✅ Base case reached → Prints 1111

Backtracking and Exploring Other Paths
Once "1111" is printed, recursion backtracks to explore other values of i at each level.
Back to p = "111", target = 1

Next iteration: i = 2, but 2 > 1, so it stops.
Back to p = "11", target = 2
Try i = 2
p = "112"
target = 2 - 2 = 0
✅ Prints "112"

Try i = 3, but 3 > 2, so it stops.
Back to p = "1", target = 3
Try i = 2
p = "12"
target = 3 - 2 = 1
This further recurses into "121"
✅ Prints "121"
Try i = 3
p = "13"
target = 3 - 3 = 0
 */


