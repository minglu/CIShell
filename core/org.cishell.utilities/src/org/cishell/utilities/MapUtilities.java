package org.cishell.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtilities {
	public static<K, V> Collection<K> getValidKeysOfTypesInMap(
			Map<K, V> map, Collection<V> types, Collection<K> keysToSkip)
			throws ColumnNotFoundException {
		Collection<K> workingKeys = new ArrayList<K>();
		Collection<Map.Entry<K, V>> entrySet = map.entrySet();

		for (V type : types) {
			Collection<K> keysForType =
				SetUtilities.getKeysOfMapEntrySetWithValue(entrySet, type);
			workingKeys =
				ArrayListUtilities.unionCollections(workingKeys, keysForType, keysToSkip);
		}
		
		return workingKeys;
	}

	public static<T> Map<T, T> mirror(Collection<T> items) {
		Map<T, T> mirroredItems = new HashMap<T, T>();

		for (T item : items) {
			mirroredItems.put(item, item);
		}

		return mirroredItems;
	}

	public static<K, V> List<K> keysWithOrder(Map<K, V> map) {
		List<K> keys = new ArrayList<K>();

		for (K key : map.keySet()) {
			keys.add(key);
		}

		return keys;
	}

	public static<K, V> Collection<V> valuesWithPreservedOrder(Map<K, V> map, Collection<K> keys) {
		List<V> values = new ArrayList<V>();

		for (K key : keys) {
			values.add(map.get(key));
		}

		return values;
	}

	public static<V> Map<Integer, V> mapIndexToValues(List<V> values) {
		Map<Integer, V> valuesByIndex = new HashMap<Integer, V>();

		for (int ii = 0; ii < values.size(); ii++) {
			valuesByIndex.put(ii, values.get(ii));
		}

		return valuesByIndex;
	}
}