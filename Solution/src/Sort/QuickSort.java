package Sort;
//quicksort是in place的
public class QuickSort {
    public int[] quickSort(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array; //don't forgot to return
    }

    //按照找到的pivot划分left和right，call自己
    public void quickSort(int[] array, int left, int right) {
        //end of recursion
        if(left >= right){
            return;
        }
        //处理
        int piv = findPivot(array, left, right);

        //这里只是二分的recursion
        quickSort(array, left, piv - 1); //piv is not included
        quickSort(array, piv + 1, right);
    }

    //真正的sort过程，返回新的左边作为新的pivot
    public int findPivot(int[] array, int left, int right) {
        //找pivot的index和值
        int pivIndex = pivotIndex(left, right);//find pivot index
        int piv = array[pivIndex];

        //找到piv的值，把pivot和最右换一下
        swap(array, pivIndex, right);//swap function always take index

        //重新复制leftBound和rightBound
        int leftBound = left;
        int rightBound = right - 1;//last element is piv

        //相向而行，相等而不是相邻
        while(leftBound <= rightBound) {
            if(array[leftBound] < piv) {
                leftBound++;
            }else if(array[rightBound] >= piv) {// >=
                rightBound--;
            }else {
                swap(array,leftBound++,rightBound--);//need to move bounds after swap
            }
        }
        //再把此时的左边和换过去的pivot换回来
        swap(array, leftBound, right);//swap leftBound with right
        return leftBound;//pivot after swap
    }

    //随便找一个pivot
    public int pivotIndex(int left, int right) {
        return left + (int) (Math.random()*(right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
