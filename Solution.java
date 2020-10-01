import java.util.Scanner;

/**
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class Solution {


    /**
     * Given a string S, return the "reversed" string where 
     * all characters that are not a letter stay in the same place, 
     * and all letters reverse their positions.
     * Runtime O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37 MB, less than 98.51% of Java online submissions.
     */
    static String reverseOnlyLetters(String S) {

        // **** character array ****
        char[] R = S.toCharArray();

        // **** for ease of use ****
        int len = R.length;
        
        // **** initialize indices ****
        int l = 0;
        int r = len - 1;

        // **** increment 'l' to point to letter (if needed) ****
        for ( ; l < len && !Character.isLetter(R[l]); l++);

        // **** decrement 'r' to point to a letter (if needed) ****
        for ( ; r >= 0 && !Character.isLetter(R[r]); r--);

        // **** loop swapping characters ****
        while (l < r) {

            // **** swap characters ****
            char t = R[l];
            R[l] = R[r];
            R[r] = t;

            // **** increment 'l' to point to a letter (if needed) ****
            l++;
            for ( ; l < len && !Character.isLetter(R[l]); l++);

            // **** decrement 'r' to point to a letter (if needed) ****
            r--;
            for ( ; r >= 0 && !Character.isLetter(R[r]); r--);
        }

        // **** return reversed string ****
        return new String(R);
    }


    /**
     * Given a string S, return the "reversed" string where 
     * all characters that are not a letter stay in the same place, 
     * and all letters reverse their positions.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37.1 MB, less than 96.62% of Java online submissions.
     * Runtime O(n)
     */
    static String reverseOnlyLetters1(String S) {

        // **** character array ****
        char[] R = S.toCharArray();

        // **** for ease of use ****
        int len = R.length;
        
        // **** initialize indices ****
        int l = 0;
        int r = len - 1;

        // **** loop swapping characters ****
        while (l < r) {

            // **** increment 'l' to point to a letter (if needed) ****
            while (l < r && !Character.isLetter(R[l]))
                l++;

            // **** decrement 'r' to point to a letter (if needed) ****
            while (l < r && !Character.isLetter(R[r]))
                r--;

            // **** swap characters ****
            char t = R[l];
            R[l] = R[r];
            R[r] = t;

            // **** update indices ****
            l++;
            r--;
        }

        // **** return reversed string ****
        return new String(R);
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read string ****
        String S = sc.nextLine();

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< S ==>" + S + "<== len: " + S.length());

        // **** reverse and display string ****
        System.out.println("main <<<  reverseOnlyLetters ==>" + reverseOnlyLetters(S) + "<==");

        // **** reverse and display string ****
        System.out.println("main <<< reverseOnlyLetters1 ==>" + reverseOnlyLetters1(S) + "<==");
    }
}