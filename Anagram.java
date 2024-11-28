/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int count = 0;
		
        str1 = preProcess1(str1);
	    str2 = preProcess1(str2);

	       if (str1.length() != str2.length()){
			return false;
		   }
		   else{

		     for (int i =0; i < str1.length(); i++) 
		     { 

			   for (int j = 0; j < str2.length(); j++) 
			   { 

			     if ((str1.charAt(i)) == str2.charAt(j)) // cheaking if the i in str1 is equall to some char in str2
				 {
                    count++;
					str2 = str2.substring(0, j)+str2.substring(j+1);
			     }
		       }
	        } 
		   }

		if ((str1.length())-(count) == 0) {
			return true;
		}
		else {
			return false;
		}
	 }
	

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

		str = str.toLowerCase(); //convert to lower case
		String nStr = "";
		String check= "abcdefghijklmnopqrstuvwxyz ";

		for (int i = 0; i < str.length(); i ++) {
			for(int j=0;j<check.length();j++){
			if(str.charAt(i)==check.charAt(j)){
			nStr += str.charAt(i);
			}
			}
		}
		return nStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
        
		int Strandom1 = (int)Math.random()*str.length(); 
		//int Strandom2 = (int)Math.random()*str.length(); 
        String newStr = "";
		char c1 = str.charAt(Strandom1);
		//char c2 = str.charAt(Strandom2);

		for (int i=0; i < str.length(); i++)
		{
			if (str.charAt(i) != str.charAt(Strandom1)) {
				newStr += str.charAt(i);
			}
		}
		newStr = newStr+c1;
		return newStr;
	}

	
	public static String preProcess1(String str) {

		str = str.toLowerCase(); //convert to lower case
		String nStr = "";
		String check= "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < str.length(); i ++) {
			for(int j=0;j<check.length();j++){
			if(str.charAt(i)==check.charAt(j)){
			nStr += str.charAt(i);
			}
			}
		}
		return nStr;
	} 
}
