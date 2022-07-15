package org.woowang;

public class MyArrayList {
    private Object[] datas = {};
    private int idx = -1;

    public int size(){
        return idx+1;
    }
    public void add(Object obj){
        if(idx + 1 == datas.length) doubling();
        datas[++idx] = obj;
    }
    public Object get(int id){
        return datas[id];
    }

    private void doubling(){
        Object[] tmp = new Object[(datas.length+1)*2];
        for(int i =0;i<idx;i++) tmp[i]  = datas[i];
        datas = tmp;
    }


}

