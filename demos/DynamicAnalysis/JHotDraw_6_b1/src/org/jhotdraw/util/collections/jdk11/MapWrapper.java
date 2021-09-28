/*
 * @(#)MapWrapper.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package org.jhotdraw.util.collections.jdk11;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author  Wolfram Kaiser <mrfloppy@users.sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
public class MapWrapper implements Map {
	private Map myDelegee;

	public MapWrapper() {
		myDelegee = new Hashtable();
	}

	public MapWrapper(Map copyMap) {
		myDelegee = new Hashtable(copyMap);
	}

	public int size() {
		return myDelegee.size();
	}

	public boolean isEmpty() {
		return myDelegee.isEmpty();
	}

	public boolean containsKey(Object key) {
		return myDelegee.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return myDelegee.containsKey(value);
	}

	public Object get(Object key) {
		return myDelegee.get(key);
	}

	public Object put(Object key, Object value) {
		return myDelegee.put(key, value);
	}

	public Object remove(Object key) {
		return myDelegee.remove(key);
	}

	public void putAll(Map t) {
		myDelegee.putAll(t);
	}

	public void clear() {
		myDelegee.clear();
	}

	public Set keySet() {
		return myDelegee.keySet();
	}

	public Collection values() {
		return myDelegee.values();
	}

	public Set entrySet() {
		return myDelegee.entrySet();
	}

	@Override
	public Object getOrDefault(Object key, Object defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(BiConsumer action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceAll(BiFunction function) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replace(Object key, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object replace(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object computeIfAbsent(Object key, Function mappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object computeIfPresent(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object compute(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object merge(Object key, Object value, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
}
