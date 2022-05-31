package com.gdm.commons;

import java.util.Map;

public interface CustomMap<K, V> extends Map<K, V> {
	public boolean insertionRule(K key, V value);

}
