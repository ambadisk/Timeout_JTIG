package parser.early;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
    	String url_lexicon = "C:\\Users\\sampath\\Desktop\\Master-thesis\\JTIG-master\\bin\\english-conll-5000.xml";
    	JTIGParser.setProperty("grammar.lexicon.path", url_lexicon);
   		String path = "C:\\Users\\sampath\\Desktop\\Master-thesis\\JTIG-master\\bin\\eng-conll-ROOT2.txt";
   		parser.readLexicon();
   		FileReader fileread = new FileReader(path) ;
   		
    	String sentence;
		BufferedReader br = new BufferedReader(fileread);
		while((sentence = br.readLine() )!= null){
			tr.testLexicon_234_pt2(sentence);	
			
		}
		br.close();
		fileread.close();
	
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
