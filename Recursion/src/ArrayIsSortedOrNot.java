public class ArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,66,77,888};
        System.out.println(isSorted(arr,0));

    }
    static boolean isSorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return (arr[index]<arr[index+1] && isSorted(arr, index+1));
    }
}
