// User function Template for Java
class Trie {
  
  private class TrieNode{
      TrieNode[] children = new TrieNode[26];
      boolean isEndOfWord=false;
  }  
  private final TrieNode root;

    public Trie() {
        // Implement Trie
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index]==null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray())
        {
            int index = ch-'a';
            if(curr.children[index]==null)  return false;
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray())
        {
            int index = ch-'a';
            if(curr.children[index]==null)  return false;
            curr = curr.children[index];
        }
        return true;
    }
}
