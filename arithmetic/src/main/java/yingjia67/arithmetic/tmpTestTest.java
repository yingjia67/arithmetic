package yingjia67.arithmetic;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;

public class tmpTestTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode current = head;
            ListNode lastNode = null;
            while (current != null) {
                ListNode tmpNode = current.next;
                current.next = lastNode;
                lastNode = current;
                current = tmpNode;
            }
            return lastNode;
        }

        public int ft(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            return ft(n - 2) + ft(n - 1);
        }

        public int ft1(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int tmp = b;
                b = a + b;
                a = tmp;
            }
            return b;
        }

        public void QuickSort(int[] nums) {
            QuickSort(nums, 0, nums.length - 1);
        }

        public void QuickSort(int[] nums, int left, int right) {
            int tmpLeft = left;
            int tmpRight = right;
            if (tmpLeft > tmpRight) {
                return;
            }
            int tmp = nums[tmpLeft];
            while (right > left) {
                while (nums[right] >= tmp && right > left) {
                    right--;
                }
                int tmp1 = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp1;
                while (nums[left] <= tmp && right > left) {
                    left++;
                }
                tmp1 = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp1;
            }
            QuickSort(nums, tmpLeft, left - 1);
            QuickSort(nums, left + 1, tmpRight);
        }


        public void mergeSort(int[] nums) {
            mergeSort(nums,0,(nums.length)/2,nums.length-1);
        }

        public void mergeSort(int[] nums, int left, int mid, int right) {
            if (left > right) {
                return;
            }
            mergeSort(nums,left,(left+mid)/2,mid);
            mergeSort(nums,mid+1,(mid+1+right)/2,right);
            int[] tmp = new int[right - left + 1];
            int i = 0;
            int j = 0;
            int k = 0;
            int len1 = mid - left + 1;
            int len2 = right - (mid + 1) + 1;
            while (i < len1 && j < len2) {
                if (nums[i] < nums[mid + 1 + j]) {
                    tmp[k++] = nums[i++];
                } else {
                    tmp[k++] = nums[mid + 1 + (j++)];
                }
            }
            while (i < len1) {
                tmp[k++] = nums[i++];
            }
            while (j < len2) {
                tmp[k++] = nums[mid + 1 + (j++)];
            }
            for (i = 0; i < nums.length; i++) {
                nums[i] = tmp[i];
            }

        }
    }



    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 4, 3, 8, 6};
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        ListNode node = solution.reverseList(node1);
//        System.out.println(node.val);
//        System.out.println(solution.ft(5));
//        System.out.println(solution.ft1(5));
//        solution.QuickSort(nums);
        solution.QuickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        ConcurrentLinkedQueue
                DelayQueue queue = new DelayQueue();
        CopyOnWriteArrayList;
        CopyOnWriteArraySet;
        ArrayList
    }
}
