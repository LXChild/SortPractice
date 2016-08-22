package com.example.lxchild.sortpractice;

/**
 * Created by LXChild on 8/21/16.
 */
public abstract class CalculateFunctionTime {
        public final long getTime(String method){
            long start = System.currentTimeMillis();
            function(method);
            long stop = System.currentTimeMillis();
            return stop-start;
        }
        public abstract void function(String method);
}
