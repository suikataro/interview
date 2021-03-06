package Sort;

import java.util.Arrays;

//Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.
//k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
//        Assumptions
//
//        The input array is not null.
//        k is guaranteed to be >= 1.
//        k << logn.
// version 1: O(nlogk), the best algorithm based on comparing
public class RainbowSortIII {
    public int[] rainbowSortIII(int[] array, int k) {
        rainbowSort(array, 0, array.length - 1, 1, k);
        return array;
    }

    public void rainbowSort(int[] array, int left, int right, int colorFrom, int colorTo) {
        // if only 1 color left, return
        if (colorFrom == colorTo) {
            return;
        }
        // if left >= right, return
        if (left >= right) {
            return;
        }

        //比较像quicksort

        //每次recursion的时候mid的位置都会被拍好
        int colorMid = (colorFrom + colorTo) / 2;
        int i = left;
        int j = right;
        //二分法
        while (i <= j) {
            //小于mid的就要在左边
          // array[i] <= colorMid, i++
            while (i <= j && array[i] <= colorMid) {
                i++;
            }
            //大于mid的就放到右边
            // if array[j] > colorMid, j--
            while (i <= j && array[j] > colorMid) {
                j--;
            }

            //位置不对的呼唤
            if (i <= j) {
                swap(array, i++, j--);
            }
        }
        rainbowSort(array, left, j, colorFrom, colorMid);
        rainbowSort(array, i, right, colorMid + 1, colorTo);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args){
      RainbowSortIII rainbowSortIII = new RainbowSortIII();
      int[] array = new int[]{3, 1, 5, 5, 1, 4, 2};
      System.out.println(Arrays.toString(rainbowSortIII.rainbowSortIII(array, 5)));
    }
}
