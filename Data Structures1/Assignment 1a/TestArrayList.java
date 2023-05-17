package algs11;
import java.util.ArrayList;
import java.util.List;

import stdlib.*;

public class TestArrayList {

	public static int basicGapWidth(List<String> wordList, int formattedLen)
	{
		int numSpaces = formattedLen - totalLetters(wordList);
		int numGaps = wordList.size() -1;
		return numSpaces / numGaps;
	}
	public static int totalLetters(List<String> wordList)
	{
		int numLetters = 0;
		for (String s : wordList)
			numLetters = numLetters+ s.length();
		return numLetters;
	}
	public static int leftoverSpaces(List<String> wordList, int formattedLen) {
        return formattedLen - totalLetters(wordList) -
                basicGapWidth(wordList, formattedLen) * (wordList.size() - 1);
    }


    public static String format(List<String> wordList, int formattedLen) {
        int extras = leftoverSpaces(wordList, formattedLen);
        int gapSize = basicGapWidth(wordList, formattedLen);

        String out = "";
        for (String word : wordList) {
            out += word;
            for (int i = 0; i < gapSize; i++) out += " ";
            // If we have some of our extra spaces left, apply them
            if (extras > 0) {
                out += " ";
                extras--;
            }
        }
        if (wordList.size() > 0) out = out.trim();
        return out;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		 a.add("AP");
	        a.add("COMP");
	        a.add("SCI");
	        a.add("ROCKS");
	        System.out.println("Total number of letters in words" + totalLetters(a));
	        System.out.println("Number of Gaps Between the words" + "20");
	        System.out.println("Basic gap Width" +basicGapWidth(a,20));
	        System.out.println("Leftover Spaces" +leftoverSpaces(a,20));
	        System.out.println(format(a,20));
	}
	

}
