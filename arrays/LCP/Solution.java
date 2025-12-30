package leetcode.arrays.LCP;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class PrefixTree {    
        Map<Character, PrefixTree> children;
        boolean isEnd;        
    }

    public void insert(PrefixTree root, String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        PrefixTree node = root;
        if(node.children == null) {
            node.children = new HashMap<>();
        }
        for (char ch : word.toCharArray()) {
            if (node.children.get(ch) == null) {
                node.children.put(ch, new PrefixTree(){
                    {
                        children = new HashMap<>();
                    }
                });
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    private String findCharacter(StringBuilder lcp, PrefixTree node) {

        if(node == null || node.isEnd || node.children == null || node.children.size() != 1) {
            return lcp.toString();
        }
        
        while(node != null && !node.isEnd && node.children != null && node.children.size() == 1) {
            for (Map.Entry<Character, PrefixTree> entry : node.children.entrySet()) {
                lcp.append(entry.getKey());
                node = entry.getValue();
            }
        }       
        return lcp.toString();
    }

     public String longestCommonPrefix(String[] strs) { 
        PrefixTree root = new PrefixTree();
        for (String str : strs) {
            if(str == null || str.length() == 0) {
                return "";
            }
            insert(root, str);
        }

        StringBuilder lcp = new StringBuilder();
        PrefixTree node = root; 
        return findCharacter(lcp, node);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"b"};
        String result = sol.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

