public class ACreatingTrie {  
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        Node() {  //constructor
          for(int i =0; i<26; i++) {
            children[i] = null;
          }
        }
    }
    public static Node root = new Node(); // ye node hamesaa blank rehti by default ..root node is always blank in trie only info of child is given 
    public static void main(String[] args) {
        String words[] = {"the", "a","there", "their", "any","three"};


    }
}