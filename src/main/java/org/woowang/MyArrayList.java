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
    public void addAt(int id,Object obj){
        if(id == size()) {
            add(obj);
        }else if(id >= 0 && id < size()){
            Object tmp = datas[id];
            datas[id] = obj;
            for(int i =id+1;i<=idx;i++){
                Object t = datas[i];
                datas[i] = tmp;
                tmp = t;
            }
            add(tmp);
        }else throw new IndexOutOfBoundsException("범위 초과");
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
    public void showAllValues(){
        System.out.println("== 전체 데이터 출력 ==");
        for(int i =0;i<size();i++)
            System.out.println(i+" : "+datas[i].toString());
    }

    private void doubling(){
        Object[] tmp = new Object[(datas.length)*2];
        for(int i =0;i<=idx;i++) tmp[i]  = datas[i];
        datas = tmp;
    }
}

