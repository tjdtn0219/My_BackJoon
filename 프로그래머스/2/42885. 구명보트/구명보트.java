import java.util.*;

class Solution {
    public int solution(int[] arr, int limit) {
        int ans = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int w : arr) {
            list.add(w);
        }
        Collections.sort(list);
        
        // for(int w : arr) System.out.print(w + " ");
        // System.out.println();
        
        int left = 0;
        int right = list.size() - 1;
        
        int sum = 0;
        while(left <= right) {
            sum = list.get(left) + list.get(right);
            if(sum > limit) {
                ans++;
                right--;
            } else {
                ans++;
                left++; right--;
            }
        }
        
        
        return ans;
    }
}