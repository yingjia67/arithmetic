package yingjia67.arithmetic.sort;

public class SortArray {
    public static void main(String args[]) {
        int[] array = {2,8,3,4,6,7};
          SortArray.bubbleSort(array);
          SortArray.quickSort(array);
          SortArray.mergeSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

     }
    public static void bubbleSort(int[] array) {
        int len = array.length;
        boolean flag = false;//如果一次排序没有变化，则表明已经排好序。
        if(len ==0 || len ==1){
            return;
        }
        for(int i = 1;i<=len-1;i++){
            if(flag){
                return;
            }
            for(int j = 0;j<=len-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
        }
        return;
    }


    public static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }
    public static void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int i = left;
        int j = right;
        int base = array[i];
        while (i!=j){
            while (i!=j&&array[j]>base){
                j--;
            }
            if(i!=j){
                array[i++] = array[j];
            }
            while (i!=j&&array[i]<base){
                i++;
            }
            if(i!=j){
                array[j--] = array[i];
            }
        }
        array[i] = base;
        quickSort(array,left,i-1); //如果left = i时，会导致异常情况。
        quickSort(array,i+1,right);
    }

    public static void mergeSort(int[] array){
        int[]tmp = new int[array.length];
        mergeSort(array,0,array.length-1,tmp);
    }

    public static void mergeSort(int[] array,int left,int right,int[]tmp){
        if(left>=right){
            return;
        }
       int mid = (left+right)/2;
       mergeSort(array,left,mid,tmp);
       mergeSort(array,mid+1,right,tmp);
       mergeArray(array,left,right,tmp);
    }
    static void mergeArray(int[] array, int left, int right, int[] tmp){
        int mid = (left+right)/2;
        int tmpIndex = 0;
        int i = left;
        int j = mid+1;
        while (i<=mid&&j<=right){
            if(array[i]<array[j]){
                tmp[tmpIndex++] = array[i++];
            }else {
                tmp[tmpIndex++] = array[j++];

            }
        }
        while (i<=mid){
            tmp[tmpIndex++] = array[i++];
        }
        while (j<=right){
            tmp[tmpIndex++] = array[j++];
        }

        int m = left;
        for(tmpIndex = 0;tmpIndex<right-left+1;){
            array[m++] = tmp[tmpIndex++];
        }
    }



}
