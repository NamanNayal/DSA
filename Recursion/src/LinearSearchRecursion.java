import java.util.ArrayList;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[] arr = {3,12,345,123,1,0,9281};
        System.out.println(linearSearch(arr,0,0));
    }

    static boolean linearSearch(int[] arr, int target, int index){
        if(arr.length == index){
            return false;
        }
        return ((arr[index]==target) || linearSearch(arr,target,index+1));
    }
    static int linearSearchIndex(int[] arr, int target, int index){
        if(arr.length == index){
            return -1;
        }
        if(arr[index]== target){
            return index;
        }
        else {
            return linearSearchIndex(arr,target, index+1);
        }

    }
    static int linearSearchIndexLast(int[] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if(arr[index]== target){
            return index;
        }
        else {
            return linearSearchIndexLast(arr,target, index-1);
        }

    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchAllIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return ;
        }
        if(arr[index]== target) {
            list.add(index);
        }
        linearSearchAllIndex(arr,target,index+1);

    }

    static ArrayList<Integer> linearSearchAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index]== target) {
            list.add(index);
        }
        return linearSearchAllIndex2(arr,target,index+1, list);

    }

    static ArrayList<Integer> linearSearchAllIndex3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        //this will contain ans for that function call only
        if(arr[index]== target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  linearSearchAllIndex3(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return  list;

    }

}
