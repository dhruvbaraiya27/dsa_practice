
public class Solution {
	private static boolean manualStartsWith(String str, String prefix)
	{
		if(prefix.length() > str.length())	return false;
		for(int i=0;i<prefix.length();i++)
		{
			if(prefix.charAt(i)!=str.charAt(i))
			{
				return false;
			}
		}
		return true;
	}
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		if(n==0)	return "";
		String prefix = arr[0];
		for(int i=1;i<n;i++)
		{
			while(!manualStartsWith(arr[i], prefix))
			{
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty())	return "";
			}
		}
		return prefix;
	}

}
