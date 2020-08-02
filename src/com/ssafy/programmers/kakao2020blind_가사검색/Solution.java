package com.ssafy.programmers.kakao2020blind_가사검색;



public class Solution {
	
	static int cnt;
	
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
        
        int cntChild(int curDepth, int depth)
        {        	
        	int cnt = 0;
        	if (curDepth == depth)
        	{
            	if (this.isTerminal) cnt++;
            	return cnt;
        	}
        	for (int i = 0; i < children.length; i++)
        	{
        		if (children[i] != null)
        		{
        			cnt += children[i].cntChild(curDepth+1, depth);
        		}
        	}
        	if (this.isTerminal && curDepth >= depth) cnt++;
        	return cnt;
        }        
    }
    
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

    	//알파벳으로 시작하는 정방향 트라이 입력
        TrieNode forward = new TrieNode();
        for (int i = 0; i < words.length; i++)
        {
            TrieNode node = forward;

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
        
        //??로 시작하는 경우 거꾸로 찾아야해서 리버스 트라이 입력
        TrieNode reverse = new TrieNode();
        for (int i = 0; i < words.length; i++)
        {
            TrieNode node = reverse;

            int len = words[i].length();
            for (int j = len-1; j >= 0; j--)
            {
                char c = words[i].charAt(j);
                if (node.children[c-'a'] == null)
                {
                	node.children[c-'a'] = new TrieNode();
                }
                
                if (j == 0)
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
        	cnt = 0;
            if (queries[i].charAt(0) == '?')
            {
            	//reverse
            	answer[i] = findReverse(reverse, queries[i], queries[i].length(), queries[i].length()-1);
            	
            }
            else
            {
            	//forward
            	answer[i] = find(forward, queries[i], queries[i].length(), 0);
            }
        }

        
        return answer;
    }
    
    static int findReverse(TrieNode node, String toFind, int len, int idx)
    {
    	if (node.isTerminal)
    	{
    		return 1;
    	}
    	char c = toFind.charAt(idx);
    	if (c == '?')
    	{
    		return node.cntChild(0, idx + 1);
    	}
    	else if (node.children[c - 'a'] != null)
    	{
    		return findReverse(node.children[c-'a'], toFind, len, idx-1);
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    static int find(TrieNode node, String toFind, int len, int idx)
    {
    	if (node.isTerminal)
    	{
    		return 1;
    	}
    	char c = toFind.charAt(idx);
    	if (c == '?')
    	{
    		return node.cntChild(0, len - idx);
    	}
    	else if (node.children[c - 'a'] != null)
    	{
    		return find(node.children[c-'a'], toFind, len, idx+1);
    	}
    	else
    	{
    		return 0;
    	}
    }
}