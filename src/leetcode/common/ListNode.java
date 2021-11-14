package leetcode.common;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            strB.append("->");
            strB.append(cur.val);
            cur = cur.next;
        }
        return strB.toString();
    }
}
