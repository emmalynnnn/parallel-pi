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

    /**
     * Method to add a result to the hash table
     * @param key the key to add
     * @param value the value to associate with the key
     */
    public void add(E key, E value) {
        hashTable.put(key, value);
    }

    /**
     * Method to get a value from the hash table
     * @param key the key to get the value of
     * @return the associated value
     */
    public E get(E key) {
        return hashTable.get(key);
    }

    /**
     * Method to clear the hashtable
     */
    public void clear() {
        hashTable.clear();
    }

    /**
     * Method to get string representation of the hash table
     * @return string representation of the hash table
     */
    public String toString() {
        return hashTable.toString();
    }

    /**
     * Method to return the digits of pi from the sorted order of keys
     * @return string of digits of pi
     */
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
