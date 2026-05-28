package lc3000_lc3099.lc3093;

public class Solution {

    class TrieNode {
        TrieNode[] children;
        Integer index;

        public TrieNode(Integer index) {
            children = new TrieNode[26];
            this.index = index;
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie(Integer index) {
            root = new TrieNode(index);
        }
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int m = wordsQuery.length;
        int[] res = new int[m];

        int minLen = Integer.MAX_VALUE;
        int defaultIdx = 0;
        for (int i = 0; i < n; i++) {
            if (wordsContainer[i].length() < minLen) {
                minLen = wordsContainer[i].length();
                defaultIdx = i;
            }
        }

        Trie trie = new Trie(defaultIdx);


        for (int i = 0; i < n; i++) {
            String s = wordsContainer[i];
            method2(i, s, trie.root, wordsContainer);
        }


        for (int i = 0; i < m; i++) {
            String s = wordsQuery[i];
            res[i] = method1(s, trie.root);
        }

        return res;
    }


    private void method2(int index, String s, TrieNode node, String[] wordsContainer) {
        TrieNode curNode = node;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int num = c - 'a';
            if (curNode.children[num] == null) {

                curNode.children[num] = new TrieNode(index);
            } else {
                int oldIdx = curNode.children[num].index;
                int oldLen = wordsContainer[oldIdx].length();
                int newLen = wordsContainer[index].length();
                if (newLen < oldLen || (newLen == oldLen && index < oldIdx)) {
                    curNode.children[num].index = index;
                }
            }
            curNode = curNode.children[num];
        }
    }

    private int method1(String s, TrieNode node) {
        int res = node.index;
        int n = s.length();
        TrieNode curNode = node;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int num = c - 'a';
            if (curNode.children[num] == null) {
                break;
            }
            curNode = curNode.children[num];
            res = curNode.index;
        }
        return res;
    }
}