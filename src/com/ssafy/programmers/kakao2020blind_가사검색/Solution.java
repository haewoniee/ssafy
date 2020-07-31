package com.ssafy.programmers.kakao2020blind_가사검색;



public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(s.solution(words, queries));
		
	}
	
    static class TrieNode {
        boolean isTerminal;
        TrieNode [] children;
        public TrieNode()
        {
            children = new TrieNode[26];
            isTerminal = false;
        }
    }
    
    
    public int[] solution(String[] words, String[] queries) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
        {
            TrieNode node = root;

            int len = words[i].length();
            for (int j = 0; j < len; j++)
            {
                char c = words[i].charAt(j);
                if (node.children[c-'a'] == null)
                {
                	node.children[c-'a'] = new TrieNode();
                }
                
                if (j == len - 1)
                {
                	if (node.children[c-'a'] == null)
                    {
                		node.isTerminal = true;
                    }
                	else
                	{
                		node.children[c-'a'].isTerminal = true;
                	}
                }
                else
                {
                    node = node.children[c-'a'];
                }
            }
        }
        for (int i = 0; i < queries.length; i++)
        {
        	TrieNode node = root;
        	int len = queries[i].length();
        	for (int j = 0; j < len; j++)
        	{
        		char c = queries[i].charAt(j);
        		if (c == '?')
        		{
        			
        		}
        	}
        }
        int[] answer = {};
        return answer;
    }
}