/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import java.io.*;
import java.util.*;

public class ResultTable<E> {
    private Map<E, E> hashTable = Collections.synchronizedMap(new HashMap());

    public ResultTable() {
        //constructor
    }

    public void add(E key, E value) {
        hashTable.put(key, value);
    }

    public E get(E key) {
        return hashTable.get(key);
    }

    public void clear() {
        hashTable.clear();
    }

    public String toString() {
        return hashTable.toString();
    }

    public String getAllDigits() {
        StringBuilder sb = new StringBuilder();
        sb.append("3.");

        TreeMap<E, E> treeMap = new TreeMap<E, E>(hashTable);
        Set<E> keys = treeMap.keySet();
        Iterator<E> itr = keys.iterator();

        while (itr.hasNext()) {
            E i = itr.next();
            sb.append(treeMap.get(i));
        }

        return sb.toString();
    }

}
