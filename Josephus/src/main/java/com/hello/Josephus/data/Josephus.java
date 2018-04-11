package com.hello.Josephus.data;

import java.util.ArrayList;

public class Josephus {

    private long n = 0;
    private long m = 0;

    Josephus(){
    }

    Josephus(long n, long m){
        this.n = n;
        this.m = m;
    }

    public long getM() {
        return m;
    }

    public long getN() {
        return n;
    }

    public void setM(long m) {
        this.m = m;
    }

    public void setN(long n) {
        this.n = n;
    }

    public long solve() {

        ArrayList<Long> a = new ArrayList<Long>();
        long end = 0;

        for(long i=0; i < n; i++)
            a.add(i+1);

        while(a.size() > 1) {
            ArrayList<Long> b = new ArrayList<Long>();

            for(long i: a) {
                if ((end+a.indexOf(i)+1)%m == 0)
                    b.add(i);
                // System.out.print(i+"-->");

                if(a.indexOf(i) == a.size()-1)
                    end = (end+a.indexOf(i)+1)%m;
            }

            for(Object i: b) {
                a.remove(i);
            }
        }

        return a.get(0);
    }

    public StringBuffer order(){

        StringBuffer orderInfo = new StringBuffer();

        ArrayList<Long> a = new ArrayList<Long>();
        long end = 0;

        for(long i=0; i < n; i++)
            a.add(i+1);

        while(a.size() > 1) {
            ArrayList<Long> b = new ArrayList<Long>();

            for(long i: a) {
                if ((end+a.indexOf(i)+1)%m == 0) {
                    b.add(i);
                    orderInfo.append(Long.toString(i));
                    orderInfo.append(" -> ");
                }

                if(a.indexOf(i) == a.size()-1)
                    end = (end+a.indexOf(i)+1)%m;
            }

            for(Object i: b) {
                a.remove(i);
            }
        }

        orderInfo.append(Long.toString(a.get(0)));

        return orderInfo;

    }

}