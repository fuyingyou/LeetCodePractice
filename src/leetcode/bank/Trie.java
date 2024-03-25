package leetcode.bank;

class Node {
    Node[] son = new Node[26];
    int cnt = 0;
}
public class Trie{
        private Node root;
        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] charArray = word.toCharArray();
            Node cur = root;
            for (char ch : charArray) {
                if (cur.son[ch - 'a'] == null) {
                    cur.son[ch - 'a'] = new Node();
                }
                cur = cur.son[ch - 'a'];
            }
            cur.cnt++;
        }

        public boolean search(String word) {
            char[] charArray = word.toCharArray();
            Node cur = root;
            for (char ch : charArray) {
                if (cur.son[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.son[ch - 'a'];
            }
            return cur.cnt > 0;
        }

        public boolean startsWith(String prefix) {
            char[] charArray = prefix.toCharArray();
            Node cur = root;
            for (char ch : charArray) {
                if (cur.son[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.son[ch - 'a'];
            }
            return true;
        }
}
