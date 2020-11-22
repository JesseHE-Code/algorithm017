package com.leetcode.pojo;

class Trie {

    private boolean isEnd;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (curr.next[c-'a'] == null) {
                curr.next[c-'a'] = new Trie();
            }
            curr = curr.next[c-'a'];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        Trie curr = this;
        for (char c : chars) {
            if (curr.next[c-'a'] != null) {
                curr = curr.next[c-'a'];
            } else {
                return false;
            }
        }
        return true && curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        Trie curr = this;
        for (char c : chars) {
            if (curr.next[c-'a'] != null && !curr.isEnd) {
                curr = curr.next[c-'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("ab");
        System.out.println(obj.search("abc"));
        System.out.println(obj.search("ab"));
        System.out.println(obj.startsWith("abc"));
        System.out.println(obj.startsWith("ab"));
        obj.insert("ab");
        System.out.println(obj.search("abc"));
        System.out.println(obj.startsWith("abc"));
        obj.insert("abc");
        System.out.println(obj.search("abc"));
        System.out.println(obj.startsWith("abc"));

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 *
 *
 * ["Trie","insert","search","search","startsWith","startsWith","insert","search","startsWith","insert","search","startsWith"]
 * [[],     ["ab"], ["abc"],  ["ab"],  ["abc"],     ["ab"],      ["ab"], ["abc"],  ["abc"],     ["abc"], ["abc"],  ["abc"]]
 */


