package lc2000_lc2099.lc2058;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prev = -1;
        int cur = -1;
        int next = -1;
        int pos = 1;
        int prevPos = -1;
        int res1 = Integer.MAX_VALUE;
        int res2 = -1;
        List<Integer> cc = new ArrayList<Integer>();
        ListNode curPos = head;
        while (curPos.next != null) {
            prev = cur;
            cur = curPos.val;
            next = curPos.next.val;
            if (cur < prev && cur < next && prev != -1 && next != -1 || cur > prev && cur > next && prev != -1 && next != -1) {
                if (pos < min) {
                    min = pos;
                }
                if (pos > max) {
                    max = pos;
                }
                if (res1 > pos - prevPos && prevPos != -1) {
                    res1 = pos - prevPos;
                }

                prevPos = pos;
                count++;
            }
            pos++;
            curPos = curPos.next;
        }

        if (count < 2) {
            return new int[]{-1, -1};
        }
        res2 = max - min;
        int[] res = {res1, res2};
        return res;
    }
}