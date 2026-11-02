public class BInsertATrie {
   static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        Node() {  //constructor
          for(int i =0; i<26; i++) {
            children[i] = null;
          }
        }
    }
    public static Node root = new Node();

    public static void insert(String word) {  // T.C -> O(L)  l is the largest word length
        Node curr = root;
        for(int level = 0; level< word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];  
        }

        curr.eow = true; // jab last node pr pahuvh gye
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i =0; i<words.length; i++) {
            insert(words[i]);
        }
        
    }
}
