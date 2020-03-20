package study;

import java.util.ArrayList;
/**
 * 
 * @author liuyunan
 * @date 2020/3/20
 **/

public class BinarySearch {

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        int array[]={1,2,5,7,9,67,89,89,89,90,90};
        ArrayList<Integer> index=binarySearch(list,array,0,array.length-1,90);
        System.out.println(index);
    }
    public static ArrayList binarySearch(ArrayList<Integer>result,int []arr, int left, int right, int target){
        if(left>right){
            return null;
//            return -1;
        }
        int middle=(left+right)/2;
        int data=arr[middle];
        if(data>target){
            return binarySearch(result,arr,left,middle-1,target);
        }else if(data<target){
            return binarySearch(result,arr,middle+1,right,target);
        }else {
            result.add(middle);
            int L=middle-1;
            int R=middle+1;
            while(L>0&&arr[L]==arr[middle]){
                result.add(L);
                L--;
            }
//            System.out.println("333333333");
            while(R<arr.length&&arr[middle]==arr[R])
                result.add(R);
            R++;
        }
        return result;
    }

}