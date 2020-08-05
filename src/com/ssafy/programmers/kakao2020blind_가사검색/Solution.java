package com.ssafy.programmers.kakao2020blind_가사검색;

import java.util.HashMap;

public class Solution {
	
	static int cnt;
	static HashMap<String, Integer> cache;
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(s.solution(words, queries));
	}
	
    static class TrieNode {
        boolean isTerminal;
        HashMap<Character, TrieNode> children;
        public TrieNode()
        {
            children = new HashMap<Character, TrieNode>();
            isTerminal = false;
        }
        
        int cntChild(int curDepth, int depth)
        {        	
        	int cnt = 0;
        	if (curDepth == depth)
        	{
            	if (this.isTerminal) cnt++;
            	return cnt;
        	}
        	for (TrieNode node : children.values())
        	{
        		cnt += node.cntChild(curDepth+1, depth);
        	}
        	return cnt;
        }
        
        
    }
    
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        cache = new HashMap<String, Integer>();
        
    	//알파벳으로 시작하는 정방향 트라이 입력
        TrieNode forward = new TrieNode();
        for (int i = 0; i < words.length; i++)
        {
            TrieNode node = forward;

            int len = words[i].length();
            for (int j = 0; j < len; j++)
            {
                char c = words[i].charAt(j);
                if (!node.children.containsKey(c))
                {
                	node.children.put(c, new TrieNode());
                }
                
                if (j == len - 1)
                {
                	if (!node.children.containsKey(c))
                    {
                		node.isTerminal = true;
                    }
                	else
                	{
                		node.children.get(c).isTerminal = true;
                	}
                }
                else
                {
                    node = node.children.get(c);
                }
            }
        }
        
        //??로 시작하는 경우 거꾸로 찾아야해서 리버스 트라이 입력
        TrieNode reverse = new TrieNode();
        for (int i = 0; i < words.length; i++)
        {
            TrieNode node = reverse;

            int len = words[i].length();
            for (int j = len-1; j >= 0; j--)
            {
                char c = words[i].charAt(j);
                if (!node.children.containsKey(c))
                {
                	node.children.put(c, new TrieNode());
                }
                
                if (j == 0)
                {
                	if (!node.children.containsKey(c))
                    {
                		node.isTerminal = true;
                    }
                	else
                	{
                		node.children.get(c).isTerminal = true;
                	}
                }
                else
                {
                    node = node.children.get(c);
                }
            }
        }
        
        for (int i = 0; i < queries.length; i++)
        {
        	if (cache.containsKey(queries[i]))
        	{
        		answer[i] = cache.get(queries[i]);
        		continue;
        	}
        	cnt = 0;
            if (queries[i].charAt(0) == '?')
            {
            	//reverse
            	cnt += find(reverse, new StringBuilder(queries[i]).reverse().toString(), 0);
            }
            else
            {
            	//forward
            	cnt += find(forward, queries[i], 0);
            }
            
            answer[i] = cnt;
            cache.put(queries[i], cnt);
        }
        return answer;
    }
    
    static int find(TrieNode node, String query, int idx)
    {
    	int cnt = 0;
    	if (idx == query.length() && node.isTerminal)
    	{
    		return 1;
    	}
    	if (node.children.containsKey(query.charAt(idx)))
    	{
    		cnt += find(node.children.get(query.charAt(idx)), query, idx+1);
    	}
    	else if (query.charAt(idx) == '?')
    	{
    		cnt += node.cntChild(idx, query.length());
    	}
    	
    	return cnt;
    }
    
}