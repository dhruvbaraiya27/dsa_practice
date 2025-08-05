// User function Template for Java

class Solution {
    private static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd=false;
        TreeSet<String> words = new TreeSet<>();
    }
    
    private static TrieNode root;
    private static void insert(String word)
    {
        TrieNode curr = root;
        for(char ch: word.toCharArray())
        {
            int index = ch - 'a';
            if(curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            curr.words.add(word);
        }
        curr.isEnd = true;
    }
    private static ArrayList<String> getSuggestions(TrieNode curr)
    {
        return new ArrayList<>(curr.words);
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[],
                                                        String s) {
                                                            
        root = new TrieNode();
        for(String word: contact){
            insert(word);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        TrieNode curr = root;
        boolean noMatch = false;
        
        for(char ch: s.toCharArray())
        {
            if(noMatch)
            {
                result.add(new ArrayList<>(Arrays.asList("0")));
                continue;
            }
            int index = ch - 'a';
            if(curr.children[index]==null)
            {
                result.add(new ArrayList<>(Arrays.asList("0")));
                noMatch=true;
            }
            else{
                curr = curr.children[index];
                ArrayList<String> suggestions = getSuggestions(curr);
                result.add(suggestions);
            }
        }
        return result;
        
        
    }
}
