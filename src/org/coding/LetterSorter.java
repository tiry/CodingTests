package org.coding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * The input is a String (or a char[]) and a number k
 * 
 * The result should be the ordered list of the k most used letters 
 * with their associated counters
 * 
 * @author tiry
 *
 */

public class LetterSorter {

	public List<Map.Entry<String, Integer>> findKMostFrequentLetters(String sentence, int k) {		
				
		Map<String, Integer> countingMap = new HashMap<>();
		
		for (int i=0; i< sentence.length(); i++) {
			String c = sentence.substring(i, i+1);
			countingMap.put(c, countingMap.getOrDefault(c, 0)+1);			
		}
		
		Stack<Map.Entry<String, Integer>> stack = new Stack<>();
		int min=0;
			
		for (Map.Entry<String, Integer> entry : countingMap.entrySet()) {
			if (entry.getValue()>=min) {
				stack.push(entry);
				min = getMinAndCompact(stack, k);
			}			
		}

		stack.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		return stack;
	}
	
	protected int getMinAndCompact(Stack<Map.Entry<String, Integer>> stack, int k) {
		
		int min=Integer.MAX_VALUE;
		int idx=0;
		
		for (int i = 0; i < stack.size(); i++) {
			Map.Entry<String, Integer> entry = stack.get(i);
			if (entry.getValue() < min) {
				min = entry.getValue();
				idx = i;
			}			
		}
		if (stack.size()> k) {
			stack.remove(idx);
		}		
		return min;
	}	
}
