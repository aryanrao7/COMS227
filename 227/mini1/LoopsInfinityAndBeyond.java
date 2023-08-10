package mini1;

import java.util.Scanner;
/**
 * Utility class with a bunch of static methods for loop practice.
 * @author ARYAN RAO
 */
		public class LoopsInfinityAndBeyond {
		// disable instantiation
		private LoopsInfinityAndBeyond() { }
		/**
		 * Returns a new string in which every character in the given string that
		 * is not already repeated consecutively is doubled.
		 * <p> 
		 * For example:
		 * <pre>{@code
		 * "attribute1" -> "aattrriibbuuttee11"
		 * "AAA Bonds" -> "AAA  BBoonnddss"
		 * }</pre>
		 * 
		 * @param text given starting string
		 * @return string with characters doubled
		 */
		public static String doubleChars(String text)
		{
			String s = "";
			String str = text;
			int i=0;
			if(text.length()==1)
			{
				return text + text;
			}
			
			else if(text.length()==0)
			{
				return "";
			}
			
			if(text.charAt(0)!=text.charAt(1))
			{
				s+=text.charAt(0);
			}
			
			s+=text.charAt(0);
			
			for(i=1;i<text.length()-1;i++)
			{
				if(str.charAt(i) == str.charAt(i-1) || str.charAt(i) == str.charAt(i+1))
				{
					s+=str.charAt(i);
				}
				
				else
				{
					s+=str.charAt(i);
					s+=str.charAt(i);
				}
			}
			
			if(text.charAt(text.length()-1)!= text.charAt(text.length()-2))
			{
				s += text.substring(text.length()-1);
				
			}
			
			s += text.substring(text.length()-1);
			
		
			
		return s;
			
		}
		/**
		 * Returns a year with the highest value, given a string containing pairs
		 * of years and values (doubles). If there are no pairs, the method returns
		 * -1. In the case of a tie, the first year with the highest value is
		 * returned. Assumes the given string follows the correct format.
		 * <p>
		 * For example, given the following string, the year 1995 is returned.
		 * <pre>
		 * 1990 75.6 1991 110.6 1995 143.6 1997 62.3
		 * </pre>
		 * 
		 * @param data given string containing year-value pairs
		 * @return first year associated with the highest value, or -1 if no pair
		 *         given
		 */
		public static int maxYear(String data)
		{
		    int year, maxYear;
		    double value, maxVal;
			if(data=="")
				return -1;
			
			else
			{
				Scanner scnr = new Scanner(data);
				
				year = scnr.nextInt();
				value = scnr.nextDouble();
				
				maxYear = year;
				maxVal = value;
				
				while(scnr.hasNext())
				{
					year = scnr.nextInt();
					value = scnr.nextDouble();
					
					if(maxVal<value)
					{
						maxYear = year;
						maxVal = value;
					}
				}
				
				scnr.close();
				return maxYear;
				
				
			}
			
		}
		/**
		 * Returns the number of iterations required until <code>n</code> is equal to
		1,
		 * where each iteration updates <code>n</code> in the following way:
		 * 
		 * <pre>
		 *     if n is even
		 *         divide it in half
		 *     else
		 *         multiply n by three and add 1
		 * </pre>
		 * 
		 * For example, given <code>n == 6</code>, the successive values of
		 * <code>n</code> would be 3, 10, 5, 16, 8, 4, 2, 1, so the method returns 8.
		If
		 * <code>n</code> is less than 1, the method returns -1.
		 * <p>
		 * <em>(Remark:</em> How do we know this won't be an infinite loop for some
		 * values of <code>n</code>? In general, we don't: in fact this is a well-
		known
		 * open problem in mathematics. However, it has been checked for numbers up 
		to
		 * 10 billion, which covers the range of possible values of the Java
		 * <code>int</code> type.)
		 * 
		 * @param n given starting number
		 * @return number of iterations required to reach <code>n == 1</code>, or -1 
		if
		 *         <code>n</code> is not positive
		 */
		
		public static int collatzCounter(int n)
		{
		  int finalVal=0;
		  
		  if(n>=1)
		  {
			  while(n!=1)
			  {
				  if(n%2==0)
				  {
					  n/=2;
				  }
				  
				  else
				  {
					  n= (n*3)+1;
				  }
				  
				  finalVal++;
			  }
			  
			  return finalVal;
		  }
		  
		  else
			  return -1;
		}
		
		/**
		 * Returns a new string in which every word in the given string is doubled. A
		 * word is defined as a contiguous group of non-space (i.e., ' ') characters
		 * that starts with an alphabetic letter and are surrounded by spaces and/or
		 * the start or end of the given string. Assumes the given string does not
		 * contain more than one consecutive white-space.
		 * <p> 
		 * For example:
		 * <pre>{@code
		 * "the time time" -> "the the time time time time"
		 * "The answer is 42." -> "The The answer answer is is 42."
		 * "A. runtime = 10ms" -> "A. A. runtime runtime = 10ms"
		 * }</pre>
		 * 
		 * @param text given starting string
		 * @return new string in which words are doubled
		 */
		public static String doubleWords(String text)
		{
			String word ="";
			String finalStr ="";
			
			if(text.length()==1)
			{
				finalStr = text + " " + text;
			}
			
			else if(text.length()==0)
			{
				return finalStr;
			}
			
			else
			{
				Scanner str = new Scanner(text);
				
				while(str.hasNext())
				{
					word = str.next();
					if(Character.isLetter(word.charAt(0)))
					{
						finalStr+=word + " " + word + " ";
						word ="";
						
					}
					
					else
					{
						finalStr +=word + " ";
					}
				}
			}
			
			return finalStr.trim();
		}
		/**
		 * Returns true if string t can be obtained from string s by removing exactly
		 * one vowel character. The vowels are the letters 'a', 'e', 'i', 'o'
		 * and 'u'. Vowels can be matched in either upper or lower case, for example,
		 * 'A' is treated the same as 'a'. If s contains no vowels the method returns
		 * false.
		 * <p>
		 * For example:
		 * <pre>{@code
		 * "banana" and "banna" returns true
		 * "Apple" and "ppl" returns false
		 * "Apple" and "pple" returns true
		 * }</pre>
		 * 
		 * @param s longer string
		 * @param t shorter string
		 * @return true if removing one vowel character from s produces the string t
		 */
		
		public static boolean oneVowelRemoved(String s, String t)
		{
		  
		  boolean b = false;
		  
		  int i=0;
		  String str;
		  
		  while(i<s.length())
		  {
			  str = s.substring(0,i) + s.substring(i+1, s.length());
			  if(t.equals(str))
			  {
				  b = true;
			  }
			  
			  i++;
		  }
		  
		  return b;
		}
		/**
		 * Returns a new string in which a UFO pattern in the given string is
		 * shifted one character to the right. The UFO pattern starts with a
		 * {@code '<'}, has one or more {@code '='} and ends with a {@code '>'}. The 
		pattern may wrap
		 * around from the end to the beginning of the string, for example
		 * {@code ">  <="}. Any other characters from the given string remain in 
		place.
		 * If the UFO moves over top of another character, that character is
		 * removed. If there are multiple UFO patterns, only the one that starts
		 * farthest to the left is moved.
		 * <p> 
		 * For example:
		 * <pre>{@code
		 * " <=>  *   . <=> " ->
		 * "  <=> *   . <=> "
		 * 
		 * "   <=>*   .     " ->
		 * "    <=>   .     "
		 * 
		 * ">.   x     .  <=" ->
		 * "=>   x     .   <"
		 * 
		 * " <= <===>   .   " ->
		 * " <=  <===>  .   "
		 * }</pre>
		 * 
		 * @param space given string
		 * @return a new string with a UFO pattern moved one to the right
		 */
		public static String ufo(String space)
		{
			String tempStr = "";

			 int ufoIndex=0;

			 String ufo="";

			 int ufolen=0;

		

			for(int i = 0 ; i < space.length(); i++) {

				int j =0;

				if(Character.toString(space.charAt(i)).equals("<")) {

					tempStr+="<";

					ufoIndex = i;

					if(ufoIndex==space.length()-1) {

						j=0;

					}else {

					j = ufoIndex +1;

					}

					

					if((Character.toString(space.charAt(j)).equals("="))) {

						

					

					while((Character.toString(space.charAt(j)).equals("="))){

						tempStr+="=";

						if(j == space.length()-1) {

							j =0;

							j--;

						}

						j++;

					

						

						

					}	if((Character.toString(space.charAt(j)).equals(">"))) {

						tempStr+=">";

						ufo = tempStr;

						ufolen=ufo.length();

						break;

					}else {

						tempStr = "";

						

					}

				

					}else {

						tempStr ="";

						

					}

					

				}

				

			}

			if(!ufo.equals(""))
			{
				
				

			if(ufoIndex>=(space.length()-ufolen)) {

				

				 char temp2 = space.charAt(space.length()-1);

				 for(int j = space.length()-1 ; j > ufoIndex ; j-- ) {

					 space = LoopsInfinityAndBeyond.replace(space,j,j-1);

				 }

				 if(ufoIndex==space.length()-1) {

					 space = space.substring(0,ufoIndex) + ' ';

				 }else {

					 space = space.substring(0,ufoIndex) + ' ' + space.substring(ufoIndex +1, space.length());

				 }

				

				 int x = space.length() - ufoIndex;

				 int y = ufolen - x;

				 

				 for( int t = y; t >0 ; t--) {

					 

					 space =LoopsInfinityAndBeyond.replace(space,t,t-1);

					 

				 }

				space = temp2 + space.substring(1,space.length());

						 

				 

				 

				

			}else {

				for(int j = ufoIndex + ufolen; j > ufoIndex ; j--) {

					 space = LoopsInfinityAndBeyond.replace(space,j,j-1);

					 

					

				}

				space = space.substring(0,ufoIndex) + ' ' + space.substring(ufoIndex +1, space.length());

				

			}

			

			

			}	

			

		

		return space;
		}
		
		public static String replace(String space , int ind , int indn) {

			

			String newString = space.substring(0,ind) + space.charAt(indn) + space.substring(ind+1, space.length());

			return newString;

		}


		/**
		 * Prints a pattern of <code>2*n</code> rows containing slashes, dashes and 
		backslashes
		 * as illustrated below.
		 * <p>
		 * When {@code n <= 0 }, prints nothing.
		 * <p> 
		 * <code>n = 1</code>
		 * <pre>
		 * \/
		 * /\
		 * </pre>
		 * <p> 
		 * <code>n = 2</code>
		 * <pre>
		 * \--/
		 * -\/
		 * -/\
		 * /--\
		 * </pre>
		 * <p> 
		 * <code>n = 3</code>
		 * <pre>
		 * \----/
		 * -\--/
		 * --\/
		 * --/\
		 * -/--\
		 * /----\
		 * </pre>
		 * 
		 * @param n number of rows in the output
		 */
		public static void printX(int n)
		{
			for (int i = 0; i < (n * 2 ); i++)
			   {
			       for (int j = 0; j < (n * 2); j++)
			       {
			           if (i == j) 
			           {
			               System.out.print("\\");
			           }
			           else if (i + j == (n * 2 - 1))
			           {
			               System.out.print("/");
			               continue;
			           }
			           
			           else if(i<j && (i+j)>=2*n)
			           {
			               if(j<2*n)
			               {
			            	   continue;
			               }
			        	   System.out.print(" ");
			           }
			           else
			           {
			               System.out.print("-");
			           }
			       }
			       System.out.println("");
			   }
			
		
		
	}
		
		
}