package com.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanGenerator {

	//declaring variable
	private String text;
	private HashMap<Character,Integer> frequencies;
	public PriorityQueue<HuffmanNode> pq;
	
	public HuffmanGenerator(String filterText) {
		this.text=filterText;
		frequencies=new HashMap<Character,Integer>();
		pq=new PriorityQueue();
	}
	public void calculateFrequency() {
		for(int i=0;i<text.length();i++) {
			if(frequencies.containsKey(text.charAt(i))) {
				int currFreq=frequencies.get(text.charAt(i));
				currFreq=currFreq+1;
				frequencies.put(text.charAt(i), currFreq);
			}
			else {	
				frequencies.put(text.charAt(i),1);
			}
		}
	}
	public void createPriorityQueue() {
		for(char c:frequencies.keySet()) {
			pq.add(new HuffmanNode(c,frequencies.get(c)));
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	public void getTreeRoot() {
		HuffmanNode root=buildHuffmanTree();
	}
	public HuffmanNode buildHuffmanTree() {
		HuffmanNode nh;
		while(pq.size()>1) {
			HuffmanNode h1=pq.poll();
			HuffmanNode h2=pq.poll();
			nh=new HuffmanNode('$',h1.getFrequency()+h2.getFrequency());
			nh.setRight(h1);
			nh.setLeft(h2);
			pq.add(nh);
			buildHuffmanTree();
		}
		return pq.poll();
	}
	public void huffmanControl() {
		calculateFrequency();
		createPriorityQueue();
	}
}
