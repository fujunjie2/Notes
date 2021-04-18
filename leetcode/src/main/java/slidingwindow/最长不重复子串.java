package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，求这个字符串最长的没有重复字符的子串的长度
 *
 * 'abcdabcabc' 最长重复子串长度 = 4
 */
public class 最长不重复子串 {

    public static void main(String[] args) {
//        System.out.println(solution("abcdabcabc"));
        Solution solution = new Solution();

        System.out.println(solution.checkRecord("PPALLP"));
    }

    public static int solution(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            char tmp = s.charAt(i);
            // 如果
            if (map.containsKey(tmp)) {
                left = Math.max(map.get(tmp) + 1, left);
            }
            map.put(tmp, i);
            max = Math.max(max, i - left + 1);

        }



        return max;
    }
}

class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int a = 0;
        char lastChar = 0;
        boolean award = true;
        int len = s.toCharArray().length;

        for (int i = 0; i < len; ++i) {
            char tmp = s.charAt(i);
            if (tmp == 'A') {
                ++a;
                if (a > 1) {
                    award = false;
                    break;
                }
            }
            if (lastChar == 'L' && tmp == 'L') {
                award = false;
                break;
            }
            lastChar = tmp;
        }
        return award;
    }
}