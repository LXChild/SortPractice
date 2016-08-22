package com.example.lxchild.sortpractice;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LXChild on 8/21/16.
 */
public class ArraySort extends CalculateFunctionTime {
    private static final String TAG = ArraySort.class.getSimpleName();

    private int[] array;

    public ArraySort(int[] array) {
        this.array = array;
    }

    public int[] getResult() {
        return array;
    }

    /**
     * 直接插入排序
     * */
    private void directInsertSort() {
        Log.d(TAG, "directInsertSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //直接插入排序
        for (int i = 1; i < array.length; i++) {
            //待插入元素
            int temp = array[i];
            int j;

            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 二分插入法排序
     */
    private void binaryInsertSort() {
        Log.d(TAG, "binaryInsertSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            if (left != i) {
                array[left] = temp;
            }
        }
    }

    /**
     * 希尔排序
     */
    private void shellSort() {
        Log.d(TAG, "shellSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //希尔排序
        int d = array.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

    /**
     * 选择排序
     */
    private void selectionSort() {
        Log.d(TAG, "selectionSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //简单的选择排序
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int n = i; //最小数的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {  //找出最小的数
                    min = array[j];
                    n = j;
                }
            }
            array[n] = array[i];
            array[i] = min;

        }
    }

    /**
     * 堆排序
     */
    private void heapSort() {
        Log.d(TAG, "heapSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int arrayLength = array.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(array, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(array, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(array));
        }
    }

    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort() {
        Log.d(TAG, "bubbleSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //冒泡排序
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    private void quick() {
        Log.d(TAG, "quick>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        if (array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) { //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while (low < high) {
            //找到比基准元素小的元素位置
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    /**
     * 归并排序
     */
    private void mergeSort(int[] a, int left, int right) {
        Log.d(TAG, "mergeSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        if (left < right) {
            int middle = (left + right) / 2;
            //对左边进行递归
            mergeSort(a, left, middle);
            //对右边进行递归
            mergeSort(a, middle + 1, right);
            //合并
            merge(a, left, middle, right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle + 1; //右边的起始位置
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            //从两个数组中选取较小的数放入中间数组
            if (a[left] <= a[mid]) {
                tmpArr[third++] = a[left++];
            } else {
                tmpArr[third++] = a[mid++];
            }
        }
        //将剩余的部分放入中间数组
        while (left <= middle) {
            tmpArr[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        //将中间数组复制回原数组
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }

    /**
     * 基数排序
     * */
    private void radixSort() {
        Log.d(TAG, "radixSort>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        //判断位数
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        //建立十个队列
        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(new ArrayList<Integer>());
        }
        //进行times次分配和收集
        for (int i = 0; i < times; i++) {
            //分配
            for (int anArray : array) {
                int x = anArray % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(anArray);
                queue.set(x, queue2);
            }
            //收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(j);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    @Override
    public void function(String method) {

        switch (method) {
            case "directInsertSort":
                directInsertSort();
                break;
            case "binaryInsertSort":
                binaryInsertSort();
                break;
            case "shellSort":
                shellSort();
                break;
            case "selectionSort":
                selectionSort();
                break;
            case "heapSort":
                heapSort();
                break;
            case "bubbleSort":
                bubbleSort();
                break;
            case "quick":
                quick();
                break;
            case "mergeSort":
                mergeSort(array,0,array.length-1);
                break;
            case "radixSort":
                radixSort();
                break;
        }
    }
}
