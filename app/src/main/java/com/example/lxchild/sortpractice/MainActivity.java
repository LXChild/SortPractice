package com.example.lxchild.sortpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }



    private TextView tv_sorted;
    private Spinner spn_method;
    int[] array = {2,8,5,4,3,6,9};
    private void initView() {
        TextView tv_origin = (TextView) findViewById(R.id.tv_origin);
        tv_sorted = (TextView) findViewById(R.id.tv_sorted);
        spn_method = (Spinner) findViewById(R.id.spn_method);

        printArray(array, 0, tv_origin);
    }

    private ArrayAdapter<String> adapter;

    private void initData() {
        List<String> data_list = new ArrayList<>();
        data_list.add("directInsertSort");
        data_list.add("binaryInsertSort");
        data_list.add("shellSort");
        data_list.add("selectionSort");
        data_list.add("heapSort");
        data_list.add("bubbleSort");
        data_list.add("quick");
        data_list.add("mergeSort");
        data_list.add("radixSort");

        //适配器
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spn_method.setAdapter(adapter);
    }

    private ArraySort sort = new ArraySort(array);
    int[] array_sorted;
    long time;
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_run:
                time = sort.getTime((String)spn_method.getSelectedItem());
                array_sorted = sort.getResult();
                printArray(array_sorted, time, tv_sorted);
                time = 0;
                array_sorted = null;
                break;
        }
    }

    private void printArray(int[] array, long time, TextView tv) {
        switch (tv.getId()) {
            case R.id.tv_origin:
                tv.setText("Origin Array: ");
                for (int i : array) {
                    tv.append(i + " ");
                }
                break;
            case R.id.tv_sorted:
                tv.setText("Sorted Array: ");
                for (int i : array) {
                    tv.append(i + " ");
                }
                tv.append("\nMethod: " + spn_method.getSelectedItem());
                tv.append("\nUsed Time: " + time + "ms\n");
                break;
        }
    }
}
