package org.coding;

/**
 * The goal is to reverse the input sentence using only "in-place permutations";
 * 
 * input:  ['T','h','i','s',' ','i','s',' ','a',' ','s','i','m','p','l','e',' ','t','e','s','t',]
 * output: ['t','e','s','t',' ','s','i','m','p','l','e',' ','a',' ','i','s',' ','T','h','i','s',]
 * 
 * @author tiry
 *
 */
public class SentenceReverser {

	public String process (String in) {
		return new String(process(in.toCharArray()));		
	}
	
	public char[] process(char[] in) {
		
		reverse(in, 0, in.length-1);
		
		int start =0;
		int end = 0;
		
		while (end < in.length) {
			start = findWordStart(in, start);
			if (start<0) {
				break;
			}
			end = findWordEnd(in, start+1);			
			reverse(in, start, end);
			start = end+1;
			end++;
		}
		return in;
	}
	
	protected int findWordStart(char[] in, int start) {
		for (int i = start; i < in.length; i++) {
			if (in[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	protected int findWordEnd(char[] in, int start) {
		for (int i = start; i < in.length; i++) {
			if (in[i] == ' ') {
				return i-1;
			}
		}
		return in.length-1;
	}
	
	protected void reverse(char[] in , int start, int end) {
		while (start < end) {
			char c = in[end];
			in[end] = in[start];
			in[start]=c;
			start++;
			end--;
		}
	}
}
