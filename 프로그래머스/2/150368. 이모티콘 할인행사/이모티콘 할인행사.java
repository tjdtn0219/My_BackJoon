import java.util.*;

class Solution {
    
    public final int[] discounts = {10, 20, 30, 40};
    public int n;
    public int[] comb;
    public PriorityQueue<Pair> pq;
    public int[] answer;
    
    public int[] solution(int[][] users, int[] emoticons) {
        init(emoticons);
        
        makeComb(0, users, emoticons);
        
        Pair ans = pq.poll();
        answer[0] = ans.joinCnt;
        answer[1] = ans.profit;
        int[] tmp = ans.discounts;
  
        return answer;
    }
    
    public void init(int[] emoticons) {
        answer = new int[2];
        n = emoticons.length;
        comb = new int[n];
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.joinCnt == o2.joinCnt) {
                return o2.profit - o1.profit;
            }
            return o2.joinCnt - o1.joinCnt;
        });
    }
    
    public void func(int[][] users, int[] emojis) {
        int joinCnt = 0;
        int buySum = 0;
        for(int[] user : users) {
            int sum = 0;
            int percent = user[0];
            int price = user[1];
            for(int i=0; i<n; i++) {
                int idx = comb[i];
                if(discounts[idx] >= percent) {
                    sum += emojis[i] * (100-discounts[idx]) / 100;
                }
            }
            if(sum >= price) {
                joinCnt++;
            } else {
                buySum += sum;
            }
        }

        pq.add(new Pair(joinCnt, buySum, comb));
    }
    
    public void makeComb(int k, int[][] users, int[] emojis) {
        if(k==n) {
            func(users, emojis);
            return ;
        }
        
        for(int i=0; i<4; i++) {
            comb[k] = i;
            makeComb(k+1, users, emojis);
        }
    }
}

class Pair {
    int joinCnt;
    int profit;
    int[] discounts;
    public Pair(int joinCnt, int profit, int[] discounts) {
        this.joinCnt = joinCnt;
        this.profit = profit;
        this.discounts = discounts;
    }
}