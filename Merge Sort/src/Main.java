import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        int[] arr = {5,4,3,2,1};
        //arr = mergeSort(arr);
        mergeSortInPlace(arr,0, arr.length);

        System.out.println(Arrays.toString(arr));
    }
    static int[] mergeSort(int[] arr){
        //base condition
        if(arr.length == 1){
            return arr ;
        }
        int mid = arr.length/2;
        //keep dividing the arr into two parts until we are left with single element in the array
        //return it and merge it in a sorted manner
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0 , mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid,arr.length));

        return merge(left, right);

    }
    private static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length+ right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left.length && j< right.length ){
            if(left[i]<right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        //it may be possible that one of the arr is not complete
        while (i<left.length){
            mix[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            mix[k]=right[j];
            j++;
            k++;
        }

       return mix;
    }

    static void mergeSortInPlace(int[] arr, int s , int e){
        //base condition
        if(e-s == 1){
            return ;
        }
        int mid = s+(e-s)/2;
        //keep dividing the arr into two parts until we are left with single element in the array
        //return it and merge it in a sorted manner
        mergeSortInPlace(arr, s , mid);
        mergeSortInPlace(arr, mid,e);

        merge(arr, s, mid, e);

    }
    private static void merge(int[] arr, int s, int m, int e){
        int[] mix = new int[e-s];
        int i = s;
        int j = m;
        int k = 0;

        while(i<m && j< e ){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        //it may be possible that one of the arr is not complete
        while (i<m){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for(int l = 0; l<mix.length; l++){
            arr[s+l] = mix[l];
        }
    }
}