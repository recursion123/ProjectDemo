import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/2/24.
 */
public class test2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(l1.val + l2.val);
        if (l1.next == null && l2.next != null) {
            l3.next = l2.next;
        } else if (l2.next == null && l1.next != null) {
            l3.next = l1.next;
        } else if (l1.next != null && l2.next != null) {
            l3.next = addTwoNumbers(l1.next, l2.next);
        }
        return carry(l3);
    }

    public ListNode carry(ListNode l) {
        if (l.val < 10) {
            return l;
        } else {
            l.val = l.val % 10;
            if (l.next != null) {
                l.next.val++;
                l.next = carry(l.next);
            } else {
                l.next = new ListNode(1);
            }
        }
        return l;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int n = i + 1; n < nums.length; n++) {
                if (nums[i] + nums[n] == target) {
                    return new int[]{i, n};
                }
            }
        }
        return null;
    }

    public int lengthOfLongestSubstring_badway(String s) {
        char[] bytes = s.toCharArray();
        List list = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (list.contains(bytes[i])) {
                if (list.size() > length) {
                    length = list.size();
                }
                i = i - (list.size() - list.indexOf(bytes[i]));
                list.clear();
            } else {
                list.add(bytes[i]);
            }
        }
        return length <= list.size() ? list.size() : length;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    @Test
    public void test() {
        //System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
