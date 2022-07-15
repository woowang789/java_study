package org.woowang;

import java.util.Arrays;

public class MyArrayList {
    private Object[] datas = new Object[2];
    private int idx = -1;

    public int size(){
        return idx+1;
    }
    public void add(Object obj){
        if(idx + 1 == datas.length) doubling();
        datas[++idx] = obj;
    }
    public Object get(int id){
        if(idx >= id) return datas[id];
        throw new IndexOutOfBoundsException("범위 초과");
    }

    public Object removeAt(int id){
        Object removed = datas[id];
        for(int i=id;i<=idx;i++) datas[i] = datas[i+1];
        idx--;
        return removed;
    }
    public int getArrayLength(){
        return datas.length;
    }

    private void doubling(){
        Object[] tmp = new Object[(datas.length+1)*2];
        for(int i =0;i<=idx;i++) tmp[i]  = datas[i];
        datas = tmp;
    }


}

