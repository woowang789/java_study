package org.woowang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashMap<K,V> {
    int idx = -1;
    Object[] keyArr = new Object[3];
    Object[] valueArr = new Object[3];

    private void doublingIfNeedSize(){
        if(idx+1 == keyArr.length){
            Object[] k = new Object[keyArr.length*2];
            Object[] v = new Object[keyArr.length*2];
            for(int i =0;i<idx+1;i++){
                k[i] = keyArr[i];
                v[i] = valueArr[i];
            }
            keyArr = k;
            valueArr = v;
        }
    }
    public void put(K key,V value){
        doublingIfNeedSize();
        idx++;
        for(int i =0;i<idx;i++){
            if(keyArr[i].equals(key)){
                valueArr[i] = value;
                return;
            }
        }
        keyArr[idx] = key;
        valueArr[idx] = value;
    }
    public V get(K key){
        int id = indexOfKey(key);
        if(id == -1) throw new NullPointerException("key에 해당하는 value가 없음");
        return (V) valueArr[id];
    }
    public int size(){
        return idx+1;
    }

    public V remove(K key){
        int id = indexOfKey(key);
        if(id == -1) throw new NullPointerException("key에 해당하는 value가 없음");
        V ret = (V)valueArr[id];
        moveLeft(id);
        idx--;
        return ret;
    }

    public List<K> keySet() {
        return Arrays.stream(keyArr).map(i->(K)i).collect(Collectors.toList());
    }

    private void moveLeft(int id){
        for(int i=id;i<=idx;i++){
            keyArr[i] = keyArr[i+1];
            valueArr[i] = valueArr[i+1];
        }
    }
    private int indexOfKey(K key){
        int ret = -1;
        for(int i =0;i<idx+1;i++){
            if(keyArr[i].equals(key)) return i;
        }
        return ret;
    }
}
