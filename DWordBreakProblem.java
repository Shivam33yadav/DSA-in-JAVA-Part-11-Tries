public class DWordBreakProblem {
    static class  Node  {
          Node children[] = new Node[26]; //'a' - 'z'
          boolean eow = false;

          Node() {
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

        curr.eow = true;
    }
    public static boolean search(String key) {
         Node curr = root;
        for(int level = 0; level< key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];   //agr exist krti h key to curr ko update
        }

        return curr.eow == true;
    }
    public static boolean wordBreak(String key) {
        //base case
        if(key.length() == 0) {
            return true;
        }
        for(int i =1; i<=key.length(); i++) {
            //substring(begining idx, last idx) here last idx is exclusive it will not appear
           if(search( key.substring(0, i)) &&//first substring
            wordBreak(key.substring(i))) {//2nd substring -> jb bhi substring func k andr jo ei hota h wo str ka last idx ki tarh paas krna hota
            //tb wo already java k andr defined hota h so we dont need to pass it 2nd time
            //first k liye search krna doosre k liye rec call 
            return true; //jb dono true de de
        }
    }
    return false;
}
    
    public static void main(String[] args) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i = 0; i<arr.length; i++ ) {
            insert(arr[i]);
        }

        String key = "ilikesam"; //defining key and create a function for this
        System.out.println(wordBreak(key));
    }
}
