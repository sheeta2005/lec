package lc200_lc299.lc208;

class Trie {
    private TreeNode root;

    public class TreeNode {
        boolean end;
        TreeNode[] lower;
        TreeNode() {
            end = false;
            lower = new TreeNode[26];
        }
    }

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(cur.lower[idx] == null){
                cur.lower[idx] = new TreeNode();
            }
            cur = cur.lower[idx];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(cur.lower[idx] == null) return false;
            cur = cur.lower[idx];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(cur.lower[idx] == null) return false;
            cur = cur.lower[idx];
        }
        return true;
    }
}
