package com.example.lxchild.sortpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private TextView tv_sorted;
    int[] array = {2,8,5,4,3,6,9};
    private void initView() {
        TextView tv_origin = (TextView) findViewById(R.id.tv_origin);
        tv_sorted = (TextView) findViewById(R.id.tv_sorted);

        printArray(array, 0, tv_origin);
    }

    private ArraySort sort = new ArraySort(array);
    int[] array_sorted;
    long time;
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_directInsert:
                time = sort.getTime("directInsertSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_binaryInsert:
                time = sort.getTime("binaryInsertSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_shell:
                time = sort.getTime("shellSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_selection:
                time = sort.getTime("selectionSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_heap:
                time = sort.getTime("heapSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_bubble:
                time = sort.getTime("bubbleSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_quick:
                time = sort.getTime("quick");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_merge:
                time = sort.getTime("mergeSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
            case R.id.btn_radix:
                time = sort.getTime("radixSort");
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
        }
    }

    private void printArray(int[] array, long time, TextView tv) {
//        tv.setText("");
//        for (int i : array) {
//            tv.append(i + " ");
//        }
        tv.append("\nUsed Time: " + time + "ms\n");
    }
}
