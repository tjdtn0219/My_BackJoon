import java.util.*;

class Solution {
    
    int[] answer;
    int[] sumArr;
    int[] arr;
    public int[] solution(int[] sequence, int k) {
        init(sequence);
        solve(k);
        return answer;
    }
    
    public void init(int[] sequence) {
        answer = new int[2];
        arr = new int[sequence.length+1];
        for(int i=0; i<sequence.length; i++) {
            arr[i+1] = sequence[i];
        }
        makeSumArr(sequence);
    }
    
    public void makeSumArr(int[] sequence) {
        sumArr = new int[sequence.length + 1];
        for(int i=1; i<sequence.length+1; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }
    }
    
    public void solve(int k) {
        int left = 1;
        int right = 1;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        while(left <= right && right < arr.length) {
            int sum = sumArr[right] - sumArr[left-1];
            if(sum == k) {
                if(right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                    minRight = right;
                }
                right++;
            } else if(sum > k) {
                left++;
            } else {    //sum < k
                right++;
            }
        }
        answer[0] = minLeft - 1;
        answer[1] = minRight - 1;
    }
}

class Pair {
    int left;
    int right;
    int gap;
    public Pair(int left, int right, int gap) {
        this.left = left;
        this.right = right;
        this.gap = gap;
    }
}