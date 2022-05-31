package com.gdm.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustomHashMap<K, V> implements CustomMap<K, V> {

	  private Map<K, V> entryMap;
	    // SET: Adds the specified element to this set if it is not already present.
	    private Set<K> entrySet;

	    public CustomHashMap() {
	        super();
	        entryMap = new LinkedHashMap<K, V>();
	        entrySet = new HashSet();
	    }

	    @Override
	    public boolean insertionRule(K key, V value) {
	        // KEY as null and EMPTY String is not allowed.
	        if (key == null || (key instanceof String && ((String) key).trim().equals("") ) ) {
	            return false;
	        }

	        // If key already available then, we are not overriding its value.
	        if (entrySet.contains(key)) { // Then override its value, but we are not allowing
	            return false;
	        } else { // Add the entry
	            entrySet.add(key);
	            entryMap.put(key, value);
	            return true;
	        }
	    }
	    public V put(K key, V value) {
	        V oldValue = entryMap.get(key);
	        insertionRule(key, value);
	        return oldValue;
	    }
	    public void putAll(Map<? extends K, ? extends V> t) {
	        for (Iterator i = t.keySet().iterator(); i.hasNext();) {
	            K key = (K) i.next();
	            insertionRule(key, t.get(key));
	        }
	    }

	    public void clear() {
	        entryMap.clear();
	        entrySet.clear();
	    }
	    public boolean containsKey(Object key) {
	        return entryMap.containsKey(key);
	    }
	    public boolean containsValue(Object value) {
	        return entryMap.containsValue(value);
	    }
	    public Set entrySet() {
	        return entryMap.entrySet();
	    }
	    public boolean equals(Object o) {
	        return entryMap.equals(o);
	    }
	    public V get(Object key) {
	        return entryMap.get(key);
	    }
	    public int hashCode() {
	        return entryMap.hashCode();
	    }
	    public boolean isEmpty() {
	        return entryMap.isEmpty();
	    }
	    public Set keySet() {
	        return entrySet;
	    }
	    public V remove(Object key) {
	        entrySet.remove(key);
	        return entryMap.remove(key);
	    }
	    public int size() {
	        return entryMap.size();
	    }
	    public Collection values() {
	        return entryMap.values();
	    }
	}