package parser.early;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;

import java.util.ArrayList;

import parser.early.run.ParseResult;
import tools.GeneralTools;
import tools.tokenizer.MorphAdornoSentenceTokenizer;
import tools.tokenizer.Token;

public class Test_Read {
	private static JTIGParser parser;
	private MorphAdornoSentenceTokenizer st;

	
	
	public void tearDown() throws Exception {
		System.out.println("Tear down.");
		File dir = new File("data/runs/");
		GeneralTools.deleteDirectory(dir);	
	}

	
	public void testLexicon_234_pt2( String url_input_file) {
		st = new MorphAdornoSentenceTokenizer();
		ParseResult run = null;
		try {
			
			Token[] tokens = st.getTokens(url_input_file);
			run = parser.parseSentence(url_input_file,tokens);
		
			
			
			//System.out.println(run.getDerivedTrees().size());
			//System.out.println("Read Sentence: "+st.getSentence(tokens));
			
		} catch (Exception  e) {
			System.out.println(e.getMessage());
		}
		
		//System.out.println(run.getLog());
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Test_Read tr=  new Test_Read();
       

       
       try {
           parser = new JTIGParser("");
    	String url_lexicon = "D:\\latest_jtig\\english-conll-5000.xml";//lexicon path
    	JTIGParser.setProperty("grammar.lexicon.path", url_lexicon);
   		String path = "D:\\latest_jtig\\eng-conll-ROOT2.txt";//text file path
   		parser.readLexicon();
   		
   		FileReader fileread = new FileReader(path) ;
   		
    	String sentence;
		BufferedReader br = new BufferedReader(fileread);
		String pathtoWrite = "D:\\latest_jtig\\stats\\result.txt";
		FileWriter fw= new FileWriter(pathtoWrite, true);
	    BufferedWriter bw= new BufferedWriter(fw);
		//long time= System.currentTimeMillis();
       //	long time2;
		int sentencenumber = 0;
		String line = br.readLine();
		while(line != null){
			long lineTime1 = System.currentTimeMillis();
			
			sentencenumber = sentencenumber+1;
			tr.testLexicon_234_pt2(line);
			
			long lineTime2 = System.currentTimeMillis();
			
			bw.write("Time to write sentence "+ Integer.toString(sentencenumber) + " is " +  new Long(lineTime2-lineTime1).toString()+" ms." + "\n");
			line = br.readLine();
		}
		long time2 = System.currentTimeMillis();
		System.out.println("Complete time: " + new Long(time2-time1).toString()+" ms." + "\n");
		bw.close();
		fw.close();
		br.close();
		fileread.close();
		System.exit(1);
		
	
		
		
	
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}

}
