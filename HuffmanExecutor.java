package com.huffman;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class HuffmanExecutor {

	//read file
	public String readFile(String x) {
		
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader brd=new BufferedReader(new FileReader(x));
			String inputLine=new String();
			try {
				inputLine=brd.readLine();
				while (inputLine  != null) {
					builder.append(inputLine);
					//builder.append("\n");
					inputLine=brd.readLine();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(brd!=null) {
						brd.close();
					}
				}catch(IOException exc) {
					exc.printStackTrace();
				}
			}
		}catch(FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("No such file exists.");
		}
		return builder.toString();
	}
	//method to filter text to alphanumeric
	public String textFilter(String rawText) {
		//initialize strings
		String filterText=new String();
		if(rawText.isEmpty()) {
			return null;
		}
		/*for(int i=0;i<rawText.length();i++) {
			if(Character.isAlphabetic(rawText.charAt(i))||Character.isDigit(rawText.charAt(i))) {
			//if(rawText.charAt(i).matches("^[a-zA-Z0-9]$"))
				filterText+=rawText.charAt(i);
			}
		}*/
		return rawText.replaceAll("[^A-Za-z0-9]","");
	}
	//main method 
	public static void main(String[] args) {
		
		//initialize scanner
		Scanner input=new Scanner(System.in);
		
		//Input file name from user
		System.out.println("Enter the file name: ");  
		String fileName=input.next();
		
		//initialize class instance
		HuffmanExecutor h=new HuffmanExecutor();
		
		//reading text from file
		String inputText=h.readFile(fileName);
		
		//filtering text
		String filterText=h.textFilter(inputText);
		
		HuffmanGenerator hg=new HuffmanGenerator(filterText);
		hg.huffmanControl();
		/*
		//Create the HuffmanTree from the command line argument String
        HuffmanTree huffman = new HuffmanTree(filterText);
        //Get the list of encodings, sort in ascending order by frequency
        ArrayList<HuffmanCode> codes = huffman.getCodeList();
        ArrayList<HuffmanCode> sorted = new ArrayList<HuffmanCode>();
        sorted.add(codes.get(0));
        for (int a=1; a<codes.size(); a++) {
        	HuffmanCode code = codes.get(a);
            boolean flag = false;
            for (int b = 0; b<sorted.size(); b++) {
            	HuffmanCode checker = sorted.get(b);
                //Insert into sorted list by ascending frequency
                if (code.getFrequency()>checker.getFrequency()) {
                    sorted.add(b, code);
                    flag = true;
                    break;
                }
                //If frequency equal, sort by char length of encoding
                else if(code.getFrequency() == checker.getFrequency()) {
                    if (code.getEncoding().length()>=checker.getEncoding().length()) {
                        sorted.add(b, code);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) sorted.add(code);
        }
        int totalcount=0;
        //calculating total character count
        for (int i=0; i<sorted.size(); i++) {
        	HuffmanCode code = sorted.get(i);
        	totalcount+=code.getFrequency();
        }
        //Input file name from user
  		System.out.println("Enter the output file name: ");  
  		String outfileName=input.next();
  		File f = new File(outfileName);
  		//delete if exists
  		if (f.exists()){
  		   f.delete();
  		}
        DecimalFormat df = new DecimalFormat("#.####");
        BufferedWriter bw=null;
        try {
        	bw = new BufferedWriter(new FileWriter(outfileName));
			bw.write("--------------------------");
			bw.newLine();
        	//writing frequency table column headers
	        bw.write("|Symbol  |   Frequency   ");
	        bw.newLine();
	        bw.write("--------------------------");
            bw.newLine();
        	//writing frequency for each character
            for (int i=0; i<sorted.size(); i++) {
            	HuffmanCode code = sorted.get(i);
            	bw.write("|   "+code.getCharacter()+"    |    "+df.format(Double.valueOf(code.getFrequency())*100.0/Double.valueOf(totalcount))+"%");
            	bw.newLine();
            }
            bw.write("--------------------------");
            bw.newLine();
            //writing code table column headers
	        bw.write("|Symbol  |  Huffman Codes ");
	        bw.newLine();
	        bw.write("--------------------------");
            bw.newLine();
            //Print encoding for each character
            for (int i=0; i<sorted.size(); i++) {
            	HuffmanCode code = sorted.get(i);
            	bw.write("|   "+code.getCharacter()+"    |    "+code.getEncoding());
            	bw.newLine();
            }
            bw.write("--------------------------");
            bw.newLine();
            //writing the encoded String length
            bw.write("|Total Bits: " + huffman.getEncodedStringLength());
            bw.newLine();
            bw.write("--------------------------");
        }catch (IOException e) {
	    	e.printStackTrace();
	    }
        try {
			if (bw!= null)
				bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //close scanner
        input.close(); */
	}

}

