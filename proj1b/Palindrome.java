import java.util.ArrayDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> originalDq = wordToDeque(word);
        Deque<Character> reverseDq = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            reverseDq.addFirst(word.charAt(i));
        }
        int len = originalDq.size();
        for (int i = 0; i < len ; i++) {
            if (reverseDq.get(i) != originalDq.get(i)) {
                return false;
            }
        }
        return true;
    }
}
